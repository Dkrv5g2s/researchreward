package Servlet.JuniorResearchInvestigator;

import Service.JuniorResearchInvestigator.JuniorResearchInvestigatorCatalogService;
import Service.Teacher.RewardListService;
import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class JuniorResearchInvestigatorCatalogServlet extends ServletEntryPoint {
    private JuniorResearchInvestigatorCatalogService juniorResearchInvestigatorCatalogService = new JuniorResearchInvestigatorCatalogService();
    private RewardListService rewardListService = new RewardListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/JuniorResearchInvestigator/JuniorResearchInvestigatorCatalog.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession() ;
        int projectId = Integer.parseInt(session.getAttribute("projectId").toString());
        rewardListService.updateRewardStatusToNext(projectId);
    }
}
