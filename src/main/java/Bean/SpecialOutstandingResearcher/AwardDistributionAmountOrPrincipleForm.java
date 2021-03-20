package Bean.SpecialOutstandingResearcher;

import java.util.List;

public class AwardDistributionAmountOrPrincipleForm {

    private int project_id;

    List<AwardDistributionAmountOrPrinciple> award_distribution_amount_or_principle_list;


    public AwardDistributionAmountOrPrincipleForm() {
    }

    public AwardDistributionAmountOrPrincipleForm(int project_id) {
        this.project_id = project_id ;
    }


    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public List<AwardDistributionAmountOrPrinciple> getAward_distribution_amount_or_principle_list() {
        return award_distribution_amount_or_principle_list;
    }

    public void setAward_distribution_amount_or_principle_list(List<AwardDistributionAmountOrPrinciple> award_distribution_amount_or_principle_list) {
        this.award_distribution_amount_or_principle_list = award_distribution_amount_or_principle_list;
    }
}
