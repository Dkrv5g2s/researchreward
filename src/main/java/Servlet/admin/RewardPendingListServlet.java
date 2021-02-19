package Servlet.admin;

import Service.Admin.RewardPendingListService;
import Service.Teacher.RewardListService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RewardPendingListServlet extends ServletEntryPoint {

    private RewardPendingListService service = new RewardPendingListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String userRole = (String) session.getAttribute("userRole");
        req.setAttribute("json",service.getPendingList(userRole));

        req.getRequestDispatcher("WEB-INF/jsp/admin/RewardPendingList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        JSONObject json = new JSONObject(readJSONString(req));

        HttpSession session = req.getSession();
        session.setAttribute("projectId",json.getString("projectId"));

        resp.sendRedirect(service.getCatalogURL(json.getString("rewardName")));
    }

//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("utf-8");
//        JSONObject json = new JSONObject(readJSONString(req));
//
//        HttpSession session = req.getSession();
//        session.setAttribute("projectId",json.getString("projectId"));
//
//        resp.sendRedirect(service.del(json.getString("rewardName")));
//    }
}
