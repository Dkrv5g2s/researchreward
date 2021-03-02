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
import org.apache.log4j.Logger;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class PaperPerformanceDescriptionService {
    private Logger logger = Logger.getLogger(this.getClass());

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

        // only check the paperdata which is new application
        // if the paperTitle(book_name in db) has existed in db,it means the title is reapplied,return the title.
        VerifyUtils verifyUtils = new VerifyUtils();
        String result = "";

        PaperPerformanceDescriptionDAO dao = new PaperPerformanceDescriptionDAOImpl() ;
        PaperPerformanceDescriptionForm specialOutstandingResearcherForm = new json_transformer_util().json_to_paper_performance_description_form(json) ;

        List<PaperPerformance> paperPerformanceList = specialOutstandingResearcherForm.getPaper_performance_list() ;
        ListIterator<PaperPerformance> it = paperPerformanceList.listIterator();

        List<String> totalPaperSentenceList = dao.query_total_paper_sentence();

        while (it.hasNext()) {
            PaperPerformance item = it.next();
            boolean queryResult = dao.query_whether_specified_paper_sentence_existed_already(item);//smell

            if (queryResult == false) {
                // means the paper is not existed in list->check the book_name
                String inputPaperToken = item.getBook_name() + item.getScholarly_journals_name();
                boolean isPaperReapplied = verifyUtils.isPaperReapplied(inputPaperToken,totalPaperSentenceList);
                if(isPaperReapplied)
                {
                    result =  item.getBook_name();
                    break;
                }
            }
        }

        this.logger.debug("result :"+ result);
        return  result;

    }

    public String getAppliedApplicantUserName(String  duplicatePaperTitle){
        PaperPerformanceDescriptionDAO dao = new PaperPerformanceDescriptionDAOImpl() ;
        return dao.queryUserNameByPaperTitle(duplicatePaperTitle);
    }
}

