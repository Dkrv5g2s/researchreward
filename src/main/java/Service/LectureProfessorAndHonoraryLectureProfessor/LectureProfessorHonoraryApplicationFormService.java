package Service.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorHonoraryApplicationForm;
import Dao.LectureProfessorAndHonoraryLectureProfessor.Impl.LectureProfessorHonoraryApplicationFormDAOImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorHonoraryApplicationFormDAO;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class LectureProfessorHonoraryApplicationFormService {
    private LectureProfessorHonoraryApplicationFormDAO lectureProfessorHonoraryApplicationFormDAO = new LectureProfessorHonoraryApplicationFormDAOImpl();

    public void save(JSONObject jsonObject, String userNumber, String projectID){
        System.out.println("SAVE");
        LectureProfessorHonoraryApplicationForm lectureProfessorHonoraryApplicationForm = new LectureProfessorHonoraryApplicationForm(
                userNumber,
                jsonObject.getString("name"),
                jsonObject.getString("jobAndDept"),
                jsonObject.getString("email"),
                jsonObject.getString("researchroomext"),
                jsonObject.getString("cellphone"),
                jsonObject.getString("indivisualEducation"),
                jsonObject.getString("recommendationReason"));
        System.out.println("DONE");

        lectureProfessorHonoraryApplicationFormDAO.save(lectureProfessorHonoraryApplicationForm,projectID);
    }

    public JSONObject show(String userNumber,String projectID) {
        LectureProfessorHonoraryApplicationForm lectureProfessorHonoraryApplicationForm = lectureProfessorHonoraryApplicationFormDAO.show(projectID);
        if(lectureProfessorHonoraryApplicationForm == null) {
            lectureProfessorHonoraryApplicationForm = new LectureProfessorHonoraryApplicationForm(userNumber,"","","","","","","");
        }
        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,lectureProfessorHonoraryApplicationForm);
        }catch(IllegalAccessException e){
        }
        return object;
    }

}
