package Service.SpecialOutstandingResearcher;

import Bean.SpecialOutstandingResearcher.PaperPerformanceDescriptionForm;
import Bean.SpecialOutstandingResearcher.ReviewSupportingInformationForm;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;
import Dao.SpecialOutstandingResearcherApplication.ReviewSupportingInformationDAO;
import Dao.SpecialOutstandingResearcherApplication.ReviewSupportingInformationDAOImpl;
import Utils.json_transformer_util;
import fr.opensagres.xdocreport.document.json.JSONObject;

public class ReviewSupportingInformationService {
    public void save(JSONObject json) {

        ReviewSupportingInformationForm reviewSupportingInformationForm = new json_transformer_util().json_to_review_supporting_information_form(json) ;

        ReviewSupportingInformationDAO dao = new ReviewSupportingInformationDAOImpl() ;

        dao.update( reviewSupportingInformationForm ) ;

    }

    public String query(int project_id) {

        ReviewSupportingInformationDAO dao = new ReviewSupportingInformationDAOImpl() ;

        ReviewSupportingInformationForm reviewSupportingInformationForm = dao.query(project_id);

        String json_form = new json_transformer_util().review_Supporting_InformationForm_form_to_json( reviewSupportingInformationForm ) ;

        return json_form ;
    }
}
