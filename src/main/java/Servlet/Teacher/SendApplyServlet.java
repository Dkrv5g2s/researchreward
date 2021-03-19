package Servlet.Teacher;

import Service.Admin.AwardTimeLimitService;
import Service.SpecialOutstandingResearcher.PaperPerformanceDescriptionService;
import Service.Teacher.RewardListService;
import Servlet.login.ServletEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SendApplyServlet extends ServletEntryPoint {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/; charset = UTF-8");
        // 在前端正確顯示UTF8的設定

        RewardListService rewardListService = new RewardListService();
        PaperPerformanceDescriptionService paperPerformanceDescriptionService = new PaperPerformanceDescriptionService() ;
        AwardTimeLimitService awardTimeLimitService = new AwardTimeLimitService();

        HttpSession session = req.getSession() ;
        int project_id = Integer.parseInt((String)session.getAttribute("projectId"));
        String applyRewardType = paperPerformanceDescriptionService.queryRewardType(project_id);

        if(awardTimeLimitService.isRewardOpening(applyRewardType)){
            rewardListService.updateRewardStatusToNext(project_id);
        }
        else{
            String errorMessage = "【"+applyRewardType+"】獎項，申請時間已超過申請期限，請至申請獎項頁面重新申請其他獎項";
            PrintWriter out = resp.getWriter();
            resp.setStatus(400);
            out.print(errorMessage);
            out.flush();
        }

    }
}
