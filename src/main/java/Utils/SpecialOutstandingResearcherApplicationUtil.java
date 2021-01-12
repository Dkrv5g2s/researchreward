package Utils;

import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherForm;
import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherStandard;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SpecialOutstandingResearcherApplicationUtil {

//    public SpecialOutstandingResearcherForm json_to_special_researcher_application_form(JSONObject json ) {
//        SpecialOutstandingResearcherForm specialOutstandingResearcherForm = new SpecialOutstandingResearcherForm() ;
//        try {
//            specialOutstandingResearcherForm.setApplicant_name(json.getString("applicant_name"));
//            specialOutstandingResearcherForm.setCollege(json.getString("college"));
//            specialOutstandingResearcherForm.setDepartment(json.getString("department"));
//
//            specialOutstandingResearcherForm.setSeniority(json.getString("seniority"));
//            specialOutstandingResearcherForm.setJob(json.getString("job"));
//
//            specialOutstandingResearcherForm.setExecuted_tech_proj(json.getBoolean("executed_tech_proj"));
//
//            specialOutstandingResearcherForm.setProject_id(json.getInt("project_id"));
//            specialOutstandingResearcherForm.setTech_proj_id(json.getString("tech_proj_id"));
//            try {
//                specialOutstandingResearcherForm.setTech_proj_start_time(new java.sql.Date(json.getDate("tech_proj_start_time").getTime()));
//            }catch(Exception e) {
//                specialOutstandingResearcherForm.setTech_proj_start_time(null) ;
//            }
//
//            try{
//                specialOutstandingResearcherForm.setTech_proj_end_time(new java.sql.Date(json.getDate("tech_proj_end_time").getTime()));
//            }catch (Exception e) {
//                specialOutstandingResearcherForm.setTech_proj_end_time(null);
//            }
//
//            Type listType = new TypeToken<ArrayList<SpecialOutstandingResearcherStandard>>(){}.getType();
//
//            ArrayList<SpecialOutstandingResearcherStandard> specialOutstandingResearcherStandardList = new Gson().fromJson(json.getJSONArray("standard_list").toString() , listType);
//            specialOutstandingResearcherForm.setStandard_list(specialOutstandingResearcherStandardList);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return specialOutstandingResearcherForm ;
//    }

    public SpecialOutstandingResearcherForm json_to_special_researcher_application_form(JSONObject json ) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            @Override
            public Date deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
                    throws JsonParseException {
                try {
                    return df.parse(json.getAsString());
                } catch (ParseException e) {
                    return null;
                }
            }
        });

        try {
            Gson gson = gsonBuilder.create();
            return gson.fromJson(json.toString(), SpecialOutstandingResearcherForm.class);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return  null ;
    }

    public String special_researcher_application_form_to_json(SpecialOutstandingResearcherForm specialOutstandingResearcherForm ) {

        return new Gson().toJson( specialOutstandingResearcherForm ) ;
    }
}
