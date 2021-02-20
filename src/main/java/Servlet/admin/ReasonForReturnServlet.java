package Servlet.admin;

import Service.Admin.ReasonForReturnService;
import Service.SpecialOutstandingResearcher.PaperPerformanceDescriptionService;
import Service.Teacher.RewardListService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ReasonForReturnServlet extends ServletEntryPoint {
    private ReasonForReturnService reasonForReturnService = new ReasonForReturnService();
    private PaperPerformanceDescriptionService service = new PaperPerformanceDescriptionService() ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession() ;
        int projectId = Integer.parseInt(session.getAttribute("projectId").toString());
        String reward_type = service.queryRewardType(projectId);
        req.setAttribute("reward_type", reward_type);
        req.getRequestDispatcher("WEB-INF/jsp/admin/ReasonForReturn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        JSONObject json = new JSONObject(readJSONString(req));
        reasonForReturnService.updateReasonForReturn(json.getInt("projectId"), json.getString("reason_for_return"));
    }
}
