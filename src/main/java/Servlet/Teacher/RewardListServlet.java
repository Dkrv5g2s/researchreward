package Servlet.Teacher;

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

public class RewardListServlet extends ServletEntryPoint {

    private RewardListService rewardListService = new RewardListService();
    private RoleAuthorizationService roleAuthorizationService = new RoleAuthorizationServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String userNumber = (String) session.getAttribute("userNumber");
        req.setAttribute("json",rewardListService.getDraftList(userNumber));

        req.getRequestDispatcher("WEB-INF/jsp/Teacher/rewardList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("utf-8");
        JSONObject json = new JSONObject(readJSONString(req));

        session.setAttribute("projectId",json.getString("projectId"));
        session.setAttribute("readonly",roleAuthorizationService.isUserRoleReviewerLevel(session));

        resp.sendRedirect(rewardListService.getCatalogURL(json.getString("rewardName")));
    }
}
