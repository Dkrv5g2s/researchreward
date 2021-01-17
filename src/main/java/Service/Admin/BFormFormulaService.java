package Service.Admin;

import Bean.Admin.BFormFormula;
import Dao.Admin.BFormFormulaDAO;
import Dao.Admin.Impl.BFormFormulaDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class BFormFormulaService {

    private BFormFormulaDAO bFormFormulaDAO = new BFormFormulaDAOImpl();

    public void save(JSONObject jsonObject, String userNumber){
        BFormFormula object = new BFormFormula();
        object.setW1_1(jsonObject.getDouble("w1_1"));
        object.setW1_2(jsonObject.getDouble("w1_2"));
        object.setW1_3(jsonObject.getDouble("w1_3"));
        object.setW1_4(jsonObject.getDouble("w1_4"));
        object.setW1_5(jsonObject.getDouble("w1_5"));
        object.setW1_6(jsonObject.getDouble("w1_6"));
        object.setW1_7(jsonObject.getDouble("w1_7"));
        object.setW2_1(jsonObject.getDouble("w2_1"));
        object.setW2_2(jsonObject.getDouble("w2_2"));
        object.setW2_3(jsonObject.getDouble("w2_3"));
        object.setW2_4(jsonObject.getDouble("w2_4"));
        object.setW2_5(jsonObject.getDouble("w2_5"));
        object.setW2_6(jsonObject.getDouble("w2_6"));
        object.setW3_1(jsonObject.getDouble("w3_1"));
        object.setW3_2(jsonObject.getDouble("w3_2"));
        object.setW4_1(jsonObject.getDouble("w4_1"));
        object.setW4_2(jsonObject.getDouble("w4_2"));
        object.setW4_3(jsonObject.getDouble("w4_3"));
        object.setW4_4(jsonObject.getDouble("w4_4"));
        object.setW4_5(jsonObject.getDouble("w4_5"));
        object.setW4_6(jsonObject.getDouble("w4_6"));
        object.setW4_7(jsonObject.getDouble("w4_7"));
        object.setUserNumber(userNumber);
        bFormFormulaDAO.save(object);
    }

    public JSONObject get(String userNumber){

        BFormFormula result = bFormFormulaDAO.get(userNumber);

        JSONObject jsonObject = new JSONObject();

        try {
            addBeanPropertyToJson(jsonObject, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
