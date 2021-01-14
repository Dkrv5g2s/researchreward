package Service.SpecialOutstandingResearcher;

import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherForm;
import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherStandard;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAO;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAOImpl;
import Utils.SpecialOutstandingResearcherApplicationUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;


import java.lang.reflect.Type;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SpecialOutstandingResearcherApplicationService {
    public void save(JSONObject json, String staff_code) {

        SpecialOutstandingResearcherForm specialOutstandingResearcherForm = new SpecialOutstandingResearcherApplicationUtil().json_to_special_researcher_application_form(json) ;

        SpecialOutstandingResearcherApplicaiotnDAO dao = new SpecialOutstandingResearcherApplicaiotnDAOImpl() ;

        dao.update( specialOutstandingResearcherForm ) ;

    }

    public String query(int project_id) {

        SpecialOutstandingResearcherApplicaiotnDAO dao = new SpecialOutstandingResearcherApplicaiotnDAOImpl() ;

        SpecialOutstandingResearcherForm specialOutstandingResearcherForm = dao.query(project_id);

        String json_form = new SpecialOutstandingResearcherApplicationUtil().special_researcher_application_form_to_json( specialOutstandingResearcherForm ) ;

        return json_form ;
    }


}
