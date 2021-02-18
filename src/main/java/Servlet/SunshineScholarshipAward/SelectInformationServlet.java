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
import java.util.HashMap;
import java.util.Map;


public class SelectInformationServlet extends ServletEntryPoint {
    private static final String STAFF_URL = "WEB-INF/jsp/SunshineScholarshipAward/GeneralInformationOfStaff.jsp";
    private static final String STUDENT_URL = "WEB-INF/jsp/SunshineScholarshipAward/GeneralInformationOfStudent.jsp";
    private static final String LOGIN_URL = "WEB-INF/jsp/login/login.jsp";
    private GeneralInformationService generalInformationService= new GeneralInformationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //userRole has been stored in session when login
        System.out.println("SelectInformationServlet:"+req.toString());
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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShowSessionValue(session);

        JSONObject json = new JSONObject(readJSONString(req));
        generalInformationService.save(json,Integer.valueOf((String)session.getAttribute("projectId")));

    }

    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",generalInformationService.get(Integer.valueOf((String)session.getAttribute("projectId"))));
    }

    private void ShowSessionValue(HttpSession session){
        for(int i =0;i<session.getValueNames().length;i++)
            System.out.println("Key:"+session.getValueNames()[i]+"value:"+session.getAttribute(session.getValueNames()[i]));
    }

}
