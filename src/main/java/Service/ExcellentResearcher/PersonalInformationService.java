package Service.ExcellentResearcher;

import Bean.ExcellentResearcher.PersonalInformation.*;
import Dao.ExcellentResearcher.*;
import Dao.ExcellentResearcher.Impl.*;
import Service.Teacher.ProjectFillRateService;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.sql.Date;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class PersonalInformationService {

    private PersonalInformationDAO personalInformationDAO = new PersonalInformationDAOImpl();
    private SeniorityDAO seniorityDAO = new SeniorityDAOImpl();
    private MOSTPlanDAO mostPlanDAO = new MOSTPlanDAOImpl();
    private EducationDAO educationDAO = new EducationDAOImpl();
    private ExperimentDAO experimentDAO = new ExperimentDAOImpl();
    private ProjectFillRateService projectFillRateService = new ProjectFillRateService();

    public void saveAtFirstTimeApplying(JSONObject jsonObject, int projectId){
        Seniority seniority = new Seniority(jsonObject.getString("year"),jsonObject.getString("month"),projectId);
        Education education = new Education(jsonObject.getString("schoolName"),
                jsonObject.getString("major"),
                jsonObject.getString("degree"),
                jsonObject.getString("graduateYear"),
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
                jsonObject.getString("startTime").equals("") ? null : jsonObject.getDate("startTime"),
                jsonObject.getString("lastTime").equals("") ? null : jsonObject.getDate("lastTime"),
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
                jsonObject.getBoolean("qualification2"),
                jsonObject.getString("level"),
                projectId,
                jsonObject.getString("price"));

        seniorityDAO.save(seniority);
        experimentDAO.save(experiment);
        mostPlanDAO.save(mostPlan);
        educationDAO.save(education);
        personalInformationDAO.save(personalInformation);

        projectFillRateService.save(projectId, "PersonalInformation", jsonObject.getDouble("fill_rate"));
    }

    public void saveAtSecondTimeApplying(JSONObject jsonObject, int projectId){
        Seniority seniority = new Seniority(jsonObject.getString("year"),jsonObject.getString("month"),projectId);

        MOSTPlan mostPlan = new MOSTPlan(jsonObject.getString("planName"),
                jsonObject.getString("planNumber"),
                jsonObject.getString("startTime").equals("") ? null : jsonObject.getDate("startTime"),
                jsonObject.getString("lastTime").equals("") ? null : jsonObject.getDate("lastTime"),
                projectId);
        Experiment experiment = new Experiment(null,
                null,
                jsonObject.getString("pastTitle"),
                null,
                null,
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
                jsonObject.getBoolean("qualification2"),
                jsonObject.getString("level"),
                projectId,
                jsonObject.getString("price"));
        personalInformation.setWorkContent(jsonObject.getString("workContent"));
        personalInformation.setPastPrice(jsonObject.getString("pastPrice"));

        seniorityDAO.save(seniority);
        experimentDAO.save(experiment);
        mostPlanDAO.save(mostPlan);
        personalInformationDAO.save(personalInformation);

        projectFillRateService.save(projectId, "SecondPersonalInformation", jsonObject.getDouble("fill_rate"));
    }

    public void updateDepartmentReviewData(JSONObject jsonObject, int projectId){
        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setProjectId(projectId);
        personalInformation.setDepartmentDirectorSignDate(jsonToDate(jsonObject, "departmentDirectorSignDate"));

        personalInformationDAO.updateDepartmentReviewData(personalInformation);
    }

    public void updateCollegeReviewData(JSONObject jsonObject, int projectId){
        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setProjectId(projectId);
        personalInformation.setCollegeReviewedDate(jsonToDate(jsonObject, "collegeReviewedDate"));
        personalInformation.setReviewedResult(jsonObject.getString("reviewedResult"));
        personalInformation.setCollegeRecommendationRank(jsonObject.getString("collegeRecommendationRank"));
        personalInformation.setCollegeDirectorSignDate(jsonToDate(jsonObject, "collegeDirectorSignDate"));

        personalInformationDAO.updateCollegeReviewData(personalInformation);
    }

    public JSONObject get(int projectId) {

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

    private Date jsonToDate(JSONObject jsonObject, String str) {
        try {
            return new Date(jsonObject.getDate(str).getTime());
        }catch(Exception e){
            return null;
        }
    }
}
