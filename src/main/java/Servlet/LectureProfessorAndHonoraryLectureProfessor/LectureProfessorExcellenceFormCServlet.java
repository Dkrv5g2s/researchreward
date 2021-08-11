package Servlet.LectureProfessorAndHonoraryLectureProfessor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormCService;
import Service.Teacher.ProjectFillRateService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class LectureProfessorExcellenceFormCServlet extends ServletEntryPoint {

    private LectureProfessorExcellenceFormCService lectureProfessorExcellenceFormCService = new LectureProfessorExcellenceFormCService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getForm(req);

        req.getRequestDispatcher("WEB-INF/jsp/LectureProfessorAndHonoraryLectureProfessor/LectureProfessorExcellenceFormC.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String projectId = session.getAttribute("projectId").toString();

        getForm(req);

        String jsonString = readJSONString(req);

        if(!jsonString.equals("")) {
            JSONObject json = new JSONObject(jsonString);
            lectureProfessorExcellenceFormCService.save(json,(String)session.getAttribute("userNumber"),(String)session.getAttribute("projectId"));
            ProjectFillRateService projectFillRateService = new ProjectFillRateService();
            projectFillRateService.save(Integer.parseInt(projectId), "LectureProfessorExcellenceFormC", json.getDouble("fill_rate"));
            resp.setContentType("text/html;charset=UTF-8");
            Map map = new HashMap();
            map.put("status", "存檔成功");
            String jackyJsonString = map.toString();
            JSONObject jsonReturn = new JSONObject(jackyJsonString);
            resp.getWriter().write(String.valueOf(jsonReturn));

        }

    }

    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",lectureProfessorExcellenceFormCService.show((String)session.getAttribute("userNumber"),(String)session.getAttribute("projectId")));

    }

}