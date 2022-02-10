package Servlet.Common;

import Bean.Common.OtherFile;
import Bean.SpecialOutstandingResearcher.CommonFunction;
import Dao.Common.Impl.OtherFileUploadDAOImpl;
import Dao.Common.OtherFileUploadDAO;
import Service.Common.OtherFileUploadService;
import Service.Teacher.RewardListService;
import Servlet.login.ServletEntryPoint;
import Utils.SystemUtil;
import fr.opensagres.xdocreport.document.json.JSONObject;
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

public class OtherFileUploadServlet extends ServletEntryPoint {
    private Logger logger = LogManager.getLogger(this.getClass());
    private static final int LIMIT_UPLOAD_SIZE = 1024*1024*20;//限制上傳大小 20M

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession() ;
        int project_id = Integer.parseInt(session.getAttribute("projectId").toString());

        OtherFileUploadService uploadService = new OtherFileUploadService();
        String json_form = "";
        json_form = uploadService.query(project_id);

        req.setAttribute("latest_data",json_form);

        RewardListService rewardListService = new RewardListService();
        String reward_type = rewardListService.getRewardType(project_id);
        req.setAttribute("catalogURL", rewardListService.getCatalogURL(reward_type));

        req.getRequestDispatcher("WEB-INF/jsp/Common/OtherFileUpload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String staff_code = session.getAttribute("userNumber").toString();
        String func = req.getParameter("func") ;

        if (func != null && func.equals("save_other_files")) {
            save_other_files(req, resp, staff_code) ;
        }else{
            OtherFileUploadService uploadService = new OtherFileUploadService();
            JSONObject json = new JSONObject(readJSONString(req));
            uploadService.save(Integer.parseInt((String) session.getAttribute("projectId")), json);
        }

    }

    private void save_other_files(HttpServletRequest req, HttpServletResponse resp, String staff_code) {
        HttpSession session = req.getSession();

        int project_id = Integer.parseInt((String)session.getAttribute("projectId"));
        TreeMap<String,String> parameterMap = new TreeMap<String,String>(); //用於存取form的parameter參數
        TreeMap<String, FileItem> fileMap = new TreeMap<String,FileItem>();  //用於存取form中的file資料
        try {
            SystemUtil.uploadRequestDataToMap(req, parameterMap, fileMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String doc_uuid = CommonFunction.setString(parameterMap.get("upload_paper_id"));
        String doc_description = CommonFunction.setString(parameterMap.get("upload_doc_description"));

        OtherFileUploadDAO dao = new OtherFileUploadDAOImpl();
        OtherFile uploadItem = dao.querySpecifiedDocument(doc_uuid);


        this.logger.info( staff_code + " has upload document_id=" + CommonFunction.setInt(parameterMap.get("upload_paper_id"),0)
                +"'s other file" );

        if(fileMap.get("other_file")!=null && fileMap.get("other_file").getSize() > LIMIT_UPLOAD_SIZE){
            // FE not upload file
            return;
        }

        if(fileMap.get("other_file")!=null && fileMap.get("other_file").getSize() > 0){ //有選擇檔案上傳
            //將檔案存至相對的位置並更新資料庫的選項

            String fileName =uploadItem.getDocumentId()+"_other_file.pdf";
            String path = this.getServletContext().getRealPath("/")+"WEB-INF\\uploadFile\\otherFile\\";
            this.logger.info( "upload fileName = " + fileName);
            this.logger.info( "upload filePath = " + path);

            try {
                if(!new File(path).isDirectory())
                    new File(path).mkdirs();

                FileOutputStream fos = new FileOutputStream(path+fileName);
                fos.write(fileMap.get("other_file").get());
                uploadItem.setProjectId(project_id);
                uploadItem.setDescription(doc_description);
                uploadItem.setDocFilePath("otherFile\\" + fileName);
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
