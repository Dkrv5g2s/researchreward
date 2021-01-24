package Service.DistinguishedProfessor;

import static Utils.ReflectUtils.addBeanPropertyToJson;

import Bean.DistinguishedProfessor.*;
import Dao.DistinguishedProfessor.*;
import Dao.DistinguishedProfessor.Impl.*;
import fr.opensagres.xdocreport.document.json.JSONObject;

public class DistinguishedProfessorFormService {

    private DistinguishedProfessorFormDAO distinguishedProfessorFormDAO = new DistinguishedProfessorFormDAOImpl();

    public void save(JSONObject jsonObject, String userNumber, String projectID){
    	DistinguishedProfessorForm distinguishedProfessorForm = new DistinguishedProfessorForm(
    			userNumber,
                jsonObject.getString("name"),
                jsonObject.getString("department"),
                jsonObject.getString("hireddate"),
                jsonObject.getString("certificatenum"),
                jsonObject.getString("upgradedate"),
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
                jsonObject.getBoolean("applicationrequirements9"));


    	distinguishedProfessorFormDAO.save(distinguishedProfessorForm,projectID);
    }
    
    public JSONObject show(String userNumber,String projectID) {
    	DistinguishedProfessorForm distinguishedProfessorForm = distinguishedProfessorFormDAO.show(projectID);
    	if(distinguishedProfessorForm == null) {
    		distinguishedProfessorForm = new DistinguishedProfessorForm(userNumber, "", "", "", "", "", "", "", "", "", false, false, false, false, false, false, false, false, false);
    	}
    	JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,distinguishedProfessorForm);
        }catch(IllegalAccessException e){

        }
    	return object;
    }

}
