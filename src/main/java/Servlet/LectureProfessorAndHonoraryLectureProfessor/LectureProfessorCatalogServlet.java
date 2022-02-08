package Servlet.LectureProfessorAndHonoraryLectureProfessor;

import Servlet.login.ServletEntryPoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LectureProfessorCatalogServlet extends ServletEntryPoint {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession() ;
        boolean readonly = (Boolean)session.getAttribute("readonly");
        session.setAttribute( "project_id", Integer.valueOf((String) session.getAttribute("projectId")));
        session.setAttribute( "readonly", readonly );
        req.getRequestDispatcher("WEB-INF/jsp/LectureProfessorAndHonoraryLectureProfessor/LectureProfessorCatalog.jsp").forward(req, resp);

    }


}
