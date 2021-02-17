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

    public void createReward(String staffCode, String rewardName){
        projectDAO.insertNewProject(staffCode,ProgressConstant.DRAFT,rewardName);
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

    public String getCatalogURL(String rewardName) {
        System.out.println("rewardName:"+rewardName);
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
            case "講座教授/榮譽講座教授":
                return "/LectureProfessorCatalog";
            default:
                return "/Menu";
        }
    }
}
