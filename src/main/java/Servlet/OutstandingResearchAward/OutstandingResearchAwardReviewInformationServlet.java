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
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class OutstandingResearchAwardReviewInformationServlet extends ServletEntryPoint {

    private static final String Review_URL = "WEB-INF/jsp/OutstandingResearchAward/OutstandingResearchAwardReviewInformation.jsp";

    OutstandingResearchAwardReviewInformationService ORAReviewInformationService = new OutstandingResearchAwardReviewInformationService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getForm(req);
        req.getRequestDispatcher(Review_URL).forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int projectId = turnIdInSessionToInt(session, "projectId");
        int user_number = turnIdInSessionToInt(session, "userNumber");

        String jsonString = readJSONString(req);
        JSONArray json = new JSONArray(jsonString);
        for (Object object: json) {
            JSONObject jsonObject = (JSONObject)object;
            jsonObject.put("userNumber", user_number);
        }
        ORAReviewInformationService.save(json,projectId);

        resp.setContentType("text/html;charset=UTF-8");
        Map map = new HashMap();
        map.put("status", "存檔成功");
        String jackyJsonString = map.toString();
        JSONObject respJson = new JSONObject(jackyJsonString);
        resp.getWriter().write(String.valueOf(respJson));
    }



    private int turnIdInSessionToInt(HttpSession session, String id){
        return Integer.parseInt(session.getAttribute(id).toString());
    }
    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();
        int projectId = turnIdInSessionToInt(session, "projectId");
        req.setAttribute("json", ORAReviewInformationService.get(projectId));
    }
}
