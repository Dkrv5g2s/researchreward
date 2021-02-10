package Servlet.DistinguishedProfessor;


import Servlet.login.ServletEntryPoint;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DistinguishedProfessorCatalogServlet extends ServletEntryPoint {
    private Logger logger = Logger.getLogger(this.getClass());//Log4j

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Boolean readonly = false ;

        HttpSession session = req.getSession() ;
        session.setAttribute( "project_id", Integer.valueOf((String) session.getAttribute("projectId")));
        session.setAttribute( "readonly", readonly );

        req.getRequestDispatcher("WEB-INF/jsp/DistinguishedProfessor/DistinguishedProfessorCatalog.jsp").forward(req, resp);

    }


}
