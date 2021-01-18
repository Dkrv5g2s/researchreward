package Servlet.SpecialOutstandingResearcher;

import Bean.User.User;
import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAO;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAOImpl;
import Service.SpecialOutstandingResearcher.PaperPerformanceDescriptionService;
import Service.SpecialOutstandingResearcher.SpecialOutstandingResearcherApplicationService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PaperPerformanceDescriptionServlet extends ServletEntryPoint {
    private Logger logger = Logger.getLogger(this.getClass());//Log4j

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

        int project_id ;
        // project_id = ((RewardProject)request.getAttribute( "reward_project" )).getProject_id() ;
        project_id = 1 ; //temp precondition

        PaperPerformanceDescriptionService service = new PaperPerformanceDescriptionService() ;
        String json_form = service.query( project_id ) ;

        req.setAttribute("latest_data", json_form );

        req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/Paper_Performance_Description_Form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        JSONObject jsonObject = new JSONObject(req.getParameter("data")) ;
        //User ud = (User)session.getAttribute("ud"); //正式 取得User 資料
        User user = new User( "root", "password1234", "上帝", "108598065" ) ;

        this.logger.info( user.getStaff_code() + " has modified PaperPerformanceDescriptionForm with json message " + jsonObject.toString() );

        PaperPerformanceDescriptionService service = new PaperPerformanceDescriptionService() ;

        //service.save(jsonObject, (String)session.getAttribute("userNumber")); //正式
        service.save(jsonObject);


    }
}