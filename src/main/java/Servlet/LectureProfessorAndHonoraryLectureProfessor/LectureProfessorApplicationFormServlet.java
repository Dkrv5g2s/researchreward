package Servlet.LectureProfessorAndHonoraryLectureProfessor;

import Service.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorApplicationFormService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LectureProfessorApplicationFormServlet extends ServletEntryPoint {
    private LectureProfessorApplicationFormService lectureProfessorApplicationFormService = new LectureProfessorApplicationFormService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getForm(req);
        req.getRequestDispatcher("WEB-INF/jsp/LectureProfessorAndHonoraryLectureProfessor/LectureProfessorApplicationForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        getForm(req);

        String jsonString = readJSONString(req);

        if(!jsonString.equals("")) {
            JSONObject json = new JSONObject(jsonString);
            System.out.println("POST");
            lectureProfessorApplicationFormService.save(json,(String)session.getAttribute("userNumber"),(String)session.getAttribute("projectId"));
        }
    }

    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",lectureProfessorApplicationFormService.show((String)session.getAttribute("userNumber"),(String)session.getAttribute("projectId")));

    }
}
