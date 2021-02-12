package Servlet.Teacher;

import Service.Teacher.RewardListService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RewardListServlet extends ServletEntryPoint {

    private RewardListService service = new RewardListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String userNumber = (String) session.getAttribute("userNumber");
        req.setAttribute("json",service.getDraftList(userNumber));

        req.getRequestDispatcher("WEB-INF/jsp/Teacher/rewardList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        JSONObject json = new JSONObject(readJSONString(req));

        HttpSession session = req.getSession();
        session.setAttribute("projectId",json.getString("projectId"));
        System.out.println("RewardListServlet");
        ShowSessionValue(session);


        resp.sendRedirect(service.getCatalogURL(json.getString("rewardName")));
    }
    private void ShowSessionValue(HttpSession session){
        for(int i =0;i<session.getValueNames().length;i++)
            System.out.println("Key:"+session.getValueNames()[i]+"value:"+session.getAttribute(session.getValueNames()[i]));
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
