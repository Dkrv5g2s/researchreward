package Service.ExcellentResearcher;



import Bean.ExcellentResearcher.CatalogOfWork;
import Dao.ExcellentResearcher.CatalogOfWorkDAO;
import Dao.ExcellentResearcher.Impl.CatalogOfWorkDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class CatalogOfWorksService {

    private CatalogOfWorkDAO catalogOfWorkDAO = new CatalogOfWorkDAOImpl();


    public void save(JSONObject jsonObject, int projectId){

        catalogOfWorkDAO.save(new CatalogOfWork(jsonObject.getString("work"),projectId));

    }

    public JSONObject get(int projectId){

        CatalogOfWork catalogOfWork = catalogOfWorkDAO.get(projectId);
        JSONObject object = new JSONObject();

        try {
            addBeanPropertyToJson(object,catalogOfWork);
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }


        return object;


    }
}
