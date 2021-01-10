package Dao.SpecialOutstandingResearcherApplication;

import Bean.ExcellentResearcher.Education;
import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherForm;

public interface SpecialOutstandingResearcherApplicaiotnDAO {
    void update(SpecialOutstandingResearcherForm specialOutstandingResearcherForm) ;
    void query( int project_id ) ;

}
