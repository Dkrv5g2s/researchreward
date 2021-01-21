package Servlet.Teacher;

import Bean.Admin.AwardTimeLimit;
import Service.Admin.AwardTimeLimitService;
import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SelectRewardServlet extends ServletEntryPoint {

    private AwardTimeLimitService service = new AwardTimeLimitService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("rewardList",service.getOpeningReward());
        req.getRequestDispatcher("WEB-INF/jsp/Teacher/selectReward.jsp").forward(req,resp);
    }
}
