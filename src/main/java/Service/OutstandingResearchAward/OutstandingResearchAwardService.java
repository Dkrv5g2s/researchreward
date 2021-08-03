package Service.OutstandingResearchAward;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigator;
import Bean.OutstandingResearchAward.OutstandingResearchAward;
import Dao.OutstandingResearchAward.OutstandingResearchAwardDAO;
import Dao.OutstandingResearchAward.OutstandingResearchAwardDAOImpl;
import Service.Teacher.ProjectFillRateService;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.sql.Date;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class OutstandingResearchAwardService {

    private OutstandingResearchAwardDAO outstandingResearchAwardDAO = new OutstandingResearchAwardDAOImpl();
    private ProjectFillRateService projectFillRateService = new ProjectFillRateService();

    public void save(JSONObject jsonObject, int project_id, String userRole){
        OutstandingResearchAward outstandingResearchAward = new OutstandingResearchAward();// = null;

        outstandingResearchAward.setProjectId(project_id);
        switch (userRole) {
            case "teacher":
                outstandingResearchAward = setUserData(outstandingResearchAward, jsonObject);
                outstandingResearchAwardDAO.save(outstandingResearchAward, project_id);
                projectFillRateService.save(project_id, "OutstandingResearchAward", jsonObject.getDouble("fill_rate"));
                break;
            case "department":
                outstandingResearchAward = setDepartmentData(outstandingResearchAward, jsonObject);
                outstandingResearchAwardDAO.updateDepartmentData(outstandingResearchAward);
                break;
            case "college":
                outstandingResearchAward = setCollegeData(outstandingResearchAward, jsonObject);
                outstandingResearchAwardDAO.updateCollegeData(outstandingResearchAward);
                break;
            case "researchAndDevelopmentOffice":
                outstandingResearchAward = setRADOData(outstandingResearchAward, jsonObject);
                outstandingResearchAwardDAO.updateRADOData(outstandingResearchAward);
                break;
        }
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

    private OutstandingResearchAward setUserData(OutstandingResearchAward outstandingResearchAward, JSONObject jsonObject) {

        outstandingResearchAward.setUserNumber(jsonObject.getInt("user_number"));
        outstandingResearchAward.setUserName(jsonObject.getString("user_name"));
        outstandingResearchAward.setApplicantTitle(jsonObject.getString("applicant_title"));
        outstandingResearchAward.setDepartment(jsonObject.getString("department"));
        outstandingResearchAward.setEmploymentDate(jsonToDate(jsonObject, "employment_date"));
        outstandingResearchAward.setExtensionNumber(jsonObject.getString("extension_number"));
        outstandingResearchAward.setCellphoneNumber(jsonObject.getString("cellphone_number"));
        outstandingResearchAward.setRecommendedReason(jsonObject.getString("recommended_reason"));

        return outstandingResearchAward;
    }

    private OutstandingResearchAward setDepartmentData(OutstandingResearchAward outstandingResearchAward, JSONObject jsonObject) {
        outstandingResearchAward.setDepartmentAcademicYear(jsonObject.getString("department_academic_year"));
        outstandingResearchAward.setDepartmentSemester(jsonObject.getString("department_semester"));
        outstandingResearchAward.setDepartmentConferenceTimes(jsonObject.getString("department_conference_times"));
        outstandingResearchAward.setDepartmentSignDate(jsonToDate(jsonObject, "department_sign_date"));
        return outstandingResearchAward;
    }
    private OutstandingResearchAward setCollegeData(OutstandingResearchAward outstandingResearchAward, JSONObject jsonObject) {
        outstandingResearchAward.setCollegeAcademicYear(jsonObject.getString("college_academic_year"));
        outstandingResearchAward.setCollegeSemester(jsonObject.getString("college_semester"));
        outstandingResearchAward.setCollegeConferenceTimes(jsonObject.getString("college_conference_times"));
        outstandingResearchAward.setCollegeSignDate(jsonToDate(jsonObject, "college_sign_date"));
        return outstandingResearchAward;
    }
    private OutstandingResearchAward setRADOData(OutstandingResearchAward outstandingResearchAward, JSONObject jsonObject) {
        outstandingResearchAward.setResearchAndDevelopmentOfficeSignYear(jsonObject.getString("research_and_development_office_sign_year"));
        outstandingResearchAward.setResearchAndDevelopmentOfficeSignMonth(jsonObject.getString("research_and_development_office_sign_month"));
        outstandingResearchAward.setResearchAndDevelopmentOfficeSignDate(jsonObject.getString("research_and_development_office_sign_date"));
        return outstandingResearchAward;
    }
}
