package Servlet.SpecialOutstandingResearcher;


import Service.Admin.AwardTimeLimitService;
import Service.SpecialOutstandingResearcher.OutstandingPerformanceDescriptionService;
import Service.Teacher.ProjectFillRateService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class OutstandingPerformanceDescriptionServlet extends ServletEntryPoint {

    private Logger logger = LogManager.getLogger(this.getClass());
    private OutstandingPerformanceDescriptionService outstandingPerformanceDescriptionService = new OutstandingPerformanceDescriptionService();

    private AwardTimeLimitService awardTimeLimitService = new AwardTimeLimitService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        getForm(req);
        String userRole = session.getAttribute("userRole").toString();
        req.setAttribute("role", userRole);
        req.setAttribute("readonly",session.getAttribute("readonly"));
        req.setAttribute("fwci", awardTimeLimitService.get().getDouble("fwciOfFiveYear"));
        req.setAttribute("h5Index", awardTimeLimitService.get().getDouble("h5Index"));
        req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/edit/Outstanding_Performance_Description_Form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String jsonString = readJSONString(req);

        if(!jsonString.equals("")) {
            JSONObject json = new JSONObject(jsonString);

            String projectId = String.valueOf(session.getAttribute("projectId"));
            outstandingPerformanceDescriptionService.save(json,projectId);

            ProjectFillRateService projectFillRateService = new ProjectFillRateService();
            projectFillRateService.save(Integer.parseInt(projectId), "OutstandingPerformanceDescriptionForm", json.getDouble("fill_rate"));
        }
        
    }

    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");

        req.setAttribute("json",outstandingPerformanceDescriptionService.show(String.valueOf(session.getAttribute("projectId"))));

    }

}