package Utils;

import Bean.Common.OtherFileUploadForm;
import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorUploadForm;
import Bean.SpecialOutstandingResearcher.*;
import com.google.gson.*;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

public class json_transformer_util {

    public String paper_performance_description_form_to_json( PaperPerformanceDescriptionForm paperPerformanceDescriptionForm ) {
        return new Gson().toJson( paperPerformanceDescriptionForm ) ;
    }

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

        Gson gson = new Gson() ;
        JSONObject jsonObject = new JSONObject( gson.toJson(specialOutstandingResearcherForm) ) ;
        try {
            jsonObject.put("tech_proj_start_time", new java.sql.Date(specialOutstandingResearcherForm.getTech_proj_start_time().getTime()).toString()) ;
        }
        catch (Exception e ) {
            jsonObject.put("tech_proj_start_time", "") ;
        }
        try {
            jsonObject.put("tech_proj_end_time", new java.sql.Date(specialOutstandingResearcherForm.getTech_proj_end_time().getTime()).toString()) ;
        }
        catch (Exception e ) {
            jsonObject.put("tech_proj_end_time", "") ;
        }
        return jsonObject.toString() ;
    }

    public PaperPerformanceDescriptionForm json_to_paper_performance_description_form( JSONObject json ) {
        return  new Gson().fromJson( json.toString() , PaperPerformanceDescriptionForm.class ) ;
    }

    public String review_Supporting_InformationForm_form_to_json( ReviewSupportingInformationForm reviewSupportingInformationForm ) {
        Gson gson = new Gson() ;
        JSONObject jsonObject = new JSONObject( gson.toJson(reviewSupportingInformationForm) ) ;
        JSONArray jsonArray = jsonObject.getJSONArray( "review_supporting_information_list" ) ;
        List<ReviewSupportingInformation> reviewSupportingInformationList = reviewSupportingInformationForm.getReview_supporting_information_list() ;

        for ( int i = 0 ; i < jsonArray.length(); i++ ) {

            try {
                jsonArray.getJSONObject(i).put("contract_date", new java.sql.Date(reviewSupportingInformationList.get(i).getContract_date().getTime()).toString()) ;
            }
            catch (Exception e ) {
                jsonArray.getJSONObject(i).put("contract_date", "") ;
            }
            try {
                jsonArray.getJSONObject(i).put("technical_transfer_funds_include_date", new java.sql.Date(reviewSupportingInformationList.get(i).getTechnical_transfer_funds_include_date().getTime()).toString()) ;
            }
            catch (Exception e ) {
                jsonArray.getJSONObject(i).put("technical_transfer_funds_include_date", "") ;
            }

        }

        return jsonObject.toString() ;
    }

    public ReviewSupportingInformationForm json_to_review_supporting_information_form(JSONObject json) {
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
            return gson.fromJson(json.toString(), ReviewSupportingInformationForm.class);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null ;
    }

    public String award_distribution_amount_or_principle_form_to_json(AwardDistributionAmountOrPrincipleForm awardDistributionAmountOrPrincipleForm) {

        return new Gson().toJson(awardDistributionAmountOrPrincipleForm);

    }

    public AwardDistributionAmountOrPrincipleForm json_to_award_distribution_amount_or_principle_form(JSONObject json) {

        return new Gson().fromJson(json.toString(), AwardDistributionAmountOrPrincipleForm.class);

    }

    public String lecture_professor_upload_form_to_json(LectureProfessorUploadForm lectureProfessorUploadForm) {

        return new Gson().toJson(lectureProfessorUploadForm);

    }

    public LectureProfessorUploadForm json_to_lecture_professor_upload_form(JSONObject json) {

        return new Gson().fromJson(json.toString(), LectureProfessorUploadForm.class);

    }

    public String other_file_upload_form_to_json(OtherFileUploadForm otherFileUploadForm) {
        return new Gson().toJson(otherFileUploadForm);
    }

    public OtherFileUploadForm json_to_other_file_upload_form(JSONObject json) {
        return new Gson().fromJson(json.toString(), OtherFileUploadForm.class);
    }

    public SpecialOutstandingResearcherReview json_to_special_researcher_review(JSONObject json_review) {
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
            return gson.fromJson(json_review.toString(), SpecialOutstandingResearcherReview.class);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return  null ;
    }

    public String special_researcher_reviwe_to_json(SpecialOutstandingResearcherReview specialOutstandingResearcherReview) {

        Gson gson = new Gson() ;
        JSONObject jsonObject = new JSONObject( gson.toJson(specialOutstandingResearcherReview) ) ;
        jsonObject.put("college_recommended_order", specialOutstandingResearcherReview.getCollege_recommended_order()) ;
        try {
            jsonObject.put("college_review_date", new java.sql.Date(specialOutstandingResearcherReview.getCollege_review_date().getTime()).toString()) ;
        }
        catch (Exception e ) {
            jsonObject.put("college_review_date", "") ;
        }
        try {
            jsonObject.put("research_office_review_date", new java.sql.Date(specialOutstandingResearcherReview.getResearch_office_review_date().getTime()).toString()) ;
        }
        catch (Exception e ) {
            jsonObject.put("research_office_review_date", "") ;
        }
        return jsonObject.toString() ;

    }
}
