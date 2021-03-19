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
import Service.Teacher.RewardListService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class PaperPerformanceDescriptionServlet extends ServletEntryPoint {
    private Logger logger = Logger.getLogger(this.getClass());//Log4j

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        int project_id = Integer.valueOf((String)session.getAttribute("projectId"));
        boolean readonly = (Boolean)session.getAttribute("readonly");
        String table_d = req.getParameter("table_d");

        PaperPerformanceDescriptionService service = new PaperPerformanceDescriptionService() ;
        BFormFormulaService bFormFormulaService = new BFormFormulaService() ;
        String wight = bFormFormulaService.get().toString() ;

        String json_form = "";
        boolean isTableD = false;
        if (table_d!=null && table_d.equals("1")){
            isTableD = true;
            json_form = service.query( -project_id );
        }else
            json_form = service.query( project_id );

        String reward_type = service.queryRewardType(project_id);
        setDisplaySection(reward_type, req, isTableD);

        req.setAttribute( "weight", wight );
        req.setAttribute("latest_data", json_form );

        RewardListService rewardListService = new RewardListService();
        req.setAttribute("catalogURL", rewardListService.getCatalogURL(reward_type));

        if ( readonly )
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/readonly/Paper_Performance_Description_Form.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/edit/Paper_Performance_Description_Form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/; charset = UTF-8");
        JSONObject jsonObject = new JSONObject(req.getParameter("data")) ;

        HttpSession session = req.getSession();
        String staff_code = session.getAttribute("userNumber").toString();
        int project_id = Integer.valueOf((String)session.getAttribute("projectId"));

        PaperPerformanceDescriptionService paperPerformanceDescriptionService = new PaperPerformanceDescriptionService() ;
        String reward_type = paperPerformanceDescriptionService.queryRewardType(project_id);
        String duplicatePaperTitle = paperPerformanceDescriptionService.verifyPaperTitle(jsonObject,reward_type);
        this.logger.info( staff_code + " has modified PaperPerformanceDescriptionForm with json message " + jsonObject.toString() );

        if(duplicatePaperTitle.length()>0){
            //means the new paper column is duplicate
            String appliedApplicantName = paperPerformanceDescriptionService.getAppliedApplicantUserName(duplicatePaperTitle);
            String errorMessage = "論文【"+duplicatePaperTitle+"】重覆申請，" +
                    "已由【"+appliedApplicantName+"】進行申請，請調整填寫內容。";
            PrintWriter out = resp.getWriter();
            resp.setStatus(400);
            out.print(errorMessage);
            out.flush();
        }
        else{
            paperPerformanceDescriptionService.save(jsonObject);
        }
    }

    private void setDisplaySection(String reward_type, HttpServletRequest req, boolean isTableD) {
        String displayExplanation = "five_years";
        if(reward_type.compareTo("優秀人才申請")==0) {//TODO 獎勵特殊優秀研究人才?
            displayExplanation = "four_sections";
        }
        else if(reward_type.compareTo("年輕學者研究獎")==0 || reward_type.compareTo("傑出研究獎")==0) {
            displayExplanation = "three_years";
        }
        if(isTableD)
            displayExplanation = "table_d";
        req.setAttribute("displayExplanation", displayExplanation );
        req.setAttribute("reward_type", reward_type );
    }
}