package Servlet.SpecialOutstandingResearcher;

import Bean.User.User;
import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAO;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAOImpl;
import Service.Admin.AwardTimeLimitService;
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
    private AwardTimeLimitService awardTimeLimitService = new AwardTimeLimitService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        getForm(req);
        req.setAttribute("readonly",session.getAttribute("readonly"));
        req.setAttribute("fwci", awardTimeLimitService.get().getDouble("fwciOfFiveYear"));
        req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/edit/Outstanding_Performance_Description_Form.jsp").forward(req, resp);
        // "WEB-INF/jsp/SpecialOutstandingResearcher/edit/Outstanding_Performance_Description_Form.jsp"
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        getForm(req);

        String jsonString = readJSONString(req);

        if(!jsonString.equals("")) {
            JSONObject json = new JSONObject(jsonString);
            outstandingPerformanceDescriptionService.save(json,String.valueOf(session.getAttribute("project_id")));
        }

    }

    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");


        req.setAttribute("json",outstandingPerformanceDescriptionService.show(String.valueOf(session.getAttribute("project_id"))));

    }

}