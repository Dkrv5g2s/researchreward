package Servlet.SpecialOutstandingResearcher;

import Bean.User.User;

import Service.Admin.SpecialOutstandingResearcherSettingService;
import Service.SpecialOutstandingResearcher.SpecialOutstandingResearcherApplicationService;
import Service.Teacher.ProjectFillRateService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SpecialOutstandingResearcherApplicationServlet extends ServletEntryPoint {
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

            req.getRequestDispatcher("WEB-INF/jsp/login/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession() ;
        int project_id = Integer.valueOf(session.getAttribute("projectId").toString());
        boolean readonly = (Boolean)session.getAttribute("readonly");
        String userRole = session.getAttribute("userRole").toString();

        SpecialOutstandingResearcherApplicationService service = new SpecialOutstandingResearcherApplicationService() ;
        SpecialOutstandingResearcherSettingService specialOutstandingResearcherSettingService = new SpecialOutstandingResearcherSettingService() ;
        String json_form = service.query( project_id ) ;
        String json_review = service.query_review( project_id ) ;

        JSONObject date_info = specialOutstandingResearcherSettingService.get() ;

        req.setAttribute("latest_data", json_form );
        req.setAttribute("latest_review_data", json_review );
        req.setAttribute("date_info", date_info );
        req.setAttribute("role", userRole); //userRole


        if (readonly)
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/readonly/Special_Outstanding_Researcher_Application_Form.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/edit/Special_Outstanding_Researcher_Application_Form.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //User ud = (User)session.getAttribute("ud"); //正式 取得User 資料
        HttpSession session = req.getSession();
        String func = req.getParameter("func") ;
        String staff_code = session.getAttribute("userNumber").toString();

        SpecialOutstandingResearcherApplicationService service = new SpecialOutstandingResearcherApplicationService() ;

        //service.save(jsonObject, (String)session.getAttribute("userNumber")); /正式
        if ( func.equals("save") ) {
            JSONObject jsonObject = new JSONObject(req.getParameter("data")) ;
            this.logger.info( staff_code + " has modified SpecialOutstandingResearcherApplicationForm with json message " + jsonObject.toString() );
            service.save(jsonObject, staff_code);

            ProjectFillRateService projectFillRateService = new ProjectFillRateService();
            projectFillRateService.save(Integer.parseInt(session.getAttribute("projectId").toString()), "SpecialOutstandingResearcherApplicationForm", jsonObject.getDouble("fill_rate"));
        }

        if ( func.equals("review") ) {
            JSONObject json_review = new JSONObject(req.getParameter("review_data")) ;
            service.save_review(json_review, staff_code);
        }

    }
}
