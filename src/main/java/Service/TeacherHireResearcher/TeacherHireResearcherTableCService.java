package Service.TeacherHireResearcher;

import Bean.TeacherHireResearcher.TeacherHireResearcherTableC;
import Dao.TeacherHireResearcher.TeacherHireResearcherTableCDAO;
import Dao.TeacherHireResearcher.impl.TeacherHireResearcherTableCDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class TeacherHireResearcherTableCService {
    private TeacherHireResearcherTableCDAO teacherHireResearcherTableCDAO = new TeacherHireResearcherTableCDAOImpl();

    public void save(JSONObject jsonObject, int rewardProjectId){
        TeacherHireResearcherTableC teacherHireResearcherTableC = new TeacherHireResearcherTableC(
                rewardProjectId,
                jsonObject.getString("numOfPerformancePeriod")
        );

        teacherHireResearcherTableCDAO.save(teacherHireResearcherTableC);
    }

    public JSONObject get(int rewardProjectId){
        TeacherHireResearcherTableC teacherHireResearcherTableC = teacherHireResearcherTableCDAO.get(rewardProjectId);
        JSONObject jsonObject = new JSONObject();

        try {
            addBeanPropertyToJson(jsonObject,teacherHireResearcherTableC);
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }

        return jsonObject;
    }
}
