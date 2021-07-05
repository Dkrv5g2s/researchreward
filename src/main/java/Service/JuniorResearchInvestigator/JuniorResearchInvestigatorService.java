package Service.JuniorResearchInvestigator;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigator;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorDAO;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;
import java.sql.Date;
import static Utils.ReflectUtils.addBeanPropertyToJson;

public class JuniorResearchInvestigatorService {

    private JuniorResearchInvestigatorDAO juniorResearchInvestigatorDAO = new JuniorResearchInvestigatorDAOImpl();
    public void save(JSONObject jsonObject, int projectId){
        JuniorResearchInvestigator juniorResearchInvestigator = new JuniorResearchInvestigator();

        juniorResearchInvestigator.setProjectId(projectId);
        juniorResearchInvestigator.setUserNumber(jsonObject.getInt("user_number"));
        juniorResearchInvestigator.setUserName(jsonObject.getString("user_name"));
        juniorResearchInvestigator.setApplicantTitle(jsonObject.getString("applicant_title"));
        juniorResearchInvestigator.setDepartment(jsonObject.getString("department"));
        juniorResearchInvestigator.setEmploymentDate(jsonToDate(jsonObject, "employment_date"));
        juniorResearchInvestigator.setExtensionNumber(jsonObject.getString("extension_number"));
        juniorResearchInvestigator.setCellphoneNumber(jsonObject.getString("cellphone_number"));
        juniorResearchInvestigator.setRecommendedReason(jsonObject.getString("recommended_reason"));

        juniorResearchInvestigatorDAO.save(juniorResearchInvestigator, projectId);
    }

    public JSONObject show(int projectId) {
        JuniorResearchInvestigator juniorResearchInvestigator = juniorResearchInvestigatorDAO.show(projectId);
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
