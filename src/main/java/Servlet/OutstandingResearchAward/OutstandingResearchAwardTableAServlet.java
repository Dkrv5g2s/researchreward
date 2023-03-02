package Servlet.OutstandingResearchAward;

import Service.Admin.AwardTimeLimitService;
import Service.OutstandingResearchAward.OutstandingResearchAwardTableAService;
import Service.Teacher.ProjectFillRateService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OutstandingResearchAwardTableAServlet extends ServletEntryPoint {
    private OutstandingResearchAwardTableAService outstandingResearchAwardTableAService = new OutstandingResearchAwardTableAService();
    private AwardTimeLimitService awardTimeLimitService = new AwardTimeLimitService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String TableA_URL_Edit = "WEB-INF/jsp/OutstandingResearchAward/edit/OutstandingResearchAwardTableA.jsp";
        final String TableA_URL_Readonly = "WEB-INF/jsp/OutstandingResearchAward/readonly/OutstandingResearchAwardTableA.jsp";
        AwardTimeLimitService awardTimeLimitService = new AwardTimeLimitService();
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        req.setAttribute("data", outstandingResearchAwardTableAService.get(session.getAttribute("projectId").toString()));
        req.setAttribute("fwci", awardTimeLimitService.get().getDouble("fwciOfThreeYear"));
        req.setAttribute("h5Index", awardTimeLimitService.get().getDouble("h5Index"));

        Boolean readonly = Boolean.parseBoolean(session.getAttribute("readonly").toString());
        if(readonly){
            req.getRequestDispatcher(TableA_URL_Readonly).forward(req,resp);
        }
        else{
            req.getRequestDispatcher(TableA_URL_Edit).forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonString = readJSONString(req);
        if (!jsonString.equals("")) {
            JSONObject json = new JSONObject(jsonString);

            HttpSession session = req.getSession();
            String projectId = session.getAttribute("projectId").toString();
            outstandingResearchAwardTableAService.save(json, session.getAttribute("projectId").toString());
            ProjectFillRateService projectFillRateService = new ProjectFillRateService();
            projectFillRateService.save(Integer.parseInt(projectId), "OutstandingResearchAwardTableA", json.getDouble("fill_rate"));
        }

    }



}