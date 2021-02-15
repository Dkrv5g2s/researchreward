package Service.ExcellentResearcher;


import Bean.ExcellentResearcher.RecruitDescription;
import Bean.ExcellentResearcher.ResearchProduction.Patent;
import Bean.ExcellentResearcher.ResearchProduction.ResearchProduction;
import Bean.ExcellentResearcher.ResearchProduction.Second.*;
import Bean.ExcellentResearcher.ResearchProduction.Technology;
import Bean.ExcellentResearcher.ResearchProduction.WorkAuthorization;
import Dao.ExcellentResearcher.AggregateDAO;
import Dao.ExcellentResearcher.Impl.AggregateDAOImpl;
import Dao.ExcellentResearcher.Impl.ResearchProductionDAOImpl;
import Dao.ExcellentResearcher.ResearchProductionDAO;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class ResearchProductionService {

    private ResearchProductionDAO researchProductionDAO = new ResearchProductionDAOImpl();
    private AggregateDAO aggregationDAO = new AggregateDAOImpl();

    public void save(JSONArray jsonArray, int projectId){
        ResearchProduction researchProduction = new ResearchProduction(projectId);
        researchProduction.setPatentList(jsonArrayToPatents((JSONArray)jsonArray.get(0),projectId));
        researchProduction.setTechnologyList( jsonArrayToTechnologys((JSONArray)jsonArray.get(1),projectId));
        researchProduction.setWorkAuthorizationList( jsonArrayToWorkAuthorizations((JSONArray)jsonArray.get(2),projectId));
        researchProductionDAO.save(researchProduction);
    }

    public JSONArray get(int projectId){

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

    public JSONArray getSecondProduction(int projectId){

        Aggregate aggregate = aggregationDAO.get(projectId);

        JSONArray jsonArray = new JSONArray();

        try {
            jsonArray.add(BeanListToJsonArray(aggregate.getPlanList()));
            jsonArray.add(BeanListToJsonArray(aggregate.getPaperList()));
            jsonArray.add(BeanListToJsonArray(aggregate.getBookList()));
            jsonArray.add(BeanListToJsonArray(aggregate.getRewardList()));
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }

        return jsonArray;


    }

    public void saveSecondProduction(JSONArray jsonArray, int projectId){
        Aggregate aggregate = new Aggregate();
        aggregate.setProjectId(projectId);
        this.jArrayToPlan((JSONArray) jsonArray.get(0),projectId,aggregate);
        this.jArrayToPaper((JSONArray) jsonArray.get(1),projectId,aggregate);
        this.jArrayToBook((JSONArray) jsonArray.get(2),projectId,aggregate);
        this.jArrayToReward((JSONArray) jsonArray.get(3),projectId,aggregate);
        aggregationDAO.save(aggregate);
    }

    private <T> JSONArray BeanListToJsonArray(List<T> list) throws IllegalAccessException {
        JSONArray array = new JSONArray();

        for(T element : list){
            JSONObject object = new JSONObject();
            addBeanPropertyToJson(object,element);
            array.add(object);
        }

        return array;
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


    private void jArrayToBook(JSONArray jsonArray, int projectId, Aggregate aggregate){
        for (Object element: jsonArray) {
            JSONObject jsonObject = (JSONObject) element;
            Book book = new Book();
            book.setNumber(jsonObject.getString("number"));
            book.setYear(jsonObject.getString("year"));
            book.setBookName(jsonObject.getString("bookName"));
            book.setPublisher(jsonObject.getString("publisher"));
            book.setPublishYear(jsonObject.getString("publishYear"));
            book.setISBN(jsonObject.getString("ISBN"));
            book.setProjectId(projectId);

            aggregate.addBook(book);
        }
    }
    private void jArrayToPlan(JSONArray jsonArray, int projectId, Aggregate aggregate){
        for (Object element: jsonArray) {
            JSONObject jsonObject = (JSONObject) element;

            Plan plan = new Plan();
            plan.setNumber(jsonObject.getString("number"));
            plan.setYear(jsonObject.getString("year"));
            plan.setPlanName(jsonObject.getString("planName"));
            plan.setPlanNumber(jsonObject.getString("planNumber"));
            plan.setStartTime(jsonObject.getDate("startTime"));
            plan.setLastTime(jsonObject.getDate("lastTime"));
            plan.setProjectId(projectId);

            aggregate.addPlan(plan);
        }
    }
    private void jArrayToPaper(JSONArray jsonArray, int projectId, Aggregate aggregate){
        for (Object element: jsonArray) {
            JSONObject jsonObject = (JSONObject) element;
            Paper paper = new Paper();
            paper.setNumber(jsonObject.getString("number"));
            paper.setYear(jsonObject.getString("year"));
            paper.setPaperName(jsonObject.getString("paperName"));
            paper.setJournal(jsonObject.getString("journal"));
            paper.setAuthor(jsonObject.getString("author"));
            paper.setProjectId(projectId);

            aggregate.addPaper(paper);
        }
    }
    private void jArrayToReward(JSONArray jsonArray, int projectId, Aggregate aggregate){
        for (Object element: jsonArray) {
            JSONObject jsonObject = (JSONObject) element;
            Reward reward = new Reward();
            reward.setRewardName(jsonObject.getString("rewardName"));
            reward.setOrganization(jsonObject.getString("organization"));
            reward.setRewardDate(jsonObject.getDate("rewardDate"));
            reward.setReason(jsonObject.getString("reason"));
            reward.setProjectId(projectId);
            aggregate.addReward(reward);
        }
    }

}
