package Dao.SpecialOutstandingResearcherApplication;

import Bean.SpecialOutstandingResearcher.PaperPerformanceDescriptionForm;

public interface PaperPerformanceDescriptionDAO {
    PaperPerformanceDescriptionForm query(int project_id ) ;

    public void update( PaperPerformanceDescriptionForm paperPerformanceDescriptionForm ) ;
}
