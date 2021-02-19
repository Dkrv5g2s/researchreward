package Servlet.JuniorResearchInvestigator;

import Service.JuniorResearchInvestigator.JuniorResearchInvestigatorTableAService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class JuniorResearchInvestigatorTableAServlet extends ServletEntryPoint {

    private JuniorResearchInvestigatorTableAService juniorResearchInvestigatorTableAService = new JuniorResearchInvestigatorTableAService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        req.setAttribute("json", juniorResearchInvestigatorTableAService.show(session.getAttribute("projectId").toString()));

        Boolean readonly = Boolean.parseBoolean(session.getAttribute("readonly").toString());
        if(readonly){//送審
            req.getRequestDispatcher("WEB-INF/jsp/JuniorResearchInvestigator/Review/JuniorResearchInvestigatorTableA.jsp").forward(req, resp);
        }
        else{
            req.getRequestDispatcher("WEB-INF/jsp/JuniorResearchInvestigator/JuniorResearchInvestigatorTableA.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonString = readJSONString(req);
        if (!jsonString.equals("")) {
            JSONObject json = new JSONObject(jsonString);
            HttpSession session = req.getSession();
            juniorResearchInvestigatorTableAService.save(json, session.getAttribute("projectId").toString());
        }
    }
}