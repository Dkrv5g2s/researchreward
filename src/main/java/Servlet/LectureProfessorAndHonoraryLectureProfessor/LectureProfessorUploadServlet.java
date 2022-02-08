package Servlet.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorUpload;
import Bean.SpecialOutstandingResearcher.CommonFunction;
import Dao.LectureProfessorAndHonoraryLectureProfessor.Impl.LectureProfessorExcellenceUploadDAOImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceUploadDAO;
import Service.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceUploadService;
import Utils.SystemUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeMap;

public class LectureProfessorUploadServlet extends HttpServlet {

    private Logger logger = LogManager.getLogger(this.getClass());
    private static final int LIMIT_UPLOAD_SIZE = 1024*1024*20;//限制上傳大小 20M

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String method = req.getMethod();

        if (method.equals("GET")) {
            doGet(req, resp);
        }else if ( method.equals("POST")) {
            doPost(req, resp);
        }else {
            //doPost(req, resp);
            req.getRequestDispatcher("WEB-INF/jsp/login/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession() ;
        int project_id = Integer.valueOf(session.getAttribute("projectId").toString());
        boolean readonly = (Boolean)session.getAttribute("readonly");

        LectureProfessorExcellenceUploadService uploadService = new LectureProfessorExcellenceUploadService();
        String json_form = "";
        json_form = uploadService.query(project_id);

        req.setAttribute("latest_data",json_form);
        session.setAttribute( "readonly", readonly );

        req.getRequestDispatcher("WEB-INF/jsp/LectureProfessorAndHonoraryLectureProfessor/LectureProfessorFormCUploadFile.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        int project_id = Integer.valueOf((String)session.getAttribute("projectId"));

        String staff_code = session.getAttribute("userNumber").toString();
        String func = req.getParameter( "func" ) ;


        if ( func.equals( "save_certified_documents" ) ) {
            save_certified_documents(req,resp, staff_code) ;
        }
    }

    void save_certified_documents(HttpServletRequest req, HttpServletResponse resp, String staff_code) {
        HttpSession session = req.getSession();

        int project_id = Integer.valueOf((String)session.getAttribute("projectId"));
        TreeMap<String,String> parameterMap = new TreeMap<String,String>(); //用於存取form的parameter參數
        TreeMap<String, FileItem> fileMap = new TreeMap<String,FileItem>();  //用於存取form中的file資料
        try {
            SystemUtil.uploadRequestDataToMap(req,parameterMap,fileMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //

        String doc_uuid = CommonFunction.setString(parameterMap.get("upload_paper_id"));
        String doc_type = CommonFunction.setString(parameterMap.get("upload_doc_type"));
//to uuid?
        LectureProfessorExcellenceUploadDAO dao = new LectureProfessorExcellenceUploadDAOImpl();
        LectureProfessorUpload uploadItem = dao.query_specified_certified_document(doc_uuid);


        this.logger.info( staff_code + " has upload paper_id=" + CommonFunction.setInt(parameterMap.get("upload_paper_id"),0)
                +"'s certified_documents" );

        if(fileMap.get("certified_document")!=null&&fileMap.get("certified_document").getSize()>LIMIT_UPLOAD_SIZE){
            // FE not upload file
            return;
        }

        if(fileMap.get("certified_document")!=null&&fileMap.get("certified_document").getSize()>0){ //有選擇檔案上傳
            //將檔案存至相對的位置並更新資料庫的選項

            String fileName =uploadItem.getDocument_id()+"_certified_document.pdf";
            String path = this.getServletContext().getRealPath("/")+"WEB-INF\\uploadFile\\lecture_professor\\";
            this.logger.info( "upload fileName =" + fileName);
            this.logger.info( "upload lecture_professor certified_document_path=" + path);

            try {
                if(!new File(path).isDirectory())
                    new File(path).mkdirs();

                FileOutputStream fos = new FileOutputStream(path+fileName);
                fos.write(((FileItem)fileMap.get("certified_document")).get());
                uploadItem.setProjectID(project_id);
                uploadItem.setDocType(doc_type);
                uploadItem.setCertifiedDocFilePath( "lecture_professor\\" + fileName );
                dao.save(uploadItem) ;
                fos.close();
            }
            catch( Exception e ) {
                e.printStackTrace();

            }

        }
        else if( fileMap.get("file").getSize()==0 ){
            return;
        }
    }

}
