package Service.Admin;

import Bean.Project.RewardProject;
import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.util.List;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class RewardPendingListService {

    private ProjectDAO projectDAO = new ProjectDAOImpl();

    public JSONArray getPendingList(String userRole){
        int statusId = getPendingListStatusId(userRole);
        JSONArray array = new JSONArray();
        if (statusId != -1) {
            List<RewardProject> list = projectDAO.getPendingProjects(statusId, "applied");
            transformListToJSONArray(array, list, userRole);
        }
        return array;
    }

    public JSONArray getReturnedPendingList(String userRole){
        int statusId = getPendingListStatusId(userRole);
        JSONArray array = new JSONArray();
        if (statusId != -1) {
            List<RewardProject> list = projectDAO.getPendingProjects(statusId, "returned");
            transformListToJSONArray(array, list, userRole);
        }
        return array;
    }

    public JSONArray getApprovedRewardList(String userRole){
        int statusId = getPendingListStatusId(userRole);
        JSONArray array = new JSONArray();
        if (statusId != -1) {
            List<RewardProject> list = projectDAO.getReviewedProjects(statusId);
            transformListToJSONArray(array, list, userRole);
        }
        return array;
    }

    public Boolean havePendingReward(String userRole){
        int statusId = getPendingListStatusId(userRole);
        if (statusId != -1) {
            List<RewardProject> list = projectDAO.getPendingProjects(statusId, "applied");
            if (list.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public Boolean haveReturnedPendingReward(String userRole){
        int statusId = getPendingListStatusId(userRole);
        if (statusId != -1) {
            List<RewardProject> list = projectDAO.getPendingProjects(statusId, "returned");
            if (list.isEmpty()){
                return false;
            }
        }
        return true;
    }

    private void transformListToJSONArray(JSONArray array, List<RewardProject> list, String userRole){

        for (RewardProject element : list) {
            try {
                JSONObject object = new JSONObject();
                addBeanPropertyToJson(object, element);
                addReviewerAndReviewTimeToJSONObject(object, userRole);
                array.add(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void addReviewerAndReviewTimeToJSONObject(JSONObject object, String userRole){
        switch (userRole) {
            case "department":
                object.put("reviewer", object.getString("department_reviewer"));
                object.put("review_time", object.getString("department_review_time"));
                break;
            case "college":
                object.put("reviewer", object.getString("college_reviewer"));
                object.put("review_time", object.getString("college_review_time"));
                break;
            case "industryLiaisonOffice":
                object.put("reviewer", object.getString("industry_liaison_office_reviewer"));
                object.put("review_time", object.getString("industry_liaison_office_review_time"));
                break;
            case "researchAndDevelopmentOffice":
                object.put("reviewer", object.getString("research_and_development_office_reviewer"));
                object.put("review_time", object.getString("research_and_development_office_review_time"));
                break;
            default:
                object.put("reviewer", "null");
                object.put("review_time", "null");
                break;
        }

    }

    private int getPendingListStatusId(String userRole){
        switch (userRole) {
            case "department":
                return 2;
            case "college":
                return 3;
            case "industryLiaisonOffice":
                return 4;
            case "researchAndDevelopmentOffice":
                return 5;
        }
        return -1;
    }
}
