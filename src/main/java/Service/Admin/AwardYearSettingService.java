package Service.Admin;

import Dao.Admin.AwardYearDAO;
import Dao.Admin.Impl.AwardYearDAOImpl;

import com.alibaba.fastjson.*;

public class AwardYearSettingService {
    private AwardYearDAO awardYearDAO = new AwardYearDAOImpl();

    public JSONObject getAwardsYears() {
        return awardYearDAO.getAwardsYears();
    }

    public void saveAwardsYears(JSONObject jsonObject) {
        awardYearDAO.saveAwardsYears(jsonObject);
    }
}
