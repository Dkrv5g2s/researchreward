package Service.DistinguishedProfessor;

import static Utils.ReflectUtils.addBeanPropertyToJson;

import Bean.DistinguishedProfessor.*;
import Bean.User.User;
import Dao.DistinguishedProfessor.*;
import Dao.DistinguishedProfessor.Impl.*;
import Service.Teacher.ProjectFillRateService;
import fr.opensagres.xdocreport.document.json.JSONObject;

public class DistinguishedProfessorFormService {

    private DistinguishedProfessorFormDAO distinguishedProfessorFormDAO = new DistinguishedProfessorFormDAOImpl();

    public void save(JSONObject jsonObject, User user, String projectID){
        switch (user.getRole()) {
            case "teacher":
                saveUserData(jsonObject, user.getStaff_code(), projectID);
                break;
            case "department":
                saveDepartmentData(jsonObject, projectID);
                break;
            case "college":
                saveCollegeData(jsonObject, projectID);
                break;
            case "researchAndDevelopmentOffice":
                saveRADOData(jsonObject, projectID);
                break;
        }
    }
    
    public JSONObject show(String userNumber,String projectID) {
    	DistinguishedProfessorForm distinguishedProfessorForm = distinguishedProfessorFormDAO.show(projectID);
    	if(distinguishedProfessorForm == null) {
    		distinguishedProfessorForm = new DistinguishedProfessorForm(userNumber, "", "", "", "", "", "", "", "", "", false, false, false, false, false, false, false, false, false, "", "", "", "", "", "", "", "", "", "", "");
    	}
    	JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,distinguishedProfessorForm);
        }catch(IllegalAccessException e){

        }
    	return object;
    }

    private void saveUserData(JSONObject jsonObject, String userNumber, String projectID){
        DistinguishedProfessorForm distinguishedProfessorForm = new DistinguishedProfessorForm(
                userNumber,
                jsonObject.getString("name"),
                jsonObject.getString("department"),
                jsonObject.getString("hireddate"),
                jsonObject.getString("certificatenum"),
                jsonObject.getString("upgradedate"),
                jsonObject.getString("seniority"),
                jsonObject.getString("email"),
                jsonObject.getString("researchroomext"),
                jsonObject.getString("cellphone"),
                jsonObject.getBoolean("applicationrequirements1"),
                jsonObject.getBoolean("applicationrequirements2"),
                jsonObject.getBoolean("applicationrequirements3"),
                jsonObject.getBoolean("applicationrequirements4"),
                jsonObject.getBoolean("applicationrequirements5"),
                jsonObject.getBoolean("applicationrequirements6"),
                jsonObject.getBoolean("applicationrequirements7"),
                jsonObject.getBoolean("applicationrequirements8"),
                jsonObject.getBoolean("applicationrequirements9"));
        distinguishedProfessorFormDAO.save(distinguishedProfessorForm,projectID);

        ProjectFillRateService projectFillRateService = new ProjectFillRateService();
        projectFillRateService.save(Integer.valueOf(projectID), "DistinguishedProfessorForm", jsonObject.getDouble("fill_rate"));
    }

    private void saveDepartmentData(JSONObject jsonObject, String projectID){
        DistinguishedProfessorForm distinguishedProfessorForm = new DistinguishedProfessorForm();
        distinguishedProfessorForm.setDepartmentAcademicYear(jsonObject.getString("department_academic_year"));
        distinguishedProfessorForm.setDepartmentSemester(jsonObject.getString("department_semester"));
        distinguishedProfessorForm.setDepartmentConferenceTimes(jsonObject.getString("department_conference_times"));
        distinguishedProfessorForm.setDepartmentSignDate(jsonObject.getString("department_sign_date"));
        distinguishedProfessorFormDAO.saveDepartmentData(distinguishedProfessorForm,projectID);
    }
    private void saveCollegeData(JSONObject jsonObject, String projectID){
        DistinguishedProfessorForm distinguishedProfessorForm = new DistinguishedProfessorForm();
        distinguishedProfessorForm.setCollegeAcademicYear(jsonObject.getString("college_academic_year"));
        distinguishedProfessorForm.setCollegeSemester(jsonObject.getString("college_semester"));
        distinguishedProfessorForm.setCollegeConferenceTimes(jsonObject.getString("college_conference_times"));
        distinguishedProfessorForm.setCollegeSignDate(jsonObject.getString("college_sign_date"));
        distinguishedProfessorFormDAO.saveCollegeData(distinguishedProfessorForm,projectID);

    }
    private void saveRADOData(JSONObject jsonObject, String projectID){  //research and development office
        DistinguishedProfessorForm distinguishedProfessorForm = new DistinguishedProfessorForm();
        distinguishedProfessorForm.setResearchAndDevelopmentOfficeSignYear(jsonObject.getString("research_and_development_office_sign_year"));
        distinguishedProfessorForm.setResearchAndDevelopmentOfficeSignMonth(jsonObject.getString("research_and_development_office_sign_month"));
        distinguishedProfessorForm.setResearchAndDevelopmentOfficeSignDate(jsonObject.getString("research_and_development_office_sign_date"));
        distinguishedProfessorFormDAO.saveRADOData(distinguishedProfessorForm,projectID);
    }
}
