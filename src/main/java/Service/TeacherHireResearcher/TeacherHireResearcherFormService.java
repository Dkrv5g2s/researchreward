package Service.TeacherHireResearcher;

import Bean.TeacherHireResearcher.TeacherHireResearcherForm;
import Dao.TeacherHireResearcher.TeacherHireResearcherFormDAO;
import Dao.TeacherHireResearcher.impl.TeacherHireResearcherFormDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.sql.Date;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class TeacherHireResearcherFormService {
    private TeacherHireResearcherFormDAO teacherHireResearcherFormDAO = new TeacherHireResearcherFormDAOImpl();

    public void save(JSONObject jsonObject, int rewardProjectId){
        TeacherHireResearcherForm teacherHireResearcherForm = new TeacherHireResearcherForm(
                rewardProjectId,
                jsonObject.getString("applicantName"),
                jsonObject.getString("applicantJobTitle"),
                jsonObject.getString("applicantDepartment"),
                jsonObject.getString("applicantEmail"),
                jsonObject.getString("applicantSeniority"),
                jsonObject.getString("applicantResearchRoomExt"),
                jsonObject.getString("applicantPhone"),
                jsonObject.getString("researcherType"),
                jsonObject.getString("researcherName"),
                jsonObject.getString("researcherJobTitle"),
                jsonObject.getString("researcherSalaryScale"),
                jsonObject.getString("projectCategory"),
                jsonObject.getString("projectName"),
                jsonObject.getString("projectAmount"),
                jsonObject.getString("expectedPerformanceNearFiveYears"),
                jsonObject.getString("expectedPerformancePerYears"),
                jsonObject.getString("expectedPerformanceOthers"),
                jsonObject.getString("applyForSubsidies")
                );

        teacherHireResearcherFormDAO.save(teacherHireResearcherForm);
    }

    public void updateDepartmentReviewData(JSONObject jsonObject, int rewardProjectId) {
        TeacherHireResearcherForm departmentReviewData = new TeacherHireResearcherForm();
        departmentReviewData.setRewardProjectId(rewardProjectId);
        departmentReviewData.setDepartmentAcademicYear(jsonObject.getString("departmentAcademicYear"));
        departmentReviewData.setDepartmentSemester(jsonObject.getString("departmentSemester"));
        departmentReviewData.setDepartmentConferenceTimes(jsonObject.getString("departmentConferenceTimes"));
        departmentReviewData.setDepartmentSignDate(jsonToDate(jsonObject, "departmentSignDate"));

        teacherHireResearcherFormDAO.updateDepartmentReviewData(departmentReviewData);
    }

    public void updateCollegeReviewData(JSONObject jsonObject, int rewardProjectId) {
        TeacherHireResearcherForm collegeReviewData = new TeacherHireResearcherForm();
        collegeReviewData.setRewardProjectId(rewardProjectId);
        collegeReviewData.setCollegeAcademicYear(jsonObject.getString("collegeAcademicYear"));
        collegeReviewData.setCollegeSemester(jsonObject.getString("collegeSemester"));
        collegeReviewData.setCollegeConferenceTimes(jsonObject.getString("collegeConferenceTimes"));
        collegeReviewData.setCollegeSignDate(jsonToDate(jsonObject, "collegeSignDate"));

        teacherHireResearcherFormDAO.updateCollegeReviewData(collegeReviewData);
    }

    public void updateRADOReviewData(JSONObject jsonObject, int rewardProjectId) {
        TeacherHireResearcherForm RADOReviewData = new TeacherHireResearcherForm();
        RADOReviewData.setRewardProjectId(rewardProjectId);
        RADOReviewData.setResearchAndDevelopmentOfficeSignYear(jsonObject.getString("researchAndDevelopmentOfficeSignYear"));
        RADOReviewData.setResearchAndDevelopmentOfficeSignMonth(jsonObject.getString("researchAndDevelopmentOfficeSignMonth"));
        RADOReviewData.setResearchAndDevelopmentOfficeSignDate(jsonObject.getString("researchAndDevelopmentOfficeSignDate"));

        teacherHireResearcherFormDAO.updateRADOReviewData(RADOReviewData);
    }

    public JSONObject get(int rewardProjectId){
        TeacherHireResearcherForm teacherHireResearcherForm = teacherHireResearcherFormDAO.get(rewardProjectId);
        JSONObject jsonObject = new JSONObject();

        try {
            addBeanPropertyToJson(jsonObject,teacherHireResearcherForm);
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }

        return jsonObject;
    }

    private Date jsonToDate(JSONObject jsonObject, String str) {
        try {
            return new java.sql.Date(jsonObject.getDate(str).getTime());
        }catch(Exception e){
            return null;
        }
    }
}
