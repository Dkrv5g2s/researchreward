package Servlet.OutstandingResearchAward;

import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OutstandingResearchAwardReviewInformationServlet extends ServletEntryPoint {

    private static final String Review_URL = "WEB-INF/jsp/OutstandingResearchAward/OutstandingResearchReviewInformation.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(Review_URL).forward(req,resp);
    }

}
