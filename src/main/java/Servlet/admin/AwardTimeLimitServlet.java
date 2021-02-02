package Servlet.admin;

import Service.Admin.AwardTimeLimitService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AwardTimeLimitServlet extends ServletEntryPoint {

    private static final String URL = "WEB-INF/jsp/admin/AwardTimeLimit.jsp";
    private AwardTimeLimitService awardTimeLimitService = new AwardTimeLimitService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json",awardTimeLimitService.get());

        req.getRequestDispatcher(URL).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        JSONObject json = new JSONObject(readJSONString(req));
        awardTimeLimitService.save(json);

    }
}
