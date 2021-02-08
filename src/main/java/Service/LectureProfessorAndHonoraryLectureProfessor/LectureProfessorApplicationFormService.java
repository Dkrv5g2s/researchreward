package Service.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorApplicationForm;
import Dao.LectureProfessorAndHonoraryLectureProfessor.Impl.LectureProfessorApplicationFormDAOImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorApplicationFormDAO;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class LectureProfessorApplicationFormService {
    private LectureProfessorApplicationFormDAO lectureProfessorApplicationFormDAO = new LectureProfessorApplicationFormDAOImpl();

    public void save(JSONObject jsonObject, String userNumber, String projectID){
        System.out.println("SAVE");
        LectureProfessorApplicationForm lectureProfessorApplicationForm = new LectureProfessorApplicationForm(
                userNumber,
                jsonObject.getString("name"),
                jsonObject.getString("job"),
                jsonObject.getString("serviceSchoolAndDepartment"),
                jsonObject.getString("certificatenum"),
                jsonObject.getString("workStartDate"),
                jsonObject.getString("seniority"),
                jsonObject.getString("email"),
                jsonObject.getString("researchroomext"),
                jsonObject.getString("cellphone"),
                jsonObject.getBoolean("applicationrequirements1"),
                jsonObject.getBoolean("applicationrequirements2"),
                jsonObject.getBoolean("applicationrequirements3"),
                jsonObject.getBoolean("applicationrequirements4"),
                jsonObject.getBoolean("applicationrequirements5"),
                jsonObject.getBoolean("applicationrequirements6"),
                jsonObject.getBoolean("applicationrequirements7"),
                jsonObject.getBoolean("applicationrequirements8"),
                jsonObject.getBoolean("applicationrequirements9"),
                jsonObject.getBoolean("applicationrequirements10"),
                jsonObject.getBoolean("applicationrequirements11"),
                jsonObject.getBoolean("applicationrequirements12"),
                jsonObject.getBoolean("applicationrequirements13"),
                jsonObject.getBoolean("applicationrequirements14"),
                jsonObject.getBoolean("applicationrequirements15"),
                jsonObject.getBoolean("applicationrequirementsCheck"),
                jsonObject.getBoolean("lectureCategoryExp"),
                jsonObject.getBoolean("lectureCategoryInv"),
                jsonObject.getBoolean("lectureCategoryLif"),
                jsonObject.getString("additionalInfo"));
        System.out.println("DONE");

        lectureProfessorApplicationFormDAO.save(lectureProfessorApplicationForm,projectID);
    }

    public JSONObject show(String userNumber,String projectID) {
        LectureProfessorApplicationForm lectureProfessorApplicationForm = lectureProfessorApplicationFormDAO.show(projectID);
        if(lectureProfessorApplicationForm == null) {
            lectureProfessorApplicationForm = new LectureProfessorApplicationForm(userNumber, "",  "",  "",  "",  "",  "",  "",  "",  "", false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,false,false,false,"");
        }
        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,lectureProfessorApplicationForm);
        }catch(IllegalAccessException e){
        }
        return object;
    }

}
