package Service.SunshineScholarshipAward;



import Bean.SunshineScholarshipAward.PersonalInformation;
import Bean.SunshineScholarshipAward.FWCIPrizeInfomation;
import Bean.SunshineScholarshipAward.FWCIUserInputInfomation;
import Dao.SunshineScholarshipAward.Impl.PersonalInfoDAOImpl;
import Dao.SunshineScholarshipAward.PersonalInfoDAO;
import Dao.SunshineScholarshipAward.Impl.FWCIPrizeDAOImpl;
import Dao.SunshineScholarshipAward.FWCIPrizeDAO;
import Dao.SunshineScholarshipAward.Impl.FWCIUserInputDAOImpl;
import Dao.SunshineScholarshipAward.FWCIUserInputDAO;
import Service.Teacher.ProjectFillRateService;
import fr.opensagres.xdocreport.document.json.JSONObject;


import static Utils.ReflectUtils.addBeanPropertyToJson;


public class GeneralInformationService {
    private PersonalInfoDAO personalInformationDAO = new PersonalInfoDAOImpl();
    private FWCIUserInputDAO fwciUserInputDAO = new FWCIUserInputDAOImpl();
    private FWCIPrizeDAO fwciPrizeDAO = new FWCIPrizeDAOImpl();
    private ProjectFillRateService projectFillRateService = new ProjectFillRateService();

    public void save(JSONObject jsonObject, int projectId){

        // 將從JSP組好的JSON欄位內取值出來，組裝時是用欄位id的名字
        PersonalInformation personalInformation = new PersonalInformation(jsonObject.getString("chineseName"),
                                    jsonObject.getString("englishName"),
                                    jsonObject.getString("nationalIDNumber"),
                                    jsonObject.getString("department"),
                                    jsonObject.getString("titles"),
                                    jsonObject.getString("levels"),
                                    jsonObject.getString("resignedTime"),
                                    jsonObject.getString("extensionNumber"),
                                    jsonObject.getString("cellphoneNumber"),
                                    jsonObject.getString("emailAddress"),
                                    projectId
                               );

        FWCIUserInputInfomation fwciUserInputInfomation = new FWCIUserInputInfomation(jsonObject.getString("SWArticleCountOne"),
                jsonObject.getString("SWPointOne"),
                jsonObject.getString("FWCIValueOfUser"),
                jsonObject.getBoolean("TeacherFormCheck"),
                jsonObject.getString("CommitDate"),
                projectId,
                jsonObject.getString("h5IndexOfUser")

        );
        personalInformationDAO.save(personalInformation);
        fwciUserInputDAO.save(fwciUserInputInfomation);
        projectFillRateService.save(projectId, "SunshineScholarshipAwardGeneralInformation", jsonObject.getDouble("fill_rate"));

    }



    public JSONObject get(int projectId) {
        PersonalInformation personalInformation = personalInformationDAO.get(projectId);
        FWCIUserInputInfomation fwciUserInputInfomation = fwciUserInputDAO.get(projectId);
        FWCIPrizeInfomation fwciPrizeInfomation = fwciPrizeDAO.get();

        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,personalInformation);
            addBeanPropertyToJson(object,fwciUserInputInfomation);
            addBeanPropertyToJson(object,fwciPrizeInfomation);
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }
        return object;
    }
}
