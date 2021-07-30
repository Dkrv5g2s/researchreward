package Servlet.Teacher;

import Service.Teacher.ProjectFillRateService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProjectFillRateServlet extends ServletEntryPoint {
    private ProjectFillRateService projectFillRateService = new ProjectFillRateService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int projectId = turnIdInSessionToInt(session, "projectId");
        JSONObject fillRates = projectFillRateService.getFillFactors(projectId);
        resp.getWriter().write(String.valueOf(fillRates));
    }

    private int turnIdInSessionToInt(HttpSession session, String id){
        return Integer.parseInt(session.getAttribute(id).toString());
    }
}
