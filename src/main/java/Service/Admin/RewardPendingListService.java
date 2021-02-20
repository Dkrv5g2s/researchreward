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
        List<RewardProject> list = projectDAO.getProjectsForAdmins(statusId, statusId);
        JSONArray array = new JSONArray();

        transformListToJSONArray(array, list, userRole);

        return array;
    }

    public JSONArray getApprovedRewardList(String userRole){
        int beginStatusId = getPendingListStatusId(userRole)+1;
        int endStatusId = projectDAO.getMaxStatusId();
        List<RewardProject> list = projectDAO.getProjectsForAdmins(beginStatusId, endStatusId);
        JSONArray array = new JSONArray();

        transformListToJSONArray(array, list, userRole);

        return array;
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
        return 1;
    }

    public String getCatalogURL(String rewardName) {
        // 這邊的命名之後要調整 重複性有點太高了
        switch (rewardName){
        	case "特聘教授":
        		return "/DistinguishedProfessorCatalog";
            case "獎勵新聘特殊優秀研究人才":
                return "/ExcellentResearcherCatalog";
            case "優秀人才申請":
                return "/SpecialOutstandingResearcherCatalog";
            case "陽光獎助金論文獎勵":
                return "/SunshineScholarshipCatalog";
            case "績優教師聘任研究人員":
                return "/TeacherHireResearcherCatalog";
            case "年輕學者獎":
                return "/JuniorResearchInvestigatorCatalog";
            case "傑出研究獎":
                return "/OutstandingResearchAwardCatalog";
            case "(續撥)獎勵新聘特殊優秀研究人才":
                return "/SecondExcellentResearcherCatalog";
            default:
                return "/Menu";
        }
    }
}
