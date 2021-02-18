package Servlet.OutstandingResearchAward;

import Service.OutstandingResearchAward.OutstandingResearchAwardTableBService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class OutstandingResearchAwardTableBServlet extends ServletEntryPoint {
    private static final String TableB_URL = "WEB-INF/jsp/OutstandingResearchAward/OutstandingResearchAwardTableB.jsp";
    private OutstandingResearchAwardTableBService outstandingResearchAwardTableBService = new OutstandingResearchAwardTableBService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(TableB_URL).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        getForm(req);
        String jsonString = readJSONString(req);
        if (!jsonString.equals("")) {
            JSONObject json = new JSONObject(jsonString);
            outstandingResearchAwardTableBService.save(json, session.getAttribute("projectId").toString());
        }

    }

    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json", outstandingResearchAwardTableBService.get(session.getAttribute("projectId").toString()));
    }
}
