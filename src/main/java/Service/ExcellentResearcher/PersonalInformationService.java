package Service.ExcellentResearcher;

import Bean.ExcellentResearcher.PersonalInformation.*;
import Dao.ExcellentResearcher.*;
import Dao.ExcellentResearcher.Impl.*;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class PersonalInformationService {

    private PersonalInformationDAO personalInformationDAO = new PersonalInformationDAOImpl();
    private SeniorityDAO seniorityDAO = new SeniorityDAOImpl();
    private MOSTPlanDAO mostPlanDAO = new MOSTPlanDAOImpl();
    private EducationDAO educationDAO = new EducationDAOImpl();
    private ExperimentDAO experimentDAO = new ExperimentDAOImpl();

    public void save(JSONObject jsonObject, int projectId){
        Seniority seniority = new Seniority(jsonObject.getString("year"),jsonObject.getString("month"),projectId);
        Education education = new Education(jsonObject.getString("schoolName"),
                jsonObject.getString("major"),
                jsonObject.getString("degree"),
                jsonObject.getString("graduateMonth"),
                jsonObject.getString("graduateMonth"),
                projectId);
        Experiment experiment = new Experiment(jsonObject.getString("ServiceOrganization"),
                jsonObject.getString("ServiceDepartment"),
                jsonObject.getString("pastTitle"),
                jsonObject.getString("pastYear"),
                jsonObject.getString("pastMonth"),
                projectId);
        MOSTPlan mostPlan = new MOSTPlan(jsonObject.getString("planName"),
                jsonObject.getString("planNumber"),
                jsonObject.getDate("startTime"),
                jsonObject.getDate("lastTime"),
                projectId);
        PersonalInformation personalInformation = new PersonalInformation(jsonObject.getString("college"),
                jsonObject.getString("department"),
                jsonObject.getString("hiredYear"),
                jsonObject.getString("hiredMonth"),
                null,
                jsonObject.getString("cName"),
                jsonObject.getString("eName"),
                jsonObject.getString("title"),
                jsonObject.getString("country"),
                jsonObject.getString("gender"),
                null,
                null,
                null,
                jsonObject.getBoolean("qualification1"),
                jsonObject.getBoolean("qualification1"),
                jsonObject.getString("level"),
                projectId,
                jsonObject.getString("price"));


        seniorityDAO.save(seniority);
        experimentDAO.save(experiment);
        mostPlanDAO.save(mostPlan);
        educationDAO.save(education);
        personalInformationDAO.save(personalInformation);
    }



    public JSONObject get(String projectId) {

        PersonalInformation personalInformation = personalInformationDAO.get(projectId);
        Seniority seniority = seniorityDAO.get(projectId);
        Experiment experiment = experimentDAO.get(projectId);
        MOSTPlan mostPlan = mostPlanDAO.get(projectId);
        Education education = educationDAO.get(projectId);

        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,personalInformation);
            addBeanPropertyToJson(object,seniority);
            addBeanPropertyToJson(object,experiment);
            addBeanPropertyToJson(object,mostPlan);
            addBeanPropertyToJson(object,education);
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }

        return object;

    }


}
