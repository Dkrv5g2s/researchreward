package Servlet.JuniorResearchInvestigator;

import Service.JuniorResearchInvestigator.JuniorResearchInvestigatorReviewInformationService;
import Service.Teacher.ProjectFillRateService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class JuniorResearchInvestigatorReviewInformationServlet extends ServletEntryPoint {

    private JuniorResearchInvestigatorReviewInformationService juniorResearchInvestigatorReviewInformationService = new JuniorResearchInvestigatorReviewInformationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int projectId = turnIdInSessionToInt(session, "projectId");
        req.setAttribute("data", juniorResearchInvestigatorReviewInformationService.show(projectId));

        Boolean readonly = Boolean.parseBoolean(session.getAttribute("readonly").toString());
        if(readonly){//送審
            req.getRequestDispatcher("WEB-INF/jsp/JuniorResearchInvestigator/Review/JuniorResearchInvestigatorReviewInformation.jsp").forward(req, resp);
        }
        else{
            req.getRequestDispatcher("WEB-INF/jsp/JuniorResearchInvestigator/JuniorResearchInvestigatorReviewInformation.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int projectId = turnIdInSessionToInt(session, "projectId");
        int user_number = turnIdInSessionToInt(session, "userNumber");

        String jsonString = readJSONString(req);
        JSONArray json = new JSONArray(jsonString);
        int i=0;
        JSONObject jsonObject;
        for(i=0; i<json.size()-1; i++) {
            jsonObject = (JSONObject)json.get(i);
            jsonObject.put("userNumber", user_number);
        }
        jsonObject = (JSONObject)json.get(i);
        ProjectFillRateService projectFillRateService = new ProjectFillRateService();
        projectFillRateService.save(projectId, "JuniorResearchInvestigatorReviewInformation", jsonObject.getDouble("fill_rate"));
        json.remove(i);
        juniorResearchInvestigatorReviewInformationService.save(json, projectId);
    }
    private int turnIdInSessionToInt(HttpSession session, String id){
        return Integer.parseInt(session.getAttribute(id).toString());
    }
}
