package Servlet.admin;

import Service.Admin.RewardPendingListService;
import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ApprovedRewardListServlet extends ServletEntryPoint {
    private RewardPendingListService rewardPendingListService = new RewardPendingListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String userRole = (String) session.getAttribute("userRole");
        req.setAttribute("json",rewardPendingListService.getApprovedRewardList(userRole));

        req.getRequestDispatcher("WEB-INF/jsp/admin/ApprovedRewardList.jsp").forward(req,resp);
    }
}
