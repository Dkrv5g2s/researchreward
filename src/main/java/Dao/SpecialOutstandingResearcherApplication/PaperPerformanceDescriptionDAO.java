package Dao.SpecialOutstandingResearcherApplication;

import Bean.SpecialOutstandingResearcher.PaperPerformance;
import Bean.SpecialOutstandingResearcher.PaperPerformanceDescriptionForm;

import java.util.List;
import java.util.Map;

public interface PaperPerformanceDescriptionDAO {
    PaperPerformanceDescriptionForm query_specified_paper_performance_descripstion_form(int project_id ) ;

    public void update( PaperPerformanceDescriptionForm paperPerformanceDescriptionForm ) ;

    public PaperPerformance query_specified_paper_performance(int paper_id ) ;

    void update_specified_paper_performance(PaperPerformance paperPerformance);

    public List<String> query_total_paper_sentence();

    public List<String> query_total_paper_sentence_in_specified_reward(String reward_type);

//    public Map<String,String> query_total_paper_info_as_dict();

    public boolean query_whether_specified_paper_sentence_existed_already(PaperPerformance paperPerformance);

    public String queryUserNameByPaperTitle(String PaperTitle);
}
