package Service.SpecialOutstandingResearcher;

import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherForm;
import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherStandard;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAO;
import Dao.SpecialOutstandingResearcherApplication.SpecialOutstandingResearcherApplicaiotnDAOImpl;
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
        SpecialOutstandingResearcherForm specialOutstandingResearcherForm = json_to_special_researcher_application_form(json) ;

        SpecialOutstandingResearcherApplicaiotnDAO dao = new SpecialOutstandingResearcherApplicaiotnDAOImpl() ;
        dao.update( specialOutstandingResearcherForm ) ;
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
            try {
                specialOutstandingResearcherForm.setTech_proj_start_time(new java.sql.Date(json.getDate("tech_proj_start_time").getTime()));
            }catch(Exception e) {
                specialOutstandingResearcherForm.setTech_proj_start_time(null) ;
            }

            try{
                specialOutstandingResearcherForm.setTech_proj_end_time(new java.sql.Date(json.getDate("tech_proj_end_time").getTime()));
            }catch (Exception e) {
                specialOutstandingResearcherForm.setTech_proj_end_time(null);
            }

            Type listType = new TypeToken<ArrayList<SpecialOutstandingResearcherStandard>>(){}.getType();

            ArrayList<SpecialOutstandingResearcherStandard> specialOutstandingResearcherStandardList = new Gson().fromJson(json.getJSONArray("standard_list").toString() , listType);
            specialOutstandingResearcherForm.setStandard_list(specialOutstandingResearcherStandardList);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return specialOutstandingResearcherForm ;
    }
}
