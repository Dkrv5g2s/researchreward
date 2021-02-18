package Servlet.LectureProfessorAndHonoraryLectureProfessor;



import Service.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorAppDocInstructionsService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LectureProfessorAppDocInstructionsServlet extends ServletEntryPoint {
    private LectureProfessorAppDocInstructionsService lectureProfessorAppDocInstructionsService = new LectureProfessorAppDocInstructionsService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getForm(req);
        req.getRequestDispatcher("WEB-INF/jsp/LectureProfessorAndHonoraryLectureProfessor/LectureProfessorAppDocInstructions.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        
        getForm(req);
        
        String jsonString = readJSONString(req);
        
        if(!jsonString.equals("")) {
            JSONArray json = new JSONArray(jsonString);
            lectureProfessorAppDocInstructionsService.save(json,(String)session.getAttribute("userNumber"),(String)session.getAttribute("projectId"));

        }
    }

    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",lectureProfessorAppDocInstructionsService.show((String)session.getAttribute("projectId")));

    }
}
