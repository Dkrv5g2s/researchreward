package Servlet.Teacher;

import Constants.ProgressConstant;
import Service.Teacher.RewardListService;
import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SendApplyServlet extends ServletEntryPoint {
    private RewardListService rewardListService = new RewardListService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession() ;
        int project_id = Integer.parseInt((String)session.getAttribute("projectId"));

        rewardListService.updateRewardStatus(project_id, ProgressConstant.SUBMIT_DEPARTMENT_FOR_REVIEW);
    }
}
