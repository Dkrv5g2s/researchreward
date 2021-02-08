package Servlet.SpecialOutstandingResearcher;

import Bean.Admin.BFormFormula;
import Bean.User.User;
import Dao.Admin.BFormFormulaDAO;
import Dao.Admin.Impl.BFormFormulaDAOImpl;
import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAO;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAOImpl;
import Service.Admin.BFormFormulaService;
import Service.SpecialOutstandingResearcher.PaperPerformanceDescriptionService;
import Service.SpecialOutstandingResearcher.SpecialOutstandingResearcherApplicationService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PaperPerformanceDescriptionServlet extends ServletEntryPoint {
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
        int project_id = (int)session.getAttribute( "project_id" );
        boolean readonly = (Boolean)session.getAttribute("readonly");

        PaperPerformanceDescriptionService service = new PaperPerformanceDescriptionService() ;
        BFormFormulaService bFormFormulaService = new BFormFormulaService() ;
        String wight = bFormFormulaService.get().toString() ;


        String json_form = service.query( project_id ) ;

        String reward_type = service.queryRewardType(project_id);
        setDisplaySection(reward_type, req);

        req.setAttribute( "weight", wight );
        req.setAttribute("latest_data", json_form );

        if ( readonly )
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/readonly/Paper_Performance_Description_Form.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/edit/Paper_Performance_Description_Form.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        JSONObject jsonObject = new JSONObject(req.getParameter("data")) ;
        //User ud = (User)session.getAttribute("ud"); //正式 取得User 資料
        User user = new User( "root", "password1234", "上帝", "108598065" ) ;

        this.logger.info( user.getStaff_code() + " has modified PaperPerformanceDescriptionForm with json message " + jsonObject.toString() );

        PaperPerformanceDescriptionService service = new PaperPerformanceDescriptionService() ;

        //service.save(jsonObject, (String)session.getAttribute("userNumber")); //正式
        service.save(jsonObject);


    }

    private void setDisplaySection(String reward_type, HttpServletRequest req) {
        String displayExplanation = "five_years";
        if(reward_type.compareTo("優秀人才申請")==0) {
            displayExplanation = "four_sections";
        }
        else if(reward_type.compareTo("年輕學者獎")==0 || reward_type.compareTo("傑出研究獎")==0) {
            displayExplanation = "three_years";
        }
        req.setAttribute("displayExplanation", displayExplanation );
        req.setAttribute("reward_type", reward_type );
    }
}