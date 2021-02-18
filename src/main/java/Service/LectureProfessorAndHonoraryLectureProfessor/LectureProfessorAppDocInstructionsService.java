package Service.LectureProfessorAndHonoraryLectureProfessor;

import static Utils.ReflectUtils.addBeanPropertyToJson;

import java.util.ArrayList;
import java.util.List;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorAppDocInstructions;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorAppDocInstructionsDAO;
import Dao.LectureProfessorAndHonoraryLectureProfessor.Impl.LectureProfessorAppDocInstructionsDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

public class LectureProfessorAppDocInstructionsService {
    private LectureProfessorAppDocInstructionsDAO lectureProfessorAppDocInstructionsDAO = new LectureProfessorAppDocInstructionsDAOImpl();

    public void save(JSONArray jsonArray, String userNumber, String projectID){
        List<LectureProfessorAppDocInstructions> list = new ArrayList<>();

        for (Object element: jsonArray) {
            JSONObject jsonObject = (JSONObject)element;
            list.add(new LectureProfessorAppDocInstructions(
                    userNumber,
                    jsonObject.getString("technologyTransferContractName"),
                    jsonObject.getString("technologyTransferDepartment"),
                    jsonObject.getString("contractDate"),
                    jsonObject.getString("technologyTransferFund"),
                    jsonObject.getString("technologyTransferFundBringInDate")));
        }

        lectureProfessorAppDocInstructionsDAO.save(list, userNumber, projectID);
    }

    public JSONArray show(String projectID) {
        List<LectureProfessorAppDocInstructions> lectureProfessorAppDocInstructions = lectureProfessorAppDocInstructionsDAO.show(projectID);
        if(lectureProfessorAppDocInstructions == null) {
            lectureProfessorAppDocInstructions = new ArrayList<>();
        }
        JSONArray object = new JSONArray();

        try {
            object.add(toJsonArray(lectureProfessorAppDocInstructions));
        }catch(IllegalAccessException e){

        }
        return object;
    }

    private JSONArray toJsonArray(List<LectureProfessorAppDocInstructions> list) throws IllegalAccessException {
        JSONArray array = new JSONArray();

        for(LectureProfessorAppDocInstructions lectureProfessorAppDocInstructions : list){
            JSONObject object = new JSONObject();
            addBeanPropertyToJson(object,lectureProfessorAppDocInstructions);
            array.add(object);
        }

        return array;
    }
}
