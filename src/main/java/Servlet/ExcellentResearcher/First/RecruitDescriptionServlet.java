package Servlet.ExcellentResearcher.First;

import Service.ExcellentResearcher.RecruitDescriptionService;
import Service.Teacher.ProjectFillRateService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RecruitDescriptionServlet extends ServletEntryPoint {

    private RecruitDescriptionService recruitDescriptionService = new RecruitDescriptionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",recruitDescriptionService.get(Integer.parseInt((String)session.getAttribute("projectId"))));
        req.setAttribute("readonly",session.getAttribute("readonly"));
        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/First/RecruitDescription.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        JSONObject json = new JSONObject(readJSONString(req));

        int projectId = Integer.parseInt((String)session.getAttribute("projectId"));
        recruitDescriptionService.save(json, projectId);

        ProjectFillRateService projectFillRateService = new ProjectFillRateService();
        projectFillRateService.save(projectId, "RecruitDescription", json.getDouble("fill_rate"));
    }
}
