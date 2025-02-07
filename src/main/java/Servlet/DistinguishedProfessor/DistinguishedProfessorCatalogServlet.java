package Servlet.DistinguishedProfessor;


import Servlet.login.ServletEntryPoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DistinguishedProfessorCatalogServlet extends ServletEntryPoint {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userRole = session.getAttribute("userRole").toString();
        req.setAttribute("role", userRole);
        req.getRequestDispatcher("WEB-INF/jsp/DistinguishedProfessor/DistinguishedProfessorCatalog.jsp").forward(req, resp);

    }


}
