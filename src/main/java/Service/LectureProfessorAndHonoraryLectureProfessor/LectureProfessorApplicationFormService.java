package Service.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorApplicationForm;
import Dao.LectureProfessorAndHonoraryLectureProfessor.Impl.LectureProfessorApplicationFormDAOImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorApplicationFormDAO;
import Service.Teacher.ProjectFillRateService;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.sql.Date;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class LectureProfessorApplicationFormService {
    private LectureProfessorApplicationFormDAO lectureProfessorApplicationFormDAO = new LectureProfessorApplicationFormDAOImpl();
    private ProjectFillRateService projectFillRateService = new ProjectFillRateService();

    public void save(JSONObject jsonObject, String userNumber, String projectID, String userRole){
        System.out.println("SAVE");

        LectureProfessorApplicationForm lectureProfessorApplicationForm = new LectureProfessorApplicationForm();
        lectureProfessorApplicationForm.setUsernum(userNumber);
        switch (userRole) {
            case "teacher":
                lectureProfessorApplicationForm = setUserData(lectureProfessorApplicationForm, jsonObject);
                lectureProfessorApplicationFormDAO.save(lectureProfessorApplicationForm, projectID);
                projectFillRateService.save(Integer.valueOf(projectID), "LectureProfessorApplicationForm", jsonObject.getDouble("fill_rate"));
                break;
            case "department":
                lectureProfessorApplicationForm = setDepartmentData(lectureProfessorApplicationForm, jsonObject);
                lectureProfessorApplicationFormDAO.updateDepartmentData(lectureProfessorApplicationForm);
                break;
            case "college":
                lectureProfessorApplicationForm = setCollegeData(lectureProfessorApplicationForm, jsonObject);
                lectureProfessorApplicationFormDAO.updateCollegeData(lectureProfessorApplicationForm);
                break;
            case "researchAndDevelopmentOffice":
                lectureProfessorApplicationForm = setRADOData(lectureProfessorApplicationForm, jsonObject);
                lectureProfessorApplicationFormDAO.updateRADOData(lectureProfessorApplicationForm);
                break;
        }


        System.out.println("DONE");

        lectureProfessorApplicationFormDAO.save(lectureProfessorApplicationForm,projectID);
    }

    private LectureProfessorApplicationForm setUserData(LectureProfessorApplicationForm lectureProfessorApplicationForm, JSONObject jsonObject) {
        lectureProfessorApplicationForm.setName( jsonObject.getString("name"));
        lectureProfessorApplicationForm.setJob( jsonObject.getString("job"));
        lectureProfessorApplicationForm.setServiceSchoolAndDepartment(jsonObject.getString("serviceSchoolAndDepartment"));
        lectureProfessorApplicationForm.setCertificatenum( jsonObject.getString("certificatenum"));
        lectureProfessorApplicationForm.setWorkStartDate(jsonObject.getString("workStartDate"));
        lectureProfessorApplicationForm.setSeniority(jsonObject.getString("seniority"));
        lectureProfessorApplicationForm.setEmail(jsonObject.getString("email"));
        lectureProfessorApplicationForm.setResearchroomext(jsonObject.getString("researchroomext"));
        lectureProfessorApplicationForm.setCellphone(jsonObject.getString("cellphone"));


        lectureProfessorApplicationForm.setLectureCategoryExp(jsonObject.getBoolean("lectureCategoryExp"));
        lectureProfessorApplicationForm.setLectureCategoryInv(jsonObject.getBoolean("lectureCategoryInv"));
        lectureProfessorApplicationForm.setLectureCategoryLif(jsonObject.getBoolean("lectureCategoryLif"));

        lectureProfessorApplicationForm.setApplicationrequirements1(jsonObject.getBoolean("applicationrequirements1"));
        lectureProfessorApplicationForm.setApplicationrequirements2(jsonObject.getBoolean("applicationrequirements2"));
        lectureProfessorApplicationForm.setApplicationrequirements3(jsonObject.getBoolean("applicationrequirements3"));
        lectureProfessorApplicationForm.setApplicationrequirements4(jsonObject.getBoolean("applicationrequirements4"));
        lectureProfessorApplicationForm.setApplicationrequirements5(jsonObject.getBoolean("applicationrequirements5"));
        lectureProfessorApplicationForm.setApplicationrequirements6(jsonObject.getBoolean("applicationrequirements6"));
        lectureProfessorApplicationForm.setApplicationrequirements7(jsonObject.getBoolean("applicationrequirements7"));
        lectureProfessorApplicationForm.setApplicationrequirements8(jsonObject.getBoolean("applicationrequirements8"));
        lectureProfessorApplicationForm.setApplicationrequirements9(jsonObject.getBoolean("applicationrequirements9"));
        lectureProfessorApplicationForm.setApplicationrequirements10(jsonObject.getBoolean("applicationrequirements10"));
        lectureProfessorApplicationForm.setApplicationrequirements11(jsonObject.getBoolean("applicationrequirements11"));
        lectureProfessorApplicationForm.setApplicationrequirements12(jsonObject.getBoolean("applicationrequirements12"));
        lectureProfessorApplicationForm.setApplicationrequirements13(jsonObject.getBoolean("applicationrequirements13"));
        lectureProfessorApplicationForm.setApplicationrequirements14(jsonObject.getBoolean("applicationrequirements14"));
        lectureProfessorApplicationForm.setApplicationrequirements15(jsonObject.getBoolean("applicationrequirements15"));
        lectureProfessorApplicationForm.setApplicationrequirementsCheck(jsonObject.getBoolean("applicationrequirementsCheck"));
        lectureProfessorApplicationForm.setAdditionalInfo(jsonObject.getString("additionalInfo"));

        return lectureProfessorApplicationForm;
    }

    private LectureProfessorApplicationForm setDepartmentData(LectureProfessorApplicationForm lectureProfessorApplicationForm, JSONObject jsonObject) {
        lectureProfessorApplicationForm.setDepartmentAcademicYear(jsonObject.getString("department_academic_year"));
        lectureProfessorApplicationForm.setDepartmentSemester(jsonObject.getString("department_semester"));
        lectureProfessorApplicationForm.setDepartmentConferenceTimes(jsonObject.getString("department_conference_times"));
        lectureProfessorApplicationForm.setDepartmentSignDate(jsonToDate(jsonObject, "department_sign_date"));
        return lectureProfessorApplicationForm;
    }
    private LectureProfessorApplicationForm setCollegeData(LectureProfessorApplicationForm lectureProfessorApplicationForm, JSONObject jsonObject) {
        lectureProfessorApplicationForm.setCollegeAcademicYear(jsonObject.getString("college_academic_year"));
        lectureProfessorApplicationForm.setCollegeSemester(jsonObject.getString("college_semester"));
        lectureProfessorApplicationForm.setCollegeConferenceTimes(jsonObject.getString("college_conference_times"));
        lectureProfessorApplicationForm.setCollegeSignDate(jsonToDate(jsonObject, "college_sign_date"));
        return lectureProfessorApplicationForm;
    }
    private LectureProfessorApplicationForm setRADOData(LectureProfessorApplicationForm lectureProfessorApplicationForm, JSONObject jsonObject) {
        lectureProfessorApplicationForm.setResearchAndDevelopmentOfficeSignYear(jsonObject.getString("research_and_development_office_sign_year"));
        lectureProfessorApplicationForm.setResearchAndDevelopmentOfficeSignMonth(jsonObject.getString("research_and_development_office_sign_month"));
        lectureProfessorApplicationForm.setResearchAndDevelopmentOfficeSignDate(jsonObject.getString("research_and_development_office_sign_date"));
        return lectureProfessorApplicationForm;
    }
    public JSONObject show(String userNumber,String projectID) {
        LectureProfessorApplicationForm lectureProfessorApplicationForm = lectureProfessorApplicationFormDAO.show(projectID);
        if(lectureProfessorApplicationForm == null) {
            lectureProfessorApplicationForm = new LectureProfessorApplicationForm(Integer.valueOf(projectID),userNumber, "",  "",  "",  "",  "",  "",  "",  "",  "", false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,false,false,false,"");
        }
        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,lectureProfessorApplicationForm);
        }catch(IllegalAccessException e){
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
