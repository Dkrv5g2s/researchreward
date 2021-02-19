package Service.SpecialOutstandingResearcher;

import Bean.SpecialOutstandingResearcher.PaperPerformance;
import Bean.SpecialOutstandingResearcher.PaperPerformanceDescriptionForm;
import Bean.Project.RewardProject;
import Dao.Project.ProjectDAO;
import Dao.Project.ProjectDAOImpl;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;
import Utils.json_transformer_util;
import Utils.verifyDuplicatePaper.VerifyUtils;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.util.List;
import java.util.ListIterator;

public class PaperPerformanceDescriptionService {
    private VerifyUtils Util;
    public void save(JSONObject json) {

        PaperPerformanceDescriptionForm specialOutstandingResearcherForm = new json_transformer_util().json_to_paper_performance_description_form(json) ;
        PaperPerformanceDescriptionDAO dao = new PaperPerformanceDescriptionDAOImpl() ;
        dao.update( specialOutstandingResearcherForm ) ;

    }

    public String query(int project_id) {

        PaperPerformanceDescriptionDAO dao = new PaperPerformanceDescriptionDAOImpl() ;

        PaperPerformanceDescriptionForm paperPerformanceDescriptionForm = dao.query_specified_paper_performance_descripstion_form(project_id);

        String json_form = new json_transformer_util().paper_performance_description_form_to_json( paperPerformanceDescriptionForm ) ;

        return json_form ;
    }

    public String queryRewardType(int project_id) {
        ProjectDAO dao = new ProjectDAOImpl() ;
        String reward_type = dao.getRewardType(project_id);
        return reward_type;
    }

    public String verifyPaperTitle(JSONObject json){
        System.out.println("verifyPaperTitle start");
        //檢查Bean(前端傳來)的資料
        //先檢查paper_id+bookname有沒有存在，
        //  有的話代表已存在，則進行更新
        //  否的話則再檢查此bookname有沒有重複>>有的話則重複 此筆false 返回
        //                                    否的話則true 繼續後續update流程
        String result = "undetected";
        PaperPerformanceDescriptionDAO dao = new PaperPerformanceDescriptionDAOImpl() ;
        PaperPerformanceDescriptionForm specialOutstandingResearcherForm = new json_transformer_util().json_to_paper_performance_description_form(json) ;

        List<PaperPerformance> paperPerformanceList = specialOutstandingResearcherForm.getPaper_performance_list() ;
        ListIterator<PaperPerformance> it = paperPerformanceList.listIterator();

        while (it.hasNext()) {
            PaperPerformance item = it.next();
            if (((PaperPerformanceDescriptionDAOImpl) dao).query_specified_paper_existed(item) == false) {
                String paperTitle = item.getBook_name();
                if(Util.isInputaDuplicatePaperTitle(paperTitle)==true)// 代表此筆為新增資料 而且bookname重複
                {
                    result = "the paper is Duplicate!";
                    break;
                }
                else
                    result = "pass";
            }
        }
        return  result;

    }
}

