package Servlet.Teacher;

import Service.Admin.AwardTimeLimitService;
import Service.Teacher.RewardListService;
import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SelectRewardServlet extends ServletEntryPoint {

    private AwardTimeLimitService service = new AwardTimeLimitService();
    private RewardListService rewardListService = new RewardListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("rewardList",service.getOpeningReward());
        req.getRequestDispatcher("WEB-INF/jsp/Teacher/selectReward.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();

        String staffCode = (String) session.getAttribute("userNumber");
        String reward = req.getParameter("reward");

        rewardListService.createReward(staffCode,reward);

        resp.sendRedirect("RewardList");
    }
}
