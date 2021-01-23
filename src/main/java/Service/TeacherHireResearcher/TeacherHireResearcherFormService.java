package Service.TeacherHireResearcher;

import Bean.TeacherHireResearcher.TeacherHireResearcherForm;
import Dao.TeacherHireResearcher.TeacherHireResearcherFormDAO;
import Dao.TeacherHireResearcher.impl.TeacherHireResearcherFormDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class TeacherHireResearcherFormService {
    private TeacherHireResearcherFormDAO teacherHireResearcherFormDAO = new TeacherHireResearcherFormDAOImpl();

    public void save(JSONObject jsonObject, int rewardProjectId){
        TeacherHireResearcherForm teacherHireResearcherForm = new TeacherHireResearcherForm(
                rewardProjectId,
                jsonObject.getString("applyType"),
                jsonObject.getString("applyTypeDescription"),
                jsonObject.getString("researcherType"),
                jsonObject.getString("applicantName"),
                jsonObject.getString("applicantJobTitle"),
                jsonObject.getString("applicantDepartment"),
                jsonObject.getString("applicantEmail"),
                jsonObject.getString("applicantSeniority"),
                jsonObject.getString("applicantResearchRoomExt"),
                jsonObject.getString("applicantPhone"),
                jsonObject.getString("researcherName"),
                jsonObject.getString("researcherBirthDate"),
                jsonObject.getString("researcherIdNum"),
                jsonObject.getString("researcherPhone"),
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

}
