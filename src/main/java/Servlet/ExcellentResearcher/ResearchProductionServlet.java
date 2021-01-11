package Servlet.ExcellentResearcher;

import Service.ExcellentResearcher.ResearchProductionService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ResearchProductionServlet extends ServletEntryPoint {

    private ResearchProductionService researchProductionService = new ResearchProductionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/ResearchProduction.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        JSONObject json = new JSONObject(readJSONString(req));
        researchProductionService.save(json,(String)session.getAttribute("userNumber"));

        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/ResearchProduction.jsp").forward(req, resp);
    }
}
