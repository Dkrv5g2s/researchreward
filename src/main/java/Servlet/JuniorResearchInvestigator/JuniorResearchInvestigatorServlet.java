package Servlet.JuniorResearchInvestigator;

import Service.JuniorResearchInvestigator.JuniorResearchInvestigatorService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JuniorResearchInvestigatorServlet extends ServletEntryPoint {

    private JuniorResearchInvestigatorService juniorResearchInvestigatorService = new JuniorResearchInvestigatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int project_id = turnIdInSessionToInt(session, "projectId");
        req.setAttribute("json", juniorResearchInvestigatorService.show(project_id));

        req.getRequestDispatcher("WEB-INF/jsp/JuniorResearchInvestigator/JuniorResearchInvestigator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int project_id = turnIdInSessionToInt(session, "projectId");
        int user_number = turnIdInSessionToInt(session, "userNumber");

        String jsonString = readJSONString(req);
        JSONObject jsonObject = new JSONObject(jsonString);
        jsonObject.put("user_number", user_number);
        juniorResearchInvestigatorService.save(jsonObject, project_id);

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
