package Service.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormC;
import Dao.LectureProfessorAndHonoraryLectureProfessor.Impl.LectureProfessorExcellenceFormCDAOImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormCDAO;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class LectureProfessorExcellenceFormCService {
    private LectureProfessorExcellenceFormCDAO lectureProfessorExcellenceFormCDAO = new LectureProfessorExcellenceFormCDAOImpl();

    public void save(JSONObject jsonObject, String userNumber, String projectID){
        System.out.println("SAVE");
        LectureProfessorExcellenceFormC lectureProfessorExcellenceFormC = new LectureProfessorExcellenceFormC(
                userNumber,
                jsonObject.getString("recommendationReason"));
        System.out.println("DONE");

        lectureProfessorExcellenceFormCDAO.save(lectureProfessorExcellenceFormC,projectID);
    }

    public JSONObject show(String userNumber,String projectID) {
        LectureProfessorExcellenceFormC lectureProfessorExcellenceFormC = lectureProfessorExcellenceFormCDAO.show(projectID);
        if(lectureProfessorExcellenceFormC == null) {
            lectureProfessorExcellenceFormC = new LectureProfessorExcellenceFormC(userNumber, "");
        }
        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,lectureProfessorExcellenceFormC);
        }catch(IllegalAccessException e){
        }
        return object;
    }

}
