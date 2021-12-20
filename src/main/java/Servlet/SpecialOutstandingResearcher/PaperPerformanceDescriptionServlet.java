package Servlet.SpecialOutstandingResearcher;

import Service.Admin.BFormFormulaService;
import Service.SpecialOutstandingResearcher.PaperPerformanceDescriptionService;
import Service.Teacher.RewardListService;
import Service.TeacherHireResearcher.TeacherHireResearcherTableCService;
import Servlet.login.ServletEntryPoint;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class PaperPerformanceDescriptionServlet extends ServletEntryPoint {
    private Logger logger = LogManager.getLogger(this.getClass());

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
        String table_c = req.getParameter("table_c");

        PaperPerformanceDescriptionService service = new PaperPerformanceDescriptionService() ;
        BFormFormulaService bFormFormulaService = new BFormFormulaService() ;
        TeacherHireResearcherTableCService teacherHireResearcherTableCService = new TeacherHireResearcherTableCService();

        String wight = bFormFormulaService.get().toString() ;

        String json_form = "";

        boolean isTableC = false;
        JSONObject tableCJson = new JSONObject();
        if (table_c!=null && table_c.equals("1")){
            isTableC = true;
            json_form = service.query(-project_id);

            tableCJson.putAll(teacherHireResearcherTableCService.get(-project_id));
        }else
            json_form = service.query(project_id);

        String reward_type = service.queryRewardType(project_id);
        setDisplaySection(reward_type, req, isTableC);

        req.setAttribute( "weight", wight );
        req.setAttribute("latest_data", json_form );

        tableCJson.put("isTableC", isTableC);
        req.setAttribute("tableCJson", tableCJson);

        RewardListService rewardListService = new RewardListService();
        req.setAttribute("catalogURL", rewardListService.getCatalogURL(reward_type));

        if ( readonly ) {
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/readonly/Paper_Performance_Description_Form.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("WEB-INF/jsp/SpecialOutstandingResearcher/edit/Paper_Performance_Description_Form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/; charset = UTF-8");
        JSONObject jsonObject = new JSONObject(req.getParameter("data")) ;
        JSONObject tableCJsonObject = new JSONObject(req.getParameter("tableCData")) ;

        HttpSession session = req.getSession();
        String staff_code = session.getAttribute("userNumber").toString();
        int project_id = Integer.valueOf((String)session.getAttribute("projectId"));

        TeacherHireResearcherTableCService teacherHireResearcherTableCService = new TeacherHireResearcherTableCService();

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
            if(tableCJsonObject.getBoolean("isTableC"))
                teacherHireResearcherTableCService.save(tableCJsonObject, -project_id);
        }
    }

    private void setDisplaySection(String reward_type, HttpServletRequest req, boolean isTableC) {
        String displayExplanation = "five_years";
        System.out.println(reward_type);
        if(reward_type.compareTo("陽光獎助金論文獎勵")==0) {
            displayExplanation = "sunshine_scholarship_award";
        }

        if(isTableC){
            displayExplanation = "table_c";
        }

        req.setAttribute("displayExplanation", displayExplanation );
        req.setAttribute("reward_type", reward_type );
    }
}