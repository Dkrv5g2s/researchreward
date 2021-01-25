package Service.SunshineScholarshipAward;


import Bean.SunshineScholarshipAward.PersonalInformation;
import Dao.SunshineScholarshipAward.Impl.PersonalInfoDAOImpl;
import Dao.SunshineScholarshipAward.PersonalInfoDAO;
import fr.opensagres.xdocreport.document.json.JSONObject;


import static Utils.ReflectUtils.addBeanPropertyToJson;


public class GeneralInformationService {
    private PersonalInfoDAO personalInformationDAO = new PersonalInfoDAOImpl();

    public void save(JSONObject jsonObject, int projectId){

        PersonalInformation personalInformation = new PersonalInformation(jsonObject.getString("chineseName"),
                                    jsonObject.getString("englishName"),
                                    jsonObject.getString("nationalIDNumber"),
                                    jsonObject.getString("department"),
                                    jsonObject.getString("titles"),
                                    jsonObject.getString("levels"),
                                    jsonObject.getString("ResignedTime"),
                                    jsonObject.getString("extensionNumber"),
                                    jsonObject.getString("cellphoneNumber"),
                                    jsonObject.getString("emailAddress"),
                                    projectId
                               );
//        System.out.println("personalInformation:" + personalInformation);
        personalInformationDAO.save(personalInformation);
    }



    public JSONObject get(int projectId) {

        PersonalInformation personalInformation = personalInformationDAO.get(projectId);

        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,personalInformation);

        }catch(IllegalAccessException e){
            e.printStackTrace();
        }

        return object;

    }
}
