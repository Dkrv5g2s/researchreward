package Dao.SpecialOutstandingResearcherApplication;

import Bean.SpecialOutstandingResearcher.PaperPerformance;
import Bean.SpecialOutstandingResearcher.PaperPerformanceDescriptionForm;

import java.util.List;

public interface PaperPerformanceDescriptionDAO {
    PaperPerformanceDescriptionForm query_specified_paper_performance_descripstion_form(int project_id ) ;

    public void update( PaperPerformanceDescriptionForm paperPerformanceDescriptionForm ) ;

    public PaperPerformance query_specified_paper_performance(int paper_id ) ;

    void update_specified_paper_performance(PaperPerformance paperPerformance);

    public List<String> query_total_paper_title();
}
