package Service.ExcellentResearcher;


import Bean.ExcellentResearcher.RecruitDescription;
import Bean.ExcellentResearcher.ResearchProduction.Patent;
import Bean.ExcellentResearcher.ResearchProduction.ResearchProduction;
import Bean.ExcellentResearcher.ResearchProduction.Technology;
import Bean.ExcellentResearcher.ResearchProduction.WorkAuthorization;
import Dao.ExcellentResearcher.Impl.ResearchProductionDAOImpl;
import Dao.ExcellentResearcher.ResearchProductionDAO;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class ResearchProductionService {

    private ResearchProductionDAO researchProductionDAO = new ResearchProductionDAOImpl();

    public void save(JSONArray jsonArray, int projectId){
        ResearchProduction researchProduction = new ResearchProduction(projectId);
        researchProduction.setPatentList(jsonArrayToPatents((JSONArray)jsonArray.get(0),projectId));
        researchProduction.setTechnologyList( jsonArrayToTechnologys((JSONArray)jsonArray.get(1),projectId));
        researchProduction.setWorkAuthorizationList( jsonArrayToWorkAuthorizations((JSONArray)jsonArray.get(2),projectId));
        researchProductionDAO.save(researchProduction);
    }

    public JSONArray get(String projectId){

        ResearchProduction researchProduction = researchProductionDAO.get(projectId);

        JSONArray jsonArray = new JSONArray();

        try {
            jsonArray.add(PatentsToJsonArray(researchProduction.getPatentList()));
            jsonArray.add(TechnologysToJsonArray(researchProduction.getTechnologyList()));
            jsonArray.add(WorkAuthorizationsToJsonArray(researchProduction.getWorkAuthorizationList()));
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }

        return jsonArray;


    }

    private JSONArray PatentsToJsonArray(List<Patent> list) throws IllegalAccessException {
        JSONArray array = new JSONArray();

        for(Patent patent : list){
            JSONObject object = new JSONObject();
            addBeanPropertyToJson(object,patent);
            array.add(object);
        }

        return array;
    }
    private JSONArray TechnologysToJsonArray(List<Technology> list) throws IllegalAccessException {
        JSONArray array = new JSONArray();
        for(Technology technology : list){
            JSONObject object = new JSONObject();
            addBeanPropertyToJson(object,technology);
            array.add(object);
        }
        return array;
    }
    private JSONArray WorkAuthorizationsToJsonArray(List<WorkAuthorization> list) throws IllegalAccessException {
        JSONArray array = new JSONArray();
        for(WorkAuthorization workAuthorization : list){
            JSONObject object = new JSONObject();
            addBeanPropertyToJson(object,workAuthorization);
            array.add(object);
        }
        return array;
    }

    private List<Patent> jsonArrayToPatents(JSONArray jsonArray, int projectId){
        List<Patent> patentList = new ArrayList<>();

        for (Object element: jsonArray) {
            JSONObject jsonObject = (JSONObject)element;
            patentList.add(new Patent(jsonObject.getString("patentClass"),
                    jsonObject.getString("patentName"),
                    jsonObject.getString("country"),
                    jsonObject.getString("patentNumber"),
                    jsonObject.getString("inventor"),
                    jsonObject.getString("patentee"),
                    jsonObject.getDate("approvalDate"),
                    jsonObject.getString("mstPlanNumber"),
                    projectId));
        }

        return patentList;
    }
    private List<Technology> jsonArrayToTechnologys(JSONArray jsonArray, int projectId){
        List<Technology> technologyList = new ArrayList<>();

        for (Object element: jsonArray) {
            JSONObject jsonObject = (JSONObject)element;
            technologyList.add(new Technology(jsonObject.getString("authorizedUnit"),
                    jsonObject.getString("patentName"),
                    jsonObject.getDate("contractDate"),
                    jsonObject.getString("technologyName"),
                    jsonObject.getString("toAuthorizedUnit"),
                    jsonObject.getString("mstPlanNumber"),
                    projectId));
        }

        return technologyList;
    }
    private List<WorkAuthorization> jsonArrayToWorkAuthorizations(JSONArray jsonArray, int projectId){
        List<WorkAuthorization> workAuthorizationList = new ArrayList<>();

        for (Object element: jsonArray) {
            JSONObject jsonObject = (JSONObject)element;
            workAuthorizationList.add(new WorkAuthorization(jsonObject.getString("agent"),
                    jsonObject.getString("author"),
                    jsonObject.getString("authorizationClass"),
                    jsonObject.getString("copyrightOwner"),
                    jsonObject.getString("mstPlanNumber"),
                    jsonObject.getString("workName"),
                    projectId));
        }


        return workAuthorizationList;
    }

}
