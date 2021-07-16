package Servlet.admin;

import Service.Admin.RewardPendingListService;
import Service.Login.RoleAuthorizationService;
import Service.Login.RoleAuthorizationServiceImpl;
import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MenuServlet extends ServletEntryPoint {

    private static final String URL = "WEB-INF/jsp/admin/menu.jsp";
    private RoleAuthorizationService roleAuthorizationService = new RoleAuthorizationServiceImpl();
    private RewardPendingListService rewardPendingListService = new RewardPendingListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setAttribute("flag",!roleAuthorizationService.isResearchAndDevelopmentOffice(session));
        req.setAttribute("pendingReward",rewardPendingListService.havePendingReward((String) session.getAttribute("userRole")));
        req.setAttribute("returnedPendingReward",rewardPendingListService.haveReturnedPendingReward((String) session.getAttribute("userRole")));

        req.getRequestDispatcher(URL).forward(req, resp);
    }
}
