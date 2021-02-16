package Servlet.JuniorResearchInvestigator;

import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class JuniorResearchInvestigatorCatalogServlet extends ServletEntryPoint {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession() ;
        int user_number = Integer.parseInt(session.getAttribute("userNumber").toString());
        Boolean readonly = false ;//TODO role判斷
//        Boolean readonly = Boolean.parseBoolean(session.getAttribute("readonly").toString());

        session.setAttribute( "readonly", readonly );
        session.setAttribute( "project_id", Integer.parseInt(session.getAttribute("projectId").toString()) );//TODO del
        req.getRequestDispatcher("WEB-INF/jsp/JuniorResearchInvestigator/JuniorResearchInvestigatorCatalog.jsp").forward(req, resp);
    }
}
