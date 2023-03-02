package Service.Admin;

import Bean.Admin.SpecialOutstandingResearcherSetting;
import Dao.Admin.Impl.SpecialOutstandingResearcherSettingDAOImpl;
import Dao.Admin.SpecialOutstandingResearcherSettingDAO;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.sql.Date;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class SpecialOutstandingResearcherSettingService {

    private SpecialOutstandingResearcherSettingDAO dao = new SpecialOutstandingResearcherSettingDAOImpl();


    public void save(JSONObject jsonObject) {

        SpecialOutstandingResearcherSetting object = new SpecialOutstandingResearcherSetting();

        object.setSeniority(new Date(jsonObject.getDate("seniority").getTime()));
        object.setMostStart(new Date(jsonObject.getDate("mostStart").getTime()));
        object.setMostEnd(new Date(jsonObject.getDate("mostEnd").getTime()));
        object.setYear(jsonObject.getInt("year"));
        object.setYearY(jsonObject.getInt("year_y"));
        object.setEchelonY(jsonObject.getInt("echelon_y"));

        dao.save(object);
    }

    public JSONObject get(){

        SpecialOutstandingResearcherSetting result = dao.get();
        System.out.println(result.getSeniority());
        JSONObject jsonObject = new JSONObject();

        try {
            addBeanPropertyToJson(jsonObject, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);
        return jsonObject;
    }

}
