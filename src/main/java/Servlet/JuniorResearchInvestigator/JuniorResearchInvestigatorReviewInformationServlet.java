package Servlet.JuniorResearchInvestigator;

import Service.JuniorResearchInvestigator.JuniorResearchInvestigatorCatalogService;
import Service.JuniorResearchInvestigator.JuniorResearchInvestigatorReviewInformationService;
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

public class JuniorResearchInvestigatorReviewInformationServlet extends ServletEntryPoint {

    private JuniorResearchInvestigatorReviewInformationService juniorResearchInvestigatorReviewInformationService = new JuniorResearchInvestigatorReviewInformationService();
    private JuniorResearchInvestigatorCatalogService juniorResearchInvestigatorCatalogService = new JuniorResearchInvestigatorCatalogService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int projectId = turnIdInSessionToInt(session, "projectId");
        req.setAttribute("json", juniorResearchInvestigatorReviewInformationService.show(projectId));

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
        for (Object object: json) {
            JSONObject jsonObject = (JSONObject)object;
            jsonObject.put("userNumber", user_number);
        }
        juniorResearchInvestigatorReviewInformationService.save(json, projectId);
        juniorResearchInvestigatorCatalogService.saveEditStatus(projectId, "JuniorResearchInvestigatorReviewInformation");
    }
    private int turnIdInSessionToInt(HttpSession session, String id){
        return Integer.parseInt(session.getAttribute(id).toString());
    }
}
