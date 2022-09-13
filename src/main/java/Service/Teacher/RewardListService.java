package Service.Teacher;

import Bean.JournalPaper.JournalPaper;
import Bean.Project.RewardProject;
import Dao.JournalPaper.JournalPaperDAO;
import Dao.JournalPaper.JournalPaperDAOImpl;
import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.sql.Date;
import java.util.List;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class RewardListService {

    private ProjectDAO projectDAO = new ProjectDAOImpl();

    public JSONArray getDraftList(String staffCode){
        return getRewardList(staffCode, 1);
    }

    public JSONArray getReturnedList(String staffCode){
        return getRewardList(staffCode, 0);
    }

    private JSONArray getRewardList(String staffCode, int statusId){
        List<RewardProject> list = projectDAO.getPersonalProjects(staffCode, statusId, statusId);
        JSONArray array = new JSONArray();

        transformListToJSONArray(array,list);

        return array;
    }

    public void createReward(String staffCode, String rewardName){
//        projectDAO.insertNewProject(staffCode, 1, rewardName);

        // Dfone , added for auto fill in.==============================================================================
        int project_id = projectDAO.insertNewProjectAndReturnProjectID(staffCode, 1, rewardName);
        if (project_id<=0) {
            System.out.println("回傳 project id 錯誤");
        } else {
            JournalPaperDAO journalDAO = new JournalPaperDAOImpl();
            List<JournalPaper> journals = journalDAO.query_journal_papers_of_reward_limited_period(staffCode, rewardName);
            PaperPerformanceDescriptionDAO paperPerformanceDescriptionDAO = new PaperPerformanceDescriptionDAOImpl();
            paperPerformanceDescriptionDAO.insert_journal_papers(project_id, journals);
        }
        // =============================================================================================================
    }

    public JSONArray traceProgress(String staffCode){
        JSONArray array = new JSONArray();
        List<RewardProject> result = projectDAO.getPersonalProjects(staffCode, 2, projectDAO.getMaxStatusId());

        transformListToJSONArray(array,result);

        return array;
    }

    public void updateRewardStatusToNext(int projectId){
        int status_id = projectDAO.getStatusIdByProjectId(projectId);
        int max_id = projectDAO.getMaxStatusId();
        if (status_id == 0 ){
            projectDAO.initializeProjectReviewState(projectId);
            projectDAO.applyProject(projectId, new Date(System.currentTimeMillis()));
        }
        else if( status_id == 1){
            projectDAO.applyProject(projectId, new Date(System.currentTimeMillis()));
            updateHistoryHighestStatusId(projectId, ++status_id);
        }
        else if (status_id < max_id){
            projectDAO.updateProjectStatus(projectId, ++status_id);
            updateHistoryHighestStatusId(projectId, status_id);
        }
        projectDAO.updateProjectLastStatusIdChangedDirection(projectId, "applied");
    }

    private void updateHistoryHighestStatusId(int projectId, int status_id) {
        int historyHighestStatusId = projectDAO.getHistoryHighestStatusIdByProjectId(projectId);
        if (status_id > historyHighestStatusId)
            projectDAO.updateProjectHistoryHighestStatus(projectId, status_id);
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

    public String getRewardType(int project_id) {
        return projectDAO.getRewardType(project_id);
    }

    public String getCatalogURL(String rewardName) {
        System.out.println("rewardName:"+rewardName);
        // 這邊的命名之後要調整 重複性有點太高了
        switch (rewardName){
        	case "特聘教授":
        		return "DistinguishedProfessorCatalog";

            case "獎勵新聘特殊優秀研究人才":
            case "獎勵新聘特殊優秀研究人才(N類-新)": // 2022/09/01 研發處將_獎勵新聘特殊優秀研究人才_改名為此
                return "ExcellentResearcherCatalog";

            case "獎勵特殊優秀研究人才":
            case "獎勵特殊優秀研究人才(A類)": // 2022/09/01 研發處將_獎勵特殊優秀研究人才_改名為此
                return "SpecialOutstandingResearcherCatalog";

            case "陽光獎助金論文獎勵":
                return "SunshineScholarshipCatalog";

            case "奬助研究及產學績優教師聘任研究人員辦法": // old, first word displayed as ?.
            case "獎助研究及產學績優教師聘任研究人員辦法": // Dfone, fix after 2022/07/06 , first word display correctly.
                return "TeacherHireResearcherCatalog";

            case "年輕學者研究獎":
                return "JuniorResearchInvestigatorCatalog";

            case "傑出研究獎":
                return "OutstandingResearchAwardCatalog";

            case "(續撥)獎勵新聘特殊優秀研究人才":
            case "(續撥)獎勵新聘特殊優秀研究人才(N類-續)": // 2022/09/01 研發處將_(續撥)獎勵新聘特殊優秀研究人才_改名為此
                return "SecondExcellentResearcherCatalog";

            case "講座教授":
                return "LectureProfessorCatalog";

            default:
                return "TeacherMenu";
        }
    }

    public void deleteRewardProject(int projectId,String staffCode){
        projectDAO.deleteProject(projectId,staffCode);
    }
}
