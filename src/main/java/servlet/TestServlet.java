package servlet;

import Utils.Main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Main.main(new String[]{});
        req.getRequestDispatcher("WEB-INF/jsp/personalinformation.jsp").forward(req, resp);
    }
}
