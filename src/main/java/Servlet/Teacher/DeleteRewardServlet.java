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
import java.io.PrintWriter;

public class DeleteRewardServlet extends ServletEntryPoint {

    private RewardListService rewardListService = new RewardListService();
    private RoleAuthorizationService roleAuthorizationService = new RoleAuthorizationServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("utf-8");
        JSONObject json = new JSONObject(readJSONString(req));
        int projectId =  Integer.parseInt( json.getString("projectId"));
        String userNumber = (String)session.getAttribute("userNumber");

        rewardListService.deleteRewardProject(projectId,userNumber);
        req.getRequestDispatcher("WEB-INF/jsp/Teacher/rewardList.jsp").forward(req,resp);
        //means the new paper column is duplicate

        String Message = "刪除成功";
        PrintWriter out = resp.getWriter();
        resp.setStatus(200);
        out.print(Message);
        out.flush();
    }
}
