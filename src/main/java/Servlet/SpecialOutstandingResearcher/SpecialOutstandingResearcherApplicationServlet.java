package Servlet.SpecialOutstandingResearcher;

import Bean.User.User;

import Service.Admin.SpecialOutstandingResearcherSettingService;
import Service.SpecialOutstandingResearcher.SpecialOutstandingResearcherApplicationService;
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

        SpecialOutstandingResearcherApplicationService service = new SpecialOutstandingResearcherApplicationService() ;
        SpecialOutstandingResearcherSettingService specialOutstandingResearcherSettingService = new SpecialOutstandingResearcherSettingService() ;
        String json_form = service.query( project_id ) ;
        JSONObject date_info = specialOutstandingResearcherSettingService.get() ;

        req.setAttribute("latest_data", json_form );
        req.setAttribute("date_info", date_info );

        if (readonly)
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/readonly/Special_Outstanding_Researcher_Application_Form.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/edit/Special_Outstanding_Researcher_Application_Form.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //User ud = (User)session.getAttribute("ud"); //正式 取得User 資料
        HttpSession session = req.getSession();
        JSONObject jsonObject = new JSONObject(req.getParameter("data")) ;

        String staff_code = session.getAttribute("userNumber").toString();

        this.logger.info( staff_code + " has modified SpecialOutstandingResearcherApplicationForm with json message " + jsonObject.toString() );

        SpecialOutstandingResearcherApplicationService service = new SpecialOutstandingResearcherApplicationService() ;

        //service.save(jsonObject, (String)session.getAttribute("userNumber")); /正式

        service.save(jsonObject, staff_code);
    }
}
