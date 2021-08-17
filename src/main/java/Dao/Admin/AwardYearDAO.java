package Dao.Admin;

import com.alibaba.fastjson.*;

public interface AwardYearDAO {
    JSONObject getAwardsYears();
    fr.opensagres.xdocreport.document.json.JSONObject getSpecificAwardYears(String awardName);
    void saveAwardsYears(JSONObject jsonObject);
}
