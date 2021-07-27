package Service.SpecialOutstandingResearcher;

import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherReview;
import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherForm;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAO;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAOImpl;
import Utils.json_transformer_util;
import fr.opensagres.xdocreport.document.json.JSONObject;

public class SpecialOutstandingResearcherApplicationService {
    public void save(JSONObject json, String staff_code) {

        SpecialOutstandingResearcherForm specialOutstandingResearcherForm = new json_transformer_util().json_to_special_researcher_application_form(json) ;

        SpecialOutstandingResearcherApplicaiotnDAO dao = new SpecialOutstandingResearcherApplicaiotnDAOImpl() ;

        dao.update( specialOutstandingResearcherForm ) ;

    }

    public String query(int project_id) {

        SpecialOutstandingResearcherApplicaiotnDAO dao = new SpecialOutstandingResearcherApplicaiotnDAOImpl() ;

        SpecialOutstandingResearcherForm specialOutstandingResearcherForm = dao.query(project_id);

        String json_form = new json_transformer_util().special_researcher_application_form_to_json( specialOutstandingResearcherForm ) ;

        return json_form ;
    }


    public void save_review(JSONObject json_review, String staff_code) {

        SpecialOutstandingResearcherReview specialOutstandingResearcherReview = new json_transformer_util().json_to_special_researcher_review(json_review) ;

        SpecialOutstandingResearcherApplicaiotnDAO dao = new SpecialOutstandingResearcherApplicaiotnDAOImpl() ;

        dao.update_review(specialOutstandingResearcherReview) ;
    }

    public String query_review(int project_id) {
        SpecialOutstandingResearcherApplicaiotnDAO dao = new SpecialOutstandingResearcherApplicaiotnDAOImpl() ;
        SpecialOutstandingResearcherReview specialOutstandingResearcherReview = dao.query_review( project_id ) ;

        String json_review = new json_transformer_util().special_researcher_reviwe_to_json( specialOutstandingResearcherReview ) ;

        return json_review ;
    }
}
