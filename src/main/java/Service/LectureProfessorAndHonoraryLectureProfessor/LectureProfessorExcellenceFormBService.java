package Service.LectureProfessorAndHonoraryLectureProfessor;

import static Utils.ReflectUtils.addBeanPropertyToJson;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormB;
import Dao.LectureProfessorAndHonoraryLectureProfessor.Impl.LectureProfessorExcellenceFormBDAOImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormBDAO;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LectureProfessorExcellenceFormBService {
    private LectureProfessorExcellenceFormBDAO lectureProfessorExcellenceFormBDAO = new LectureProfessorExcellenceFormBDAOImpl();

    public void save(JSONArray jsonArray, String userNumber, String projectID){
        List<LectureProfessorExcellenceFormB> list = new ArrayList<>();

        for (Object element: jsonArray) {
            JSONObject jsonObject = (JSONObject)element;
            list.add(new LectureProfessorExcellenceFormB(
                    userNumber,
                    jsonObject.getString("author"),
                    jsonObject.getString("book_name"),
                    jsonObject.getString("article_name"),
                    jsonObject.getString("total_roll"),
                    jsonObject.getString("total_page"),
                    jsonObject.getString("publish_time"),
                    jsonObject.getBoolean("rank_condition_one"),
                    jsonObject.getBoolean("rank_condition_two"),
                    jsonObject.getBoolean("rank_condition_three"),
                    jsonObject.getBoolean("rank_condition_four"),
                    jsonObject.getBoolean("rank_condition_five"),
                    jsonObject.getBoolean("rank_condition_six"),
                    jsonObject.getBoolean("rank_condition_seven"),
                    jsonObject.getBoolean("author_order_one"),
                    jsonObject.getBoolean("author_order_two"),
                    jsonObject.getBoolean("author_order_three"),
                    jsonObject.getBoolean("author_order_four"),
                    jsonObject.getBoolean("author_order_five"),
                    jsonObject.getBoolean("author_order_six"),
                    jsonObject.getBoolean("communication_author_count_one"),
                    jsonObject.getBoolean("communication_author_count_two"),
                    jsonObject.getBoolean("additional_weight_one"),
                    jsonObject.getBoolean("additional_weight_two"),
                    jsonObject.getBoolean("additional_weight_three"),
                    jsonObject.getBoolean("additional_weight_four"),
                    jsonObject.getBoolean("additional_weight_five"),
                    jsonObject.getBoolean("additional_weight_six"),
                    jsonObject.getBoolean("additional_weight_seven"),
                    jsonObject.getString("total")));
        }


        lectureProfessorExcellenceFormBDAO.save(list, userNumber, projectID);
    }

    public JSONArray show(String projectID) {
        List<LectureProfessorExcellenceFormB> lectureProfessorExcellenceFormB = lectureProfessorExcellenceFormBDAO.show(projectID);
        if(lectureProfessorExcellenceFormB == null) {
            lectureProfessorExcellenceFormB = new ArrayList<>();
        }
        JSONArray object = new JSONArray();

        try {
            object.add(toJsonArray(lectureProfessorExcellenceFormB));
        }catch(IllegalAccessException e){

        }
        return object;
    }

    private JSONArray toJsonArray(List<LectureProfessorExcellenceFormB> list) throws IllegalAccessException {
        JSONArray array = new JSONArray();

        for(LectureProfessorExcellenceFormB lectureProfessorExcellenceFormB : list){
            JSONObject object = new JSONObject();
            addBeanPropertyToJson(object,lectureProfessorExcellenceFormB);
            array.add(object);
        }

        return array;
    }
}
