package Servlet.SpecialOutstandingResearcher;

import Bean.SpecialOutstandingResearcher.CommonFunction;
import Bean.SpecialOutstandingResearcher.PaperPerformance;
import Bean.SpecialOutstandingResearcher.PaperPerformanceDescriptionForm;
import Bean.User.User;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;
import Service.SpecialOutstandingResearcher.PaperPerformanceDescriptionService;
import Utils.SystemUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

public class PaperPerformanceDescriptionUploadServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass());//Log4j
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
        System.out.println("PaperPerformanceDescriptionUploadServlet");
        int project_id = Integer.valueOf((String)session.getAttribute("projectId"));
        boolean readonly = (Boolean)session.getAttribute("readonly");
        String table_d = req.getParameter("table_d");

        PaperPerformanceDescriptionService service = new PaperPerformanceDescriptionService() ;
        String json_form = "";
        if (table_d!=null && table_d.equals("1"))
            json_form = service.query( -project_id );
        else
            json_form = service.query( project_id );

        String reward_type = service.queryRewardType(project_id);

        req.setAttribute("latest_data", json_form );
        req.setAttribute("reward_type", reward_type );

        if (table_d!=null && table_d.equals("1")){
            req.getRequestDispatcher("WEB-INF/jsp/TeacherHireResearcher/TeacherHireResearcherTableDUpload.jsp").forward(req, resp);
        }else{
            if ( readonly )
                req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/readonly/Paper_Performance_Description_UploadFile.jsp").forward(req, resp);
            else
                req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/edit/Paper_Performance_Description_UploadFile.jsp").forward(req, resp);
        }

    }

    void save_joint_authorization_agreement(HttpServletRequest req, HttpServletResponse resp, String staff_code) {
        TreeMap<String,String> parameterMap = new TreeMap<String,String>(); //用於存取form的parameter參數
        TreeMap<String, FileItem> fileMap = new TreeMap<String,FileItem>();  //用於存取form中的file資料
        try {
            SystemUtil.uploadRequestDataToMap(req,parameterMap,fileMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int paper_id = CommonFunction.setInt(parameterMap.get("upload_paper_id"),0);
        PaperPerformanceDescriptionDAO dao = new PaperPerformanceDescriptionDAOImpl() ;
        PaperPerformance paperPerformance = dao.query_specified_paper_performance(paper_id) ;

        this.logger.info( staff_code + " has upload paper_id=" + CommonFunction.setInt(parameterMap.get("upload_paper_id"),0) +"'s joint authorization agreement" );

        if(fileMap.get("joint_authorization_agreement")!=null&&fileMap.get("joint_authorization_agreement").getSize()>LIMIT_UPLOAD_SIZE){

            return;
        }
        if(fileMap.get("joint_authorization_agreement")!=null&&fileMap.get("joint_authorization_agreement").getSize()>0){ //有選擇檔案上傳
            //將檔案存至相對的位置並更新資料庫的選項

            String fileName = CommonFunction.setInt(parameterMap.get("paper_id"),0)+"_joint_authorization_agreement.pdf";
            //String path = this.getServletContext().getRealPath("/")+"WEB-INF\\uploadFile\\paper_performance\\";
            String path ="C:\\apache-tomcat-8.5.55\\webapps\\RRS_uploadFile\\paper_performance\\";


            try {
                if(!new File(path).isDirectory())
                    new File(path).mkdir();

                FileOutputStream fos = new FileOutputStream(path+fileName);
                fos.write(((FileItem)fileMap.get("joint_authorization_agreement")).get());

                paperPerformance.setJoint_authorization_agreement_file_path( "paper_performance\\" + fileName );
                dao.update_specified_paper_performance( paperPerformance ) ;

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

    void save_paper_home(HttpServletRequest req, HttpServletResponse resp, String staff_code) {
        TreeMap<String,String> parameterMap = new TreeMap<String,String>(); //用於存取form的parameter參數
        TreeMap<String, FileItem> fileMap = new TreeMap<String,FileItem>();  //用於存取form中的file資料
        try {
            SystemUtil.uploadRequestDataToMap(req,parameterMap,fileMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int paper_id = CommonFunction.setInt(parameterMap.get("upload_paper_id"),0);
        PaperPerformanceDescriptionDAO dao = new PaperPerformanceDescriptionDAOImpl() ;
        PaperPerformance paperPerformance = dao.query_specified_paper_performance(paper_id) ;

        this.logger.info( staff_code + " has upload paper_id=" + CommonFunction.setInt(parameterMap.get("upload_paper_id"),0) +"'s paper home page" );

        if(fileMap.get("paper_home")!=null&&fileMap.get("paper_home").getSize()>LIMIT_UPLOAD_SIZE){

            return;
        }
        if(fileMap.get("paper_home")!=null&&fileMap.get("paper_home").getSize()>0){ //有選擇檔案上傳
            //將檔案存至相對的位置並更新資料庫的選項

            String fileName = CommonFunction.setInt(parameterMap.get("paper_id"),0)+"_paper_home.pdf";
            //String path = this.getServletContext().getRealPath("/")+"WEB-INF\\uploadFile\\paper_performance\\";
            String path ="C:\\apache-tomcat-8.5.55\\webapps\\RRS_uploadFile\\paper_performance\\";


            try {
                if(!new File(path).isDirectory())
                    new File(path).mkdir();

                FileOutputStream fos = new FileOutputStream(path+fileName);
                fos.write(((FileItem)fileMap.get("paper_home")).get());

                paperPerformance.setPaper_home_file_path( "paper_performance\\" + fileName );

                dao.update_specified_paper_performance( paperPerformance ) ;

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //User ud = (User)session.getAttribute("ud"); //正式 取得User 資料
        User user = new User( "root", "password1234", "上帝", "108598065" ) ;

        String func = req.getParameter( "func" ) ;

        if ( func.equals( "joint_authorization_agreement" ) ) {
            save_joint_authorization_agreement(req,resp, user.getStaff_code()) ;
        }else if ( func.equals( "paper_home" ) ){
            save_paper_home( req,resp,user.getStaff_code() ) ;
        }

    }
}
