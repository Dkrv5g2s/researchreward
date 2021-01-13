package Service.ExcellentResearcher;

import Bean.ExcellentResearcher.RecruitDescription;
import Dao.ExcellentResearcher.Impl.RecruitDescriptionDAOImpl;
import Dao.ExcellentResearcher.RecruitDescriptionDAO;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class RecruitDescriptionService {

    private RecruitDescriptionDAO recruitDescriptionDAO = new RecruitDescriptionDAOImpl();

    public void save(JSONObject jsonObject, String userNumber){
        recruitDescriptionDAO.save(new RecruitDescription(jsonObject.getString("recruitReason"),
                jsonObject.getString("recruitContent"),
                jsonObject.getString("expect"),
                jsonObject.getString("analysis"),
                jsonObject.getString("researchProduction"),
                jsonObject.getString("award"),
                jsonObject.getString("other"),
                jsonObject.getString("contribution"),
                userNumber));
    }

    public JSONObject get(String userNumber){

        RecruitDescription recruitDescription = recruitDescriptionDAO.get(userNumber);
        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,recruitDescription);
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }

        return object;


    }
}
