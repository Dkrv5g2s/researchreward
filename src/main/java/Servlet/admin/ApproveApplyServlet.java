package Servlet.admin;

import Service.Admin.ApproveApplyService;
import Service.Teacher.RewardListService;
import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ApproveApplyServlet extends ServletEntryPoint {
    private RewardListService rewardListService = new RewardListService();
    private ApproveApplyService approveApplyService = new ApproveApplyService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession() ;
        int project_id = Integer.parseInt((String)session.getAttribute("projectId"));
        String userRole = (String)session.getAttribute("userRole");
        String userNumber = (String)session.getAttribute("userNumber");
        String userName = (String)session.getAttribute("userName");


        rewardListService.updateRewardStatusToNext(project_id);
        approveApplyService.updateReviewerAndReviewTime(project_id, userRole, userName);
    }
}
