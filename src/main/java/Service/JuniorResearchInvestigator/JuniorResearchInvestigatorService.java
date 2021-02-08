package Service.JuniorResearchInvestigator;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigator;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorDAO;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;
import java.sql.Date;
import static Utils.ReflectUtils.addBeanPropertyToJson;

public class JuniorResearchInvestigatorService {

    private JuniorResearchInvestigatorDAO juniorResearchInvestigatorDAO = new JuniorResearchInvestigatorDAOImpl();
    public void save(JSONObject jsonObject, int project_id){
        JuniorResearchInvestigator juniorResearchInvestigator = new JuniorResearchInvestigator();// = null;

        juniorResearchInvestigator.setProjectId(project_id);
        juniorResearchInvestigator.setUserNumber(jsonObject.getInt("user_number"));
        juniorResearchInvestigator.setUserName(jsonObject.getString("user_name"));
        juniorResearchInvestigator.setApplicantTitle(jsonObject.getString("applicant_title"));
        juniorResearchInvestigator.setDepartment(jsonObject.getString("department"));
        juniorResearchInvestigator.setBirthDate(jsonToDate(jsonObject, "birth_date"));
        juniorResearchInvestigator.setIdentityNumber(jsonObject.getString("identity_number"));
        juniorResearchInvestigator.setEmploymentDate(jsonToDate(jsonObject, "employment_date"));
        juniorResearchInvestigator.setExtensionNumber(jsonObject.getString("extension_number"));
        juniorResearchInvestigator.setCellphoneNumber(jsonObject.getString("cellphone_number"));
        juniorResearchInvestigator.setRecommendedReason(jsonObject.getString("recommended_reason"));

        juniorResearchInvestigatorDAO.save(juniorResearchInvestigator, project_id);
    }

    public JSONObject show(int project_id) {
        JuniorResearchInvestigator juniorResearchInvestigator = juniorResearchInvestigatorDAO.show(project_id);
        JSONObject object = new JSONObject();
        if(juniorResearchInvestigator != null) {
            try {
                addBeanPropertyToJson(object, juniorResearchInvestigator);
            }
            catch(IllegalAccessException e){
                e.printStackTrace();
            }
        }
        return object;
    }
    private Date jsonToDate(JSONObject jsonObject, String str) {
        try {
            return new java.sql.Date(jsonObject.getDate(str).getTime());
        }catch(Exception e){
            return null;
        }
    }
}
