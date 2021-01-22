package Servlet.SunshineScholarshipAward;


import Service.ExcellentResearcher.PersonalInformationService;
import Service.Login.RoleAuthorizationService;
import Service.Login.RoleAuthorizationServiceImpl;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class SelectInformationServlet extends ServletEntryPoint {
    private GetUserIdentityService getUserIdentityService = new checkUserIdentityServiceImpl();
    private static final String STAFF_URL = "WEB-INF/jsp/SunshineScholarshipAward/GeneralInformationOfStaff.jsp";
    private static final String STUDENT_URL = "WEB-INF/jsp/SunshineScholarshipAward/GeneralInformationOfStudent.jsp";
    private static final String LOGIN_URL = "WEB-INF/jsp/login/login.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(session.getAttribute("userNumber") == null) {
            req.getRequestDispatcher(LOGIN_URL).forward(req, resp);
        }


        switch (getUserIdentityService.getRole((String)session.getAttribute("userNumber"))){
            case "teacher":
            case "admin":
                resp.sendRedirect(STAFF_URL);
                break;
            case "student":
                resp.sendRedirect(STUDENT_URL);
                break;
            default:
                req.getRequestDispatcher(LOGIN_URL).forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
