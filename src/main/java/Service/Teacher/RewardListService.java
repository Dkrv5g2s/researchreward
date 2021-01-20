package Service.Teacher;

import Bean.Project.RewardProject;
import Constants.ProgressConstant;
import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class RewardListService {

    private ProjectDAO projectDAO = new ProjectDAOImpl();

    public JSONArray getDraftList(String staffCode){
        List<RewardProject> list = projectDAO.getProjects(staffCode, ProgressConstant.DRAFT);
        JSONArray array = new JSONArray();

        transformListToJSONArray(array,list);

        return array;
    }

    public JSONArray traceProgress(String staffCode){
        List<String> constantsList = new ArrayList<>();

        constantsList.add(ProgressConstant.SUBMIT_DEPARTMENT_FOR_REVIEW);
        constantsList.add(ProgressConstant.SUBMIT_COLLEGE_FOR_REVIEW);
        constantsList.add(ProgressConstant.SUBMIT_SCHOOL_FOR_REVIEW);
        constantsList.add(ProgressConstant.REVIEW_FINISHED);
        constantsList.add(ProgressConstant.RESULT_WAITING);

        JSONArray array = new JSONArray();
        for (String status : constantsList) {
            List<RewardProject> result = projectDAO.getProjects(staffCode, status);

            transformListToJSONArray(array,result);
        }

        return array;
    }

    private void transformListToJSONArray(JSONArray array, List<RewardProject> list){

        for (RewardProject element : list) {
            try {
                JSONObject object = new JSONObject();
                addBeanPropertyToJson(object, element);
                array.add(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
