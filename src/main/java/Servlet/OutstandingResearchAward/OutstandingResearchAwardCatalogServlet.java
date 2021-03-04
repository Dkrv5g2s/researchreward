package Servlet.OutstandingResearchAward;

import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OutstandingResearchAwardCatalogServlet extends ServletEntryPoint {
    private static final String Catalog_URL = "WEB-INF/jsp/OutstandingResearchAward/OutstandingResearchAwardCatalog.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession() ;
        // 為了給表B上傳的
        req.getRequestDispatcher(Catalog_URL).forward(req,resp);
    }
    private int turnIdInSessionToInt(HttpSession session, String id){
        return Integer.parseInt(session.getAttribute(id).toString());
    }
}
