package Dao.SpecialOutstandingResearcherApplication;

import Bean.SpecialOutstandingResearcher.AwardDistributionAmountOrPrincipleForm;
import Bean.SpecialOutstandingResearcher.ReviewSupportingInformationForm;

public interface AwardDistributionAmountOrPrincipleDAO {
    public AwardDistributionAmountOrPrincipleForm query(int project_id );
    public void update(AwardDistributionAmountOrPrincipleForm awardDistributionAmountOrPrincipleForm ) ;

}
