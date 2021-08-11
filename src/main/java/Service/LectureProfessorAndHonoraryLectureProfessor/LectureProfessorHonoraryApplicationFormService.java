package Service.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorHonoraryApplicationForm;
import Dao.LectureProfessorAndHonoraryLectureProfessor.Impl.LectureProfessorHonoraryApplicationFormDAOImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorHonoraryApplicationFormDAO;
import Service.Teacher.ProjectFillRateService;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class LectureProfessorHonoraryApplicationFormService {
    private LectureProfessorHonoraryApplicationFormDAO lectureProfessorHonoraryApplicationFormDAO = new LectureProfessorHonoraryApplicationFormDAOImpl();
    private ProjectFillRateService projectFillRateService = new ProjectFillRateService();

    public void save(JSONObject jsonObject, String userNumber, String projectID){
        System.out.println("SAVE");
        LectureProfessorHonoraryApplicationForm lectureProfessorHonoraryApplicationForm = new LectureProfessorHonoraryApplicationForm(
                userNumber,
                jsonObject.getString("name"),
                jsonObject.getString("jobAndDept"),
                jsonObject.getString("email"),
                jsonObject.getString("cellphone"),
                jsonObject.getString("indivisualEducation"),
                jsonObject.getString("recommendationReason")

        );
        lectureProfessorHonoraryApplicationForm.setCommitDate(
                jsonObject.getString("commit_date"));

        System.out.println("DONE");
        projectFillRateService.save(Integer.valueOf(projectID), "LectureProfessorHonoraryApplicationForm", jsonObject.getDouble("fill_rate"));
        lectureProfessorHonoraryApplicationFormDAO.save(lectureProfessorHonoraryApplicationForm,projectID);
    }

    public JSONObject show(String userNumber,String projectID) {
        LectureProfessorHonoraryApplicationForm lectureProfessorHonoraryApplicationForm = lectureProfessorHonoraryApplicationFormDAO.show(projectID);
        if(lectureProfessorHonoraryApplicationForm == null) {
            lectureProfessorHonoraryApplicationForm = new LectureProfessorHonoraryApplicationForm(userNumber,"","","","","","");
        }
        System.out.println(lectureProfessorHonoraryApplicationForm);
        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,lectureProfessorHonoraryApplicationForm);
        }catch(IllegalAccessException e){
        }
        return object;
    }

}
