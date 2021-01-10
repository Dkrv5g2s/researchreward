package Service.SpecialOutstandingResearcher;

import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherForm;
import fr.opensagres.xdocreport.document.json.JSONObject;


import java.sql.Date;

public class SpecialOutstandingResearcherApplicationService {
    public void save(JSONObject json, String staff_code) {
        SpecialOutstandingResearcherForm specialOutstandingResearcherForm = json_to_special_researcher_application_form(json) ;
        System.out.println(specialOutstandingResearcherForm.getApplicant_name());
//        SpecialOutstandingResearcherFormDao dao = new SpecialOutstandingResearcherFormDaoImpl() ;
//        dao.update( specialOutstandingResearcherForm, staff_code ) ;
    }

    private SpecialOutstandingResearcherForm json_to_special_researcher_application_form(JSONObject json ) {
        SpecialOutstandingResearcherForm specialOutstandingResearcherForm = new SpecialOutstandingResearcherForm() ;
        try {
            specialOutstandingResearcherForm.setApplicant_name(json.getString("applicant_name"));
            specialOutstandingResearcherForm.setCollege(json.getString("college"));
            specialOutstandingResearcherForm.setDepartment(json.getString("department"));

            specialOutstandingResearcherForm.setSeniority(json.getString("seniority"));
            specialOutstandingResearcherForm.setJob(json.getString("job"));
            specialOutstandingResearcherForm.setExecuted_tech_proj(json.getBoolean("executed_tech_proj"));
            specialOutstandingResearcherForm.setProject_id(json.getInt("project_id"));
            specialOutstandingResearcherForm.setTech_proj_id(json.getString("tech_proj_id"));
            specialOutstandingResearcherForm.setTech_proj_start_time(new java.sql.Date(json.getDate("tech_proj_start_time").getTime()));
            specialOutstandingResearcherForm.setTech_proj_end_time(new java.sql.Date(json.getDate("tech_proj_end_time").getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }



        return specialOutstandingResearcherForm ;
    }
}
