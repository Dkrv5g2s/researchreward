package Service.SpecialOutstandingResearcher;

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


}
