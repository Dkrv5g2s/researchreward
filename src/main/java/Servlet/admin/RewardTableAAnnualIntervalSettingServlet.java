package Servlet.admin;

import Service.Admin.AwardYearSettingService;
import Servlet.login.ServletEntryPoint;
import com.alibaba.fastjson.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RewardTableAAnnualIntervalSettingServlet extends ServletEntryPoint {

    private AwardYearSettingService awardYearSettingService = new AwardYearSettingService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("awardsYears", awardYearSettingService.getAwardsYears());
        req.getRequestDispatcher("WEB-INF/jsp/admin/RewardTableAAnnualIntervalSetting.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonString = readJSONString(req);
        JSONObject jsonObject = JSON.parseObject(jsonString);
        awardYearSettingService.saveAwardsYears(jsonObject);
    }
}
