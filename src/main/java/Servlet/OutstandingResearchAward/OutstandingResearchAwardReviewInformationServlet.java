package Servlet.OutstandingResearchAward;

import Service.OutstandingResearchAward.OutstandingResearchAwardReviewInformationService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OutstandingResearchAwardReviewInformationServlet extends ServletEntryPoint {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String Review_URL_Edit = "WEB-INF/jsp/OutstandingResearchAward/edit/OutstandingResearchAwardReviewInformation.jsp";
        final String Review_URL_Readonly = "WEB-INF/jsp/OutstandingResearchAward/readonly/OutstandingResearchAwardReviewInformation.jsp";
        OutstandingResearchAwardReviewInformationService ORAReviewInformationService = new OutstandingResearchAwardReviewInformationService();

        HttpSession session = req.getSession();
        int projectId = turnIdInSessionToInt(session, "projectId");
        req.setAttribute("data", ORAReviewInformationService.get(projectId));

        Boolean readonly = Boolean.parseBoolean(session.getAttribute("readonly").toString());
        if(readonly){//送審
            req.getRequestDispatcher(Review_URL_Readonly).forward(req, resp);
        }
        else{
            req.getRequestDispatcher(Review_URL_Edit).forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        OutstandingResearchAwardReviewInformationService ORAReviewInformationService = new OutstandingResearchAwardReviewInformationService();
        int projectId = turnIdInSessionToInt(session, "projectId");
        int user_number = turnIdInSessionToInt(session, "userNumber");

        String jsonString = readJSONString(req);
        JSONArray json = new JSONArray(jsonString);
        for (Object object: json) {
            JSONObject jsonObject = (JSONObject)object;
            jsonObject.put("userNumber", user_number);
        }
        ORAReviewInformationService.save(json,projectId);

    }
    private int turnIdInSessionToInt(HttpSession session, String id){
        return Integer.parseInt(session.getAttribute(id).toString());
    }

}
