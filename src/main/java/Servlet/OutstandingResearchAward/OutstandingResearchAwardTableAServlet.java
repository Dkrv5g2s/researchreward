package Servlet.OutstandingResearchAward;

import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OutstandingResearchAwardTableAServlet extends ServletEntryPoint {
    private static final String TableA_URL = "WEB-INF/jsp/OutstandingResearchAward/OutstandingResearchAwardTableA.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(TableA_URL).forward(req,resp);
    }
}
