package Servlet.JuniorResearchInvestigator;

import Service.JuniorResearchInvestigator.JuniorResearchInvestigatorService;
import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class JuniorResearchInvestigatorPrintServlet extends ServletEntryPoint {

    private JuniorResearchInvestigatorService juniorResearchInvestigatorService = new JuniorResearchInvestigatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int projectId = turnIdInSessionToInt(session, "projectId");
        req.setAttribute("data", juniorResearchInvestigatorService.show(projectId));
        req.getRequestDispatcher("WEB-INF/jsp/JuniorResearchInvestigator/Review/JuniorResearchInvestigatorPrint.jsp").forward(req, resp);
    }

    private int turnIdInSessionToInt(HttpSession session, String id){
        return Integer.parseInt(session.getAttribute(id).toString());
    }
}
