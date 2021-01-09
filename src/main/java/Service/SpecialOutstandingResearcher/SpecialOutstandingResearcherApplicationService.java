package Service.SpecialOutstandingResearcher;

import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherForm;
import fr.opensagres.xdocreport.document.json.JSONObject;

public class SpecialOutstandingResearcherApplicationService {
    public void save(JSONObject json, String staff_code) {
        SpecialOutstandingResearcherForm specialOutstandingResearcherForm = json_to_special_researcher_application_form(json) ;
        SpecialOutstandingResearcherFormDao dao = new SpecialOutstandingResearcherFormDaoImpl() ;
        dao.update( specialOutstandingResearcherForm, staff_code ) ;
    }

    private SpecialOutstandingResearcherForm json_to_special_researcher_application_form(JSONObject json ) {
        SpecialOutstandingResearcherForm specialOutstandingResearcherForm = new SpecialOutstandingResearcherForm() ;
        specialOutstandingResearcherForm.setApplicant_name(json.getString("applicant_name")) ;
        specialOutstandingResearcherForm.setCollege(json.getString("college"));
        specialOutstandingResearcherForm.setDepartment(json.getString("department"));
        specialOutstandingResearcherForm.setJob("job");
        specialOutstandingResearcherForm.setExecuted_tech_proj(json.getBoolean("executed_tech_proj"));
        specialOutstandingResearcherForm.setProject_id();


        return specialOutstandingResearcherForm
    }
}
