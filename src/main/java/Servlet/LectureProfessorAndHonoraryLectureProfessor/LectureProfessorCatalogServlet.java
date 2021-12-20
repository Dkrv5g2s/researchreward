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

        //int project_id = 1 ;
        Boolean readonly = false ;
        // project_id = ((RewardProject)request.getAttribute( "reward_project" )).getProject_id() ;

        HttpSession session = req.getSession() ;
        session.setAttribute( "project_id", Integer.valueOf((String) session.getAttribute("projectId")));
        session.setAttribute( "readonly", readonly );
        req.getRequestDispatcher("WEB-INF/jsp/LectureProfessorAndHonoraryLectureProfessor/LectureProfessorCatalog.jsp").forward(req, resp);

    }


}
