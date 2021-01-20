package Servlet.ExcellentResearcher;

import Service.ExcellentResearcher.RecruitDescriptionService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
        req.setAttribute("json",recruitDescriptionService.get((int)session.getAttribute("projectId")));

        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/RecruitDescription.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        JSONObject json = new JSONObject(readJSONString(req));
        recruitDescriptionService.save(json,(int)session.getAttribute("projectId"));

        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/CatalogOfWorks.jsp").forward(req, resp);
    }
}
