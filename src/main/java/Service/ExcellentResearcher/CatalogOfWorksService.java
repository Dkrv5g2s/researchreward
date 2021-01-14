package Service.ExcellentResearcher;



import Bean.ExcellentResearcher.CatalogOfWork;
import Dao.ExcellentResearcher.CatalogOfWorkDAO;
import Dao.ExcellentResearcher.Impl.CatalogOfWorkDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class CatalogOfWorksService {

    private CatalogOfWorkDAO catalogOfWorkDAO = new CatalogOfWorkDAOImpl();


    public void save(JSONObject jsonObject, String userNumber){

        catalogOfWorkDAO.save(new CatalogOfWork(jsonObject.getString("work"),userNumber));

    }

    public JSONObject get(String userNumber){

        CatalogOfWork catalogOfWork = catalogOfWorkDAO.get(userNumber);
        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,catalogOfWork);
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }


        return object;


    }
}
