package Servlet.ExcellentResearcher;

import Service.ExcellentResearcher.ResearchProductionService;
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

        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/First/ResearchProduction.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        JSONArray json = new JSONArray(readJSONString(req));
        researchProductionService.save(json,Integer.valueOf((String)session.getAttribute("projectId")));

        doGet(req,resp);
    }
}
