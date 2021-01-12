package Dao.SpecialOutstandingResearcherApplication;

import Bean.ExcellentResearcher.Education;
import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherForm;

public interface SpecialOutstandingResearcherApplicaiotnDAO {
    void update(SpecialOutstandingResearcherForm specialOutstandingResearcherForm) ;
    SpecialOutstandingResearcherForm query( int project_id ) ;

}
