package Servlet.TeacherHireResearcher;

import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeacherHireResearcherCatalogServlet extends ServletEntryPoint {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/TeacherHireResearcher/TeacherHireResearcherCatalog.jsp").forward(req,resp);
    }
}
