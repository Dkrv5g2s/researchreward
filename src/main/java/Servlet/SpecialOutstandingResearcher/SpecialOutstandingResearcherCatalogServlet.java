package Servlet.SpecialOutstandingResearcher;


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

public class SpecialOutstandingResearcherCatalogServlet extends ServletEntryPoint {
    private Logger logger = Logger.getLogger(this.getClass());//Log4j

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();

        if (method.equals("GET")) {
            doGet(req, resp);
        }else if ( method.equals("POST")) {
            doPost(req, resp);
        }else {
            req.getRequestDispatcher("WEB-INF/jsp/login/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/Special_Outstanding_Researcher_Catalog.jsp").forward(req, resp);
    }

}
