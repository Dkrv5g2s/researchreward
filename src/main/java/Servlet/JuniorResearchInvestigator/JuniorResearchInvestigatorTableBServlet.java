package Servlet.JuniorResearchInvestigator;

import Service.JuniorResearchInvestigator.JuniorResearchInvestigatorTableAService;
import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JuniorResearchInvestigatorTableBServlet extends ServletEntryPoint {
    private JuniorResearchInvestigatorTableAService juniorResearchInvestigatorTableAService = new JuniorResearchInvestigatorTableAService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        getForm(req);
        req.getRequestDispatcher("WEB-INF/jsp/JuniorResearchInvestigator/JuniorResearchInvestigatorTableB.jsp").forward(req, resp);
    }
}
