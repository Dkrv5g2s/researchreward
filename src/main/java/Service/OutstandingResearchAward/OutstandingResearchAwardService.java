package Service.OutstandingResearchAward;

import Bean.OutstandingResearchAward.OutstandingResearchAward;
import Dao.OutstandingResearchAward.OutstandingResearchAwardDAO;
import Dao.OutstandingResearchAward.OutstandingResearchAwardDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.sql.Date;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class OutstandingResearchAwardService {

    private OutstandingResearchAwardDAO outstandingResearchAwardDAO = new OutstandingResearchAwardDAOImpl();

    public void save(JSONObject jsonObject, int project_id){
        OutstandingResearchAward outstandingResearchAward = new OutstandingResearchAward();// = null;

        outstandingResearchAward.setProjectId(project_id);
        outstandingResearchAward.setUserNumber(jsonObject.getInt("user_number"));
        outstandingResearchAward.setUserName(jsonObject.getString("user_name"));
        outstandingResearchAward.setApplicantTitle(jsonObject.getString("applicant_title"));
        outstandingResearchAward.setDepartment(jsonObject.getString("department"));
        outstandingResearchAward.setBirthDate(jsonToDate(jsonObject, "birth_date"));
        outstandingResearchAward.setIdentityNumber(jsonObject.getString("identity_number"));
        outstandingResearchAward.setEmploymentDate(jsonToDate(jsonObject, "employment_date"));
        outstandingResearchAward.setExtensionNumber(jsonObject.getString("extension_number"));
        outstandingResearchAward.setCellphoneNumber(jsonObject.getString("cellphone_number"));
        outstandingResearchAward.setRecommendedReason(jsonObject.getString("recommended_reason"));
        System.out.println(outstandingResearchAward);
        outstandingResearchAwardDAO.save(outstandingResearchAward, project_id);
    }

    public JSONObject get(int project_id) {
        OutstandingResearchAward outstandingResearchAward = outstandingResearchAwardDAO.get(project_id);

        JSONObject object = new JSONObject();
        if(outstandingResearchAward != null) {
            try {
                addBeanPropertyToJson(object, outstandingResearchAward);
            }
            catch(IllegalAccessException e){
                e.printStackTrace();
            }
        }
        return object;
    }
    private Date jsonToDate(JSONObject jsonObject, String str) {
        try {
            return new Date(jsonObject.getDate(str).getTime());
        }catch(Exception e){
            return null;
        }
    }
}
