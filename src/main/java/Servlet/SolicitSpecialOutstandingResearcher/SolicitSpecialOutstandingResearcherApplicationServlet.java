package Servlet.SolicitSpecialOutstandingResearcher;

import Service.Admin.SpecialOutstandingResearcherSettingService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SolicitSpecialOutstandingResearcherApplicationServlet extends ServletEntryPoint {
    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();

        if (method.equals("GET")) {
            doGet(req, resp);
        }else if ( method.equals("POST")) {
            doPost(req, resp);
        }else {
            req.getRequestDispatcher("WEB-INF/jsp/login/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession() ;
        int project_id = Integer.valueOf(session.getAttribute("projectId").toString());
        boolean readonly = (Boolean)session.getAttribute("readonly");
        String userRole = session.getAttribute("userRole").toString();

        SpecialOutstandingResearcherSettingService specialOutstandingResearcherSettingService = new SpecialOutstandingResearcherSettingService();
        JSONObject date_info = specialOutstandingResearcherSettingService.get();

        req.setAttribute("date_info", date_info );

        req.getRequestDispatcher("WEB-INF/jsp/SolicitSpecialOutstandingResearcher/edit/SolicitSpecialOutstandingResearcherApplicationForm.jsp").forward(req, resp);
    }
}
