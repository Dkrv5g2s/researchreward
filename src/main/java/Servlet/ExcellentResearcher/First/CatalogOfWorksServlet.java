package Servlet.ExcellentResearcher.First;

import Service.ExcellentResearcher.CatalogOfWorksService;
import Service.Teacher.ProjectFillRateService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CatalogOfWorksServlet extends ServletEntryPoint {


    private CatalogOfWorksService catalogsService = new CatalogOfWorksService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",catalogsService.get(Integer.parseInt((String)session.getAttribute("projectId"))));
        req.setAttribute("readonly",session.getAttribute("readonly"));
        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/First/CatalogOfWorks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        JSONObject json = new JSONObject(readJSONString(req));
        int projectId = Integer.parseInt((String)session.getAttribute("projectId"));
        catalogsService.save(json, projectId);

        ProjectFillRateService projectFillRateService = new ProjectFillRateService();
        projectFillRateService.save(projectId, "CatalogOfWorks", json.getDouble("fill_rate"));
    }
}
