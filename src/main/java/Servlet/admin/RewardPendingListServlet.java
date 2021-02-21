package Servlet.admin;

import Service.Admin.RewardPendingListService;
import Service.Login.RoleAuthorizationService;
import Service.Login.RoleAuthorizationServiceImpl;
import Service.Teacher.RewardListService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RewardPendingListServlet extends ServletEntryPoint {

    private RewardPendingListService rewardPendingListService = new RewardPendingListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userRole = (String) session.getAttribute("userRole");
        req.setAttribute("json",rewardPendingListService.getPendingList(userRole));

        req.getRequestDispatcher("WEB-INF/jsp/admin/RewardPendingList.jsp").forward(req,resp);
    }
}
