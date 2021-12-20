package Servlet.SpecialOutstandingResearcher;

import Service.SpecialOutstandingResearcher.ReviewSupportingInformationService;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ReviewSupportingInformationServlet extends HttpServlet {
    private Logger logger = LogManager.getLogger(this.getClass());


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();

        if (method.equals("GET")) {
            doGet(req, resp);
        }else if ( method.equals("POST")) {
            doPost(req, resp);
        }else {
            req.getRequestDispatcher("WEB-INF/jsp/login/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession() ;

        int project_id = Integer.valueOf(session.getAttribute("projectId").toString());
        boolean readonly = (Boolean)session.getAttribute("readonly");

        ReviewSupportingInformationService service = new ReviewSupportingInformationService() ;
        String json_form = service.query( project_id ) ;

        req.setAttribute("latest_data", json_form );

        if ( readonly )
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/readonly/Review_Supporting_Information_Form.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/edit/Review_Supporting_Information_Form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        JSONObject jsonObject = new JSONObject(req.getParameter("data")) ;
        ReviewSupportingInformationService service = new ReviewSupportingInformationService() ;
        service.save(jsonObject);
    }
}
