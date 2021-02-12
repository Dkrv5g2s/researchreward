package Servlet.SunshineScholarshipAward;

import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SunshineScholarshipCatalogServlet extends ServletEntryPoint{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SunshineScholarshipCatalogServlet:"+req.toString());
        req.getRequestDispatcher("WEB-INF/jsp/SunshineScholarshipAward/SunshineScholarshipCatalog.jsp").forward(req,resp);
        System.out.println("SunshineScholarshipCatalogServlet:");
        ShowSessionValue(req.getSession());

    }

    private void ShowSessionValue(HttpSession session){
        for(int i =0;i<session.getValueNames().length;i++)
            System.out.println("Key:"+session.getValueNames()[i]+"value:"+session.getAttribute(session.getValueNames()[i]));
    }

}
