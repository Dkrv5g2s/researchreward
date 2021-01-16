package Servlet.login;

import Service.Login.RoleAuthorizationService;
import Service.Login.RoleAuthorizationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class loginServlet extends HttpServlet {

    private RoleAuthorizationService roleAuthorizationService = new RoleAuthorizationServiceImpl();
    private static final String LOGIN_URL = "WEB-INF/jsp/login/login.jsp";
    private static final String TEACHER_URL = "CatalogOfWorks";
    private static final String ADMIN_URL = "AwardTimeLimit";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher(LOGIN_URL).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String account = req.getParameter("account");
        String password = req.getParameter("password");

        switch (roleAuthorizationService.validateRole(session, account, password)){
            case "teacher":
                resp.sendRedirect(TEACHER_URL);
                break;
            case "admin":
                resp.sendRedirect(ADMIN_URL);
                break;
            default:
                req.getRequestDispatcher(LOGIN_URL).forward(req, resp);
                break;
        }

    }
}
