package Servlet.ExcellentResearcher.Second;

import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ExcellentResearcherCatalogServlet extends ServletEntryPoint {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("readonly",session.getAttribute("readonly"));
        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/Second/ExcellentResearcherCatalog.jsp").forward(req,resp);
    }
}
