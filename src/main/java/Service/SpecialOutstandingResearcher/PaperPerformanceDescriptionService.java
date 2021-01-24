package Service.SpecialOutstandingResearcher;

import Bean.SpecialOutstandingResearcher.PaperPerformanceDescriptionForm;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;
import Utils.json_transformer_util;
import fr.opensagres.xdocreport.document.json.JSONObject;

public class PaperPerformanceDescriptionService {
    public void save(JSONObject json) {

        PaperPerformanceDescriptionForm specialOutstandingResearcherForm = new json_transformer_util().json_to_paper_performance_description_form(json) ;


        PaperPerformanceDescriptionDAO dao = new PaperPerformanceDescriptionDAOImpl() ;

        dao.update( specialOutstandingResearcherForm ) ;

    }

    public String query(int project_id) {

        PaperPerformanceDescriptionDAO dao = new PaperPerformanceDescriptionDAOImpl() ;

        PaperPerformanceDescriptionForm paperPerformanceDescriptionForm = dao.query_specified_paper_performance_descripstion_form(project_id);

        String json_form = new json_transformer_util().paper_performance_description_form_to_json( paperPerformanceDescriptionForm ) ;

        return json_form ;
    }
}

