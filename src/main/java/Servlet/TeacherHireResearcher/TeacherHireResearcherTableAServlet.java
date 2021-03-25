package Servlet.TeacherHireResearcher;

import Service.Admin.AwardTimeLimitService;
import Service.TeacherHireResearcher.TeacherHireResearcherTableAService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TeacherHireResearcherTableAServlet extends ServletEntryPoint {
    private TeacherHireResearcherTableAService teacherHireResearcherTableAService = new TeacherHireResearcherTableAService();
    private AwardTimeLimitService awardTimeLimitService = new AwardTimeLimitService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json", teacherHireResearcherTableAService.get((String)session.getAttribute("projectId")));
        req.setAttribute("fwci", awardTimeLimitService.get().getDouble("fwciOfFiveYear"));
        req.setAttribute("h5Index", awardTimeLimitService.get().getDouble("h5Index"));

        req.getRequestDispatcher("WEB-INF/jsp/TeacherHireResearcher/TeacherHireResearcherTableA.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        JSONObject json = new JSONObject(readJSONString(req));

        teacherHireResearcherTableAService.save(json,(String)session.getAttribute("projectId"));

        resp.sendRedirect("/TeacherHireResearcherCatalog");
    }
}
