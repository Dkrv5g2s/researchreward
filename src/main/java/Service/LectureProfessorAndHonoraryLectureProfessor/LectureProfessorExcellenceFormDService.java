package Service.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormD;
import Dao.LectureProfessorAndHonoraryLectureProfessor.Impl.LectureProfessorExcellenceFormDDAOImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormDDAO;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class LectureProfessorExcellenceFormDService {
    private LectureProfessorExcellenceFormDDAO lectureProfessorExcellenceFormDDAO = new LectureProfessorExcellenceFormDDAOImpl();

    public void save(JSONObject jsonObject, String userNumber, String projectID){
        System.out.println("SAVE");
        LectureProfessorExcellenceFormD lectureProfessorExcellenceFormD = new LectureProfessorExcellenceFormD(
                userNumber,
                jsonObject.getString("depart"),
                jsonObject.getString("name"),
                jsonObject.getString("speechTime"),
                jsonObject.getString("payment"),
                jsonObject.getString("performance"));
        System.out.println("DONE");

        lectureProfessorExcellenceFormDDAO.save(lectureProfessorExcellenceFormD,projectID);
    }

    public JSONObject show(String userNumber,String projectID) {
        LectureProfessorExcellenceFormD lectureProfessorExcellenceFormD = lectureProfessorExcellenceFormDDAO.show(projectID);
        if(lectureProfessorExcellenceFormD == null) {
            lectureProfessorExcellenceFormD = new LectureProfessorExcellenceFormD(userNumber, "", "", "", "", "");
        }
        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,lectureProfessorExcellenceFormD);
        }catch(IllegalAccessException e){
        }
        return object;
    }

}
