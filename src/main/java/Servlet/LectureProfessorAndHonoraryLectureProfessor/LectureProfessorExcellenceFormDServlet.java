package Servlet.LectureProfessorAndHonoraryLectureProfessor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormDService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LectureProfessorExcellenceFormDServlet extends ServletEntryPoint {

    private LectureProfessorExcellenceFormDService lectureProfessorExcellenceFormDService = new LectureProfessorExcellenceFormDService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getForm(req);

        req.getRequestDispatcher("WEB-INF/jsp/LectureProfessorAndHonoraryLectureProfessor/LectureProfessorExcellenceFormD.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        getForm(req);

        String jsonString = readJSONString(req);

        if(!jsonString.equals("")) {
            JSONObject json = new JSONObject(jsonString);
            lectureProfessorExcellenceFormDService.save(json,(String)session.getAttribute("userNumber"),(String)session.getAttribute("projectId"));
        }

    }

    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",lectureProfessorExcellenceFormDService.show((String)session.getAttribute("userNumber"),(String)session.getAttribute("projectId")));

    }

}