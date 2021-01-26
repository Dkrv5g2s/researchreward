package Servlet.SunshineScholarshipAward;


import Service.SunshineScholarshipAward.GeneralInformationService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class SelectInformationServlet extends ServletEntryPoint {
    private static final String STAFF_URL = "WEB-INF/jsp/SunshineScholarshipAward/GeneralInformationOfStaff.jsp";
    private static final String STUDENT_URL = "WEB-INF/jsp/SunshineScholarshipAward/GeneralInformationOfStudent.jsp";
    private static final String LOGIN_URL = "WEB-INF/jsp/login/login.jsp";
    private GeneralInformationService generalInformationService= new GeneralInformationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
//        System.out.println((String)session.getAttribute("userRole"));
//        System.out.println((String)session.getAttribute("projectId"));
        //userRole has been stored in session when login
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",generalInformationService.get(Integer.valueOf((String)session.getAttribute("projectId"))));


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

//        System.out.println(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        getForm(req);

        JSONObject json = new JSONObject(readJSONString(req));
        generalInformationService.save(json,Integer.valueOf((String)session.getAttribute("projectId")));
        req.getRequestDispatcher("WEB-INF/jsp/SunshineScholarshipAward/PaperInformationOfStaff.jsp").forward(req, resp);
    }

    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",generalInformationService.get(Integer.valueOf((String)session.getAttribute("projectId"))));
    }

}
