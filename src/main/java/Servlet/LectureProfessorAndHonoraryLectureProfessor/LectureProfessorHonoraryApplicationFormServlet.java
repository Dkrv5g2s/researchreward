package Servlet.LectureProfessorAndHonoraryLectureProfessor;

import Service.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorHonoraryApplicationFormService;
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

public class LectureProfessorHonoraryApplicationFormServlet extends ServletEntryPoint {
    private LectureProfessorHonoraryApplicationFormService lectureProfessorHonoraryApplicationFormService = new LectureProfessorHonoraryApplicationFormService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getForm(req);
        req.getRequestDispatcher("WEB-INF/jsp/LectureProfessorAndHonoraryLectureProfessor/LectureProfessorHonoraryApplicationForm.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
     //   System.out.println("POSTAAAA");
        getForm(req);
        String jsonString = readJSONString(req);
        if(!jsonString.equals("")) {
            JSONObject json = new JSONObject(jsonString);
    //        System.out.println("POST");
            lectureProfessorHonoraryApplicationFormService.save(json,(String)session.getAttribute("userNumber"),(String)session.getAttribute("projectId"));
        }
        resp.setContentType("text/html;charset=UTF-8");
        Map map = new HashMap();
        map.put("status", "存檔成功");
        String jackyJsonString = map.toString();
        JSONObject json = new JSONObject(jackyJsonString);
        resp.getWriter().write(String.valueOf(json));
    }

    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",lectureProfessorHonoraryApplicationFormService.show((String)session.getAttribute("userNumber"),(String)session.getAttribute("projectId")));

    }
}
