package Servlet.SunshineScholarshipAward;


import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class PaperInformationServlet extends ServletEntryPoint {
    private static final String STAFF_URL = "WEB-INF/jsp/SunshineScholarshipAward/PaperInformationOfStaff.jsp";
    private static final String STUDENT_URL = "WEB-INF/jsp/SunshineScholarshipAward/PaperInformationOfStudent.jsp";
    private static final String LOGIN_URL = "WEB-INF/jsp/login/login.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println((String)session.getAttribute("userRole"));
        //userRole has been stored in session when login

        switch ((String)session.getAttribute("userRole")){
            case "teacher":
            case "admin":
                req.getRequestDispatcher(STAFF_URL).forward(req,resp);
                break;
            case "student":
                req.getRequestDispatcher(STUDENT_URL).forward(req,resp);
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
