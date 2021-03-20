package Service.SpecialOutstandingResearcher;

import Bean.SpecialOutstandingResearcher.AwardDistributionAmountOrPrincipleForm;
import Bean.SpecialOutstandingResearcher.ReviewSupportingInformationForm;
import Dao.SpecialOutstandingResearcherApplication.AwardDistributionAmountOrPrincipleDAO;
import Dao.SpecialOutstandingResearcherApplication.AwardDistributionAmountOrPrincipleImpl;
import Dao.SpecialOutstandingResearcherApplication.ReviewSupportingInformationDAO;
import Dao.SpecialOutstandingResearcherApplication.ReviewSupportingInformationDAOImpl;
import Utils.json_transformer_util;
import fr.opensagres.xdocreport.document.json.JSONObject;

public class AwardDistributionAmountOrPrincipleService {


    public void save(JSONObject json) {

        AwardDistributionAmountOrPrincipleForm awardDistributionAmountOrPrincipleForm = new json_transformer_util().json_to_award_distribution_amount_or_principle_form(json) ;

        AwardDistributionAmountOrPrincipleDAO dao = new AwardDistributionAmountOrPrincipleImpl() ;

        dao.update( awardDistributionAmountOrPrincipleForm ) ;

    }

    public String query(int project_id) {

        AwardDistributionAmountOrPrincipleDAO dao = new AwardDistributionAmountOrPrincipleImpl() ;

        AwardDistributionAmountOrPrincipleForm awardDistributionAmountOrPrincipleForm = dao.query(project_id);

        String json_form = new json_transformer_util().award_distribution_amount_or_principle_form_to_json(awardDistributionAmountOrPrincipleForm) ;

        return json_form ;
    }


}
