package Service.ExcellentResearcher;

import Bean.ExcellentResearcher.RecruitDescription;
import Dao.ExcellentResearcher.Impl.RecruitDescriptionDAOImpl;
import Dao.ExcellentResearcher.RecruitDescriptionDAO;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class RecruitDescriptionService {

    private RecruitDescriptionDAO recruitDescriptionDAO = new RecruitDescriptionDAOImpl();

    public void save(JSONObject jsonObject, int projectId){
        recruitDescriptionDAO.save(new RecruitDescription(jsonObject.getString("recruitReason"),
                jsonObject.getString("recruitContent"),
                jsonObject.getString("expect"),
                jsonObject.getString("analysis"),
                jsonObject.getString("researchProduction"),
                jsonObject.getString("award"),
                jsonObject.getString("other"),
                jsonObject.getString("contribution"),
                projectId));
    }

    public JSONObject get(String projectId){

        RecruitDescription recruitDescription = recruitDescriptionDAO.get(projectId);
        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,recruitDescription);
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }

        return object;


    }
}
