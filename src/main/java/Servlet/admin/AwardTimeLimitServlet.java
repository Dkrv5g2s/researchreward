package Servlet.admin;

import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AwardTimeLimitServlet extends ServletEntryPoint {
    private static final String URL = "WEB-INF/jsp/admin/AwardTimeLimit.jsp";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(URL).forward(req, resp);
    }
}
