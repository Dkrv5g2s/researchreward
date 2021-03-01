package Servlet.SunshineScholarshipAward;

import Service.Admin.BFormFormulaService;
import Service.SpecialOutstandingResearcher.PaperPerformanceDescriptionService;
import Servlet.login.ServletEntryPoint;
import Utils.LogUtil;
import fr.opensagres.xdocreport.document.json.JSONObject;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SunshineScholarshipAwardTableAServlet extends ServletEntryPoint {
    private static final String TableA_Edit_URL = "WEB-INF/jsp/SunshineScholarshipAward/edit/SunshineScholarshipAwardTableA.jsp";
    private static final String TableA_Readonly_URL = "WEB-INF/jsp/SunshineScholarshipAward/readonly/SunshineScholarshipAwardTableA.jsp";
    private Logger logger = Logger.getLogger(this.getClass());

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
//        loggerUtil.ShowSessionInfo(session);

        int project_id = Integer.valueOf((String)session.getAttribute("projectId"));
        boolean readonly = (Boolean)session.getAttribute("readonly");
        PaperPerformanceDescriptionService service = new PaperPerformanceDescriptionService() ;
        BFormFormulaService bFormFormulaService = new BFormFormulaService() ;
        String weight = bFormFormulaService.get().toString() ;

        String json_form = "";

        json_form = service.query( project_id );

        String reward_type = service.queryRewardType(project_id);
        setDisplaySection(reward_type, req);

        req.setAttribute( "weight", weight );
        req.setAttribute("latest_data", json_form );
        if (readonly)
            req.getRequestDispatcher(TableA_Readonly_URL).forward(req, resp);
        else
            req.getRequestDispatcher(TableA_Edit_URL).forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/; charset = UTF-8");

        JSONObject jsonObject = new JSONObject(req.getParameter("data")) ;
        PaperPerformanceDescriptionService paperPerformanceDescriptionService = new PaperPerformanceDescriptionService() ;
        String duplicatePaperTitle = paperPerformanceDescriptionService.verifyPaperTitle(jsonObject);
        System.out.println(duplicatePaperTitle);
        this.logger.info("duplicatePaperTitle :"+ duplicatePaperTitle);
        if(duplicatePaperTitle.length()>0){
            //means the new paper column is duplicate
            String appliedApplicantName = paperPerformanceDescriptionService.getAppliedApplicantUserName(duplicatePaperTitle);
            String errorMessage = "論文【"+duplicatePaperTitle+"】，" +
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
    private void setDisplaySection(String reward_type, HttpServletRequest req) {
        req.setAttribute("reward_type", reward_type );
    }
}
