package Servlet.OutstandingResearchAward;

import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OutstandingResearchAwardTableBServlet extends ServletEntryPoint {
    private static final String TableB_URL = "WEB-INF/jsp/OutstandingResearchAward/OutstandingResearchAwardTableB.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(TableB_URL).forward(req,resp);
    }
}
