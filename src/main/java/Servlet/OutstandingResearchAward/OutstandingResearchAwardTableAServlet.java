package Servlet.OutstandingResearchAward;

import Service.OutstandingResearchAward.OutstandingResearchAwardTableAService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class OutstandingResearchAwardTableAServlet extends ServletEntryPoint {
    private static final String TableA_URL = "WEB-INF/jsp/OutstandingResearchAward/OutstandingResearchAwardTableA.jsp";
    private OutstandingResearchAwardTableAService outstandingResearchAwardTableAService = new OutstandingResearchAwardTableAService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getForm(req);
        req.getRequestDispatcher(TableA_URL).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getForm(req);
        String jsonString = readJSONString(req);
        if (!jsonString.equals("")) {
            JSONObject json = new JSONObject(jsonString);

            HttpSession session = req.getSession();
            outstandingResearchAwardTableAService.save(json, session.getAttribute("projectId").toString());
        }

    }

    private void getForm(HttpServletRequest req) throws UnsupportedEncodingException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("json", outstandingResearchAwardTableAService.get(session.getAttribute("projectId").toString()));
        System.out.print("req:"+req);

    }


}
