package Service.ExcellentResearcher;



import Bean.ExcellentResearcher.CatalogOfWork;
import Dao.ExcellentResearcher.CatalogOfWorkDAO;
import Dao.ExcellentResearcher.Impl.CatalogOfWorkDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;

public class CatalogOfWorksService {

    private CatalogOfWorkDAO catalogOfWorkDAO = new CatalogOfWorkDAOImpl();


    public void save(JSONObject jsonObject, String userNumber){

        catalogOfWorkDAO.save(new CatalogOfWork(jsonObject.getString("work"),userNumber));

    }
}
