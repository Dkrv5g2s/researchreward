package Servlet.ExcellentResearcher;

import DBConnection.DBConnectionImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class PersonalInformationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = new DBConnectionImpl().getConnection();
        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/personalinformation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/jsp/ExcellentResearcher/RecruitDescription.jsp").forward(req, resp);
    }
}
