package Servlet.TeacherHireResearcher;

import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TeacherHireResearcherCatalogServlet extends ServletEntryPoint {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession() ;
        int project_id = turnIdInSessionToInt(session, "projectId");

        Boolean readonly = false ;//TODO role判斷

        session.setAttribute( "project_id", project_id );
        session.setAttribute( "readonly", readonly );

        req.getRequestDispatcher("WEB-INF/jsp/TeacherHireResearcher/TeacherHireResearcherCatalog.jsp").forward(req,resp);
    }

    private int turnIdInSessionToInt(HttpSession session, String id){
        return Integer.parseInt(session.getAttribute(id).toString());
    }
}
