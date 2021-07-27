package Dao.SpecialOutstandingResearcherApplication;

import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherReview;
import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherForm;

public interface SpecialOutstandingResearcherApplicaiotnDAO {
    void update(SpecialOutstandingResearcherForm specialOutstandingResearcherForm) ;
    SpecialOutstandingResearcherForm query( int project_id ) ;

    void update_review(SpecialOutstandingResearcherReview specialOutstandingResearcherReview);

    SpecialOutstandingResearcherReview query_review(int project_id);
}
