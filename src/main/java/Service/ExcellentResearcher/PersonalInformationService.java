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

    public void save(JSONObject jsonObject, String userNumber){
        Seniority seniority = new Seniority(jsonObject.getString("year"),jsonObject.getString("month"),userNumber);
        Education education = new Education(jsonObject.getString("schoolName"),
                jsonObject.getString("major"),
                jsonObject.getString("degree"),
                jsonObject.getString("graduateMonth"),
                jsonObject.getString("graduateMonth"),
                userNumber);
        Experiment experiment = new Experiment(jsonObject.getString("ServiceOrganization"),
                jsonObject.getString("ServiceDepartment"),
                jsonObject.getString("pastTitle"),
                jsonObject.getString("pastYear"),
                jsonObject.getString("pastMonth"),
                userNumber);
        MOSTPlan mostPlan = new MOSTPlan(jsonObject.getString("planName"),
                jsonObject.getString("planNumber"),
                jsonObject.getDate("startTime"),
                jsonObject.getDate("lastTime"),
                userNumber);
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
                userNumber,
                jsonObject.getString("price"));


        seniorityDAO.save(seniority);
        experimentDAO.save(experiment);
        mostPlanDAO.save(mostPlan);
        educationDAO.save(education);
        personalInformationDAO.save(personalInformation);
    }



    public JSONObject get(String userNumber) {

        PersonalInformation personalInformation = personalInformationDAO.get(userNumber);
        Seniority seniority = seniorityDAO.get(userNumber);
        Experiment experiment = experimentDAO.get(userNumber);
        MOSTPlan mostPlan = mostPlanDAO.get(userNumber);
        Education education = educationDAO.get(userNumber);

        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,personalInformation);
            addBeanPropertyToJson(object,seniority);
            addBeanPropertyToJson(object,experiment);
            addBeanPropertyToJson(object,mostPlan);
            addBeanPropertyToJson(object,education);
        }catch(IllegalAccessException e){

        }

        return object;

    }


}
