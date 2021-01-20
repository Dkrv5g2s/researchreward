package Service.Teacher;

import Bean.Project.RewardProject;
import Constants.ProgressConstant;
import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.util.List;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class RewardListService {

    private ProjectDAO projectDAO = new ProjectDAOImpl();

    public JSONArray getDraftList(String staffCode){
        List<RewardProject> list = projectDAO.getProjects(staffCode, ProgressConstant.DRAFT);
        JSONArray array = new JSONArray();

        for (RewardProject element: list){
            try {
                JSONObject object = new JSONObject();
                addBeanPropertyToJson(object,element);
                array.add(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return array;
    }
}
