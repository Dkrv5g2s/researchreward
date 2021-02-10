package Servlet.SpecialOutstandingResearcher;

import Bean.User.User;
import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAO;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAOImpl;
import Service.DistinguishedProfessor.DistinguishedProfessorTableAService;
import Service.SpecialOutstandingResearcher.OutstandingPerformanceDescriptionService;
import Service.SpecialOutstandingResearcher.SpecialOutstandingResearcherApplicationService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class OutstandingPerformanceDescriptionServlet extends ServletEntryPoint {
    private Logger logger = Logger.getLogger(this.getClass());//Log4j

    private OutstandingPerformanceDescriptionService outstandingPerformanceDescriptionService = new OutstandingPerformanceDescriptionService();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getForm(req);

        req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/edit/Outstanding_Performance_Description_Form.jsp").forward(req, resp);
        // "WEB-INF/jsp/SpecialOutstandingResearcher/edit/Outstanding_Performance_Description_Form.jsp"
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        getForm(req);

        String jsonString = readJSONString(req);
        System.out.println("Post content:" +jsonString);
        if(!jsonString.equals("")) {
            JSONObject json = new JSONObject(jsonString);
            outstandingPerformanceDescriptionService.save(json,String.valueOf(session.getAttribute("project_id")));
        }

    }

    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        System.out.println("Get content:" +outstandingPerformanceDescriptionService.show(String.valueOf(session.getAttribute("project_id"))));

        req.setAttribute("json",outstandingPerformanceDescriptionService.show(String.valueOf(session.getAttribute("project_id"))));

    }

}