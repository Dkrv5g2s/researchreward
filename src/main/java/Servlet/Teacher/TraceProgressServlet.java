package Servlet.Teacher;

import Service.Teacher.RewardListService;
import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TraceProgressServlet extends ServletEntryPoint {

    private RewardListService service = new RewardListService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String userNumber = (String) session.getAttribute("userNumber");
        req.setAttribute("json",service.traceProgress(userNumber));

        req.getRequestDispatcher("WEB-INF/jsp/Teacher/traceProgress.jsp").forward(req,resp);
    }
}
