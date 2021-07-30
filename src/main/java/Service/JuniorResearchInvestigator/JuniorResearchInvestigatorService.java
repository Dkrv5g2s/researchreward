package Service.JuniorResearchInvestigator;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigator;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorDAO;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorDAOImpl;
import Service.Teacher.ProjectFillRateService;
import fr.opensagres.xdocreport.document.json.JSONObject;
import java.sql.Date;
import static Utils.ReflectUtils.addBeanPropertyToJson;

public class JuniorResearchInvestigatorService {

    private JuniorResearchInvestigatorDAO juniorResearchInvestigatorDAO = new JuniorResearchInvestigatorDAOImpl();
    private ProjectFillRateService projectFillRateService = new ProjectFillRateService();

    public void save(JSONObject jsonObject, int projectId, String userRole){
        JuniorResearchInvestigator juniorResearchInvestigator = new JuniorResearchInvestigator();
        juniorResearchInvestigator.setProjectId(projectId);
        switch (userRole) {
            case "teacher":
                juniorResearchInvestigator = setUserData(juniorResearchInvestigator, jsonObject);
                juniorResearchInvestigatorDAO.save(juniorResearchInvestigator);
                projectFillRateService.save(projectId, "JuniorResearchInvestigator", jsonObject.getDouble("fill_rate"));
                break;
            case "department":
                juniorResearchInvestigator = setDepartmentData(juniorResearchInvestigator, jsonObject);
                juniorResearchInvestigatorDAO.updateDepartmentData(juniorResearchInvestigator);
                break;
            case "college":
                juniorResearchInvestigator = setCollegeData(juniorResearchInvestigator, jsonObject);
                juniorResearchInvestigatorDAO.updateCollegeData(juniorResearchInvestigator);
                break;
            case "researchAndDevelopmentOffice":
                juniorResearchInvestigator = setRADOData(juniorResearchInvestigator, jsonObject);
                juniorResearchInvestigatorDAO.updateRADOData(juniorResearchInvestigator);
                break;
        }
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

    private JuniorResearchInvestigator setUserData(JuniorResearchInvestigator juniorResearchInvestigator, JSONObject jsonObject) {
        juniorResearchInvestigator.setUserNumber(jsonObject.getString("user_number"));
        juniorResearchInvestigator.setUserName(jsonObject.getString("user_name"));
        juniorResearchInvestigator.setApplicantTitle(jsonObject.getString("applicant_title"));
        juniorResearchInvestigator.setDepartment(jsonObject.getString("department"));
        juniorResearchInvestigator.setEmploymentDate(jsonToDate(jsonObject, "employment_date"));
        juniorResearchInvestigator.setExtensionNumber(jsonObject.getString("extension_number"));
        juniorResearchInvestigator.setCellphoneNumber(jsonObject.getString("cellphone_number"));
        juniorResearchInvestigator.setRecommendedReason(jsonObject.getString("recommended_reason"));
        return juniorResearchInvestigator;
    }

    private JuniorResearchInvestigator setDepartmentData(JuniorResearchInvestigator juniorResearchInvestigator, JSONObject jsonObject) {
        juniorResearchInvestigator.setDepartmentAcademicYear(jsonObject.getString("department_academic_year"));
        juniorResearchInvestigator.setDepartmentSemester(jsonObject.getString("department_semester"));
        juniorResearchInvestigator.setDepartmentConferenceTimes(jsonObject.getString("department_conference_times"));
        juniorResearchInvestigator.setDepartmentSignDate(jsonToDate(jsonObject, "department_sign_date"));
        return juniorResearchInvestigator;
    }
    private JuniorResearchInvestigator setCollegeData(JuniorResearchInvestigator juniorResearchInvestigator, JSONObject jsonObject) {
        juniorResearchInvestigator.setCollegeAcademicYear(jsonObject.getString("college_academic_year"));
        juniorResearchInvestigator.setCollegeSemester(jsonObject.getString("college_semester"));
        juniorResearchInvestigator.setCollegeConferenceTimes(jsonObject.getString("college_conference_times"));
        juniorResearchInvestigator.setCollegeSignDate(jsonToDate(jsonObject, "college_sign_date"));
        return juniorResearchInvestigator;
    }
    private JuniorResearchInvestigator setRADOData(JuniorResearchInvestigator juniorResearchInvestigator, JSONObject jsonObject) {
        juniorResearchInvestigator.setResearchAndDevelopmentOfficeSignYear(jsonObject.getString("research_and_development_office_sign_year"));
        juniorResearchInvestigator.setResearchAndDevelopmentOfficeSignMonth(jsonObject.getString("research_and_development_office_sign_month"));
        juniorResearchInvestigator.setResearchAndDevelopmentOfficeSignDate(jsonObject.getString("research_and_development_office_sign_date"));
        return juniorResearchInvestigator;
    }
}
