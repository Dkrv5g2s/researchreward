package Servlet.DistinguishedProfessor;

import Bean.Project.RewardProject;
import Bean.User.User;
import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;
import Service.SpecialOutstandingResearcher.PaperPerformanceDescriptionService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DistinguishedProfessorCatalogServlet extends ServletEntryPoint {
    private Logger logger = Logger.getLogger(this.getClass());//Log4j

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int project_id = 1 ;
        Boolean readonly = true ;
        // project_id = ((RewardProject)request.getAttribute( "reward_project" )).getProject_id() ;

        HttpSession session = req.getSession() ;
        session.setAttribute( "project_id", project_id );

        req.getRequestDispatcher("WEB-INF/jsp/DistinguishedProfessor/DistinguishedProfessorCatalog.jsp").forward(req, resp);

    }


}
