package Service.DistinguishedProfessor;

import static Utils.ReflectUtils.addBeanPropertyToJson;

import java.util.ArrayList;
import java.util.List;

import Bean.DistinguishedProfessor.DistinguishedProfessorAppDocInstructions;
import Dao.DistinguishedProfessor.DistinguishedProfessorAppDocInstructionsDAO;
import Dao.DistinguishedProfessor.Impl.DistinguishedProfessorAppDocInstructionsDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

public class DistinguishedProfessorAppDocInstructionsService {
	private DistinguishedProfessorAppDocInstructionsDAO distinguishedProfessorAppDocInstructionsDAO = new DistinguishedProfessorAppDocInstructionsDAOImpl();

    public void save(JSONArray jsonArray, String userNumber){
    	List<DistinguishedProfessorAppDocInstructions> list = new ArrayList<>();
    	
    	for (Object element: jsonArray) {
            JSONObject jsonObject = (JSONObject)element;
            list.add(new DistinguishedProfessorAppDocInstructions(
            		userNumber,
                    jsonObject.getString("technologyTransferContractName"),
                    jsonObject.getString("technologyTransferDepartment"),
                    jsonObject.getString("contractDate"),
                    jsonObject.getString("technologyTransferFund"),
                    jsonObject.getString("technologyTransferFundBringInDate")));
    	}


    	distinguishedProfessorAppDocInstructionsDAO.save(list, userNumber);
    }
    
    public JSONArray show(String userNumber) {
    	List<DistinguishedProfessorAppDocInstructions> distinguishedProfessorAppDocInstructions = distinguishedProfessorAppDocInstructionsDAO.show(userNumber);
    	if(distinguishedProfessorAppDocInstructions == null) {
    		distinguishedProfessorAppDocInstructions = new ArrayList<>();
    	}
    	JSONArray object = new JSONArray();

        try {
        	object.add(toJsonArray(distinguishedProfessorAppDocInstructions));
        }catch(IllegalAccessException e){

        }
    	return object;
    }
    
    private JSONArray toJsonArray(List<DistinguishedProfessorAppDocInstructions> list) throws IllegalAccessException {
        JSONArray array = new JSONArray();

        for(DistinguishedProfessorAppDocInstructions distinguishedProfessorAppDocInstructions : list){
            JSONObject object = new JSONObject();
            addBeanPropertyToJson(object,distinguishedProfessorAppDocInstructions);
            array.add(object);
        }

        return array;
    }
}
