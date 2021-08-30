package Servlet.SpecialOutstandingResearcher;

import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SpecialOutstandingResearcherPrintServlet extends ServletEntryPoint {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/SpecialOutstandingResearcherPrint.jsp").forward(req, resp);
    }

}
