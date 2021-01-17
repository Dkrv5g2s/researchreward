package Service.Admin;

import Bean.Admin.AwardTimeLimit;
import Dao.Admin.AwardTimeLimitDAO;
import Dao.Admin.Impl.AwardTimeLimitDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.sql.Date;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class AwardTimeLimitService {

    private AwardTimeLimitDAO awardTimeLimitDAO = new AwardTimeLimitDAOImpl();

    public void save(JSONObject jsonObject, String userNumber){
        awardTimeLimitDAO.save(new AwardTimeLimit(new Date(jsonObject.getDate("s1").getTime()),
                new Date(jsonObject.getDate("s2").getTime()),
                new Date(jsonObject.getDate("s3").getTime()),
                new Date(jsonObject.getDate("s4").getTime()),
                new Date(jsonObject.getDate("s5").getTime()),
                new Date(jsonObject.getDate("s6").getTime()),
                new Date(jsonObject.getDate("s7").getTime()),
                new Date(jsonObject.getDate("s8").getTime()),
                new Date(jsonObject.getDate("l1").getTime()),
                new Date(jsonObject.getDate("l2").getTime()),
                new Date(jsonObject.getDate("l3").getTime()),
                new Date(jsonObject.getDate("l4").getTime()),
                new Date(jsonObject.getDate("l5").getTime()),
                new Date(jsonObject.getDate("l6").getTime()),
                new Date(jsonObject.getDate("l7").getTime()),
                new Date(jsonObject.getDate("l8").getTime()),
                jsonObject.getDouble("fwci"),
                userNumber));
    }

    public JSONObject get(String userNumber){
        AwardTimeLimit result = awardTimeLimitDAO.get(userNumber);

        JSONObject jsonObject = new JSONObject();

        try {
            addBeanPropertyToJson(jsonObject, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
