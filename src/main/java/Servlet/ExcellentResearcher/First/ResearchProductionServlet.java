package Servlet.ExcellentResearcher.First;

import Service.ExcellentResearcher.ResearchProductionService;
import Service.Teacher.ProjectFillRateService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



public class ResearchProductionServlet extends ServletEntryPoint {

    private ResearchProductionService researchProductionService = new ResearchProductionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",researchProductionService.get(Integer.valueOf((String)session.getAttribute("projectId"))));
        req.setAttribute("readonly",session.getAttribute("readonly"));
        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/First/ResearchProduction.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        JSONArray json = new JSONArray(readJSONString(req));

        int projectId = Integer.parseInt((String)session.getAttribute("projectId"));
        researchProductionService.save(json, projectId);

        ProjectFillRateService projectFillRateService = new ProjectFillRateService();
        projectFillRateService.save(projectId, "ResearchProduction", json.getDouble(3));
    }
}
