package Servlet.SpecialOutstandingResearcher;

import Bean.User.User;
import Service.SpecialOutstandingResearcher.AwardDistributionAmountOrPrincipleService;
import Service.SpecialOutstandingResearcher.ReviewSupportingInformationService;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AwardDistributionAmountOrPrincipleSevlet extends HttpServlet {
    private Logger logger = Logger.getLogger(this.getClass());//Log4j

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String method = req.getMethod();

        if (method.equals("GET")) {
            doGet(req, resp);
        }else if ( method.equals("POST")) {
            doPost(req, resp);
        }else {
            //doPost(req, resp);
            req.getRequestDispatcher("WEB-INF/jsp/login/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession() ;

        int project_id = Integer.valueOf(session.getAttribute("projectId").toString());
        boolean readonly = (Boolean)session.getAttribute("readonly");

        AwardDistributionAmountOrPrincipleService service = new AwardDistributionAmountOrPrincipleService() ;
        String json_form = service.query( project_id ) ;

        req.setAttribute("latest_data", json_form );

        if ( readonly )
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/readonly/Award_Distribution_Amount_Or_Principle_Form.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/edit/Award_Distribution_Amount_Or_Principle_Form.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        JSONObject jsonObject = new JSONObject(req.getParameter("data")) ;
        //User ud = (User)session.getAttribute("ud"); //正式 取得User 資料
        User user = new User( "root", "password1234", "測試", "staff1221" ) ;

        this.logger.info( user.getStaff_code() + " has modifiedAwardDistributionAmountOrPrincipleForm with json message " + jsonObject.toString() );

        AwardDistributionAmountOrPrincipleService service = new AwardDistributionAmountOrPrincipleService() ;

        service.save(jsonObject);

    }
}