package Dao.SpecialOutstandingResearcherApplication;

import Bean.SpecialOutstandingResearcher.ReviewSupportingInformationForm;

public interface ReviewSupportingInformationDAO {
    public ReviewSupportingInformationForm query( int project_id );
    public void update(ReviewSupportingInformationForm reviewSupportingInformationForm ) ;
}
