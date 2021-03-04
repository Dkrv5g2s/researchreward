package Servlet.OutstandingResearchAward;

import Service.OutstandingResearchAward.OutstandingResearchAwardService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OutstandingResearchAwardServlet extends ServletEntryPoint {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String Award_URL_Edit = "WEB-INF/jsp/OutstandingResearchAward/edit/OutstandingResearchAward.jsp";
        final String Award_URL_Readonly = "WEB-INF/jsp/OutstandingResearchAward/readonly/OutstandingResearchAward.jsp";
        OutstandingResearchAwardService outstandingResearchAwardService = new OutstandingResearchAwardService();


        HttpSession session = req.getSession();
        int projectId = turnIdInSessionToInt(session, "projectId");
        req.setAttribute("data", outstandingResearchAwardService.get(projectId));

        Boolean readonly = Boolean.parseBoolean(session.getAttribute("readonly").toString());
        if(readonly){//送審
            req.getRequestDispatcher(Award_URL_Readonly).forward(req, resp);
        }
        else{
            req.getRequestDispatcher(Award_URL_Edit).forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutstandingResearchAwardService outstandingResearchAwardService = new OutstandingResearchAwardService();

        HttpSession session = req.getSession();
        int projectId = turnIdInSessionToInt(session, "projectId");
        int user_number = turnIdInSessionToInt(session, "userNumber");

        String jsonString = readJSONString(req);
        JSONObject jsonObject = new JSONObject(jsonString);
        jsonObject.put("user_number", user_number);
        outstandingResearchAwardService.save(jsonObject, projectId);

        resp.setContentType("text/html;charset=UTF-8");
        Map map = new HashMap();
        map.put("status", "存檔成功");
        String jackyJsonString = map.toString();
        JSONObject json = new JSONObject(jackyJsonString);
        resp.getWriter().write(String.valueOf(json));
    }
    private int turnIdInSessionToInt(HttpSession session, String id){
        return Integer.parseInt(session.getAttribute(id).toString());
    }
}
