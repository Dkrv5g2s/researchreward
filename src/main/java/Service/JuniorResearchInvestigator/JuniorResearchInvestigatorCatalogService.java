package Service.JuniorResearchInvestigator;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorCatalog;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorCatalogDAO;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorCatalogDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JuniorResearchInvestigatorCatalogService {
    private JuniorResearchInvestigatorCatalogDAO juniorResearchInvestigatorCatalogDAO = new JuniorResearchInvestigatorCatalogDAOImpl();

    public void saveEditStatus(int projectId, String application_name){
        JuniorResearchInvestigatorCatalog juniorResearchInvestigatorCatalog = new JuniorResearchInvestigatorCatalog(
                projectId,
                application_name,
                getNowDate(),
                null
        );
        juniorResearchInvestigatorCatalogDAO.saveEditStatus(juniorResearchInvestigatorCatalog, projectId);
    }
    public void saveReviewStatus(int projectId, String application_name){
        JuniorResearchInvestigatorCatalog juniorResearchInvestigatorCatalog = new JuniorResearchInvestigatorCatalog(
                projectId,
                application_name,
                null,
                getNowDate()
        );
        juniorResearchInvestigatorCatalogDAO.saveReviewStatus(juniorResearchInvestigatorCatalog, projectId);
    }
    private String getNowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public JSONObject show(int projectId, Boolean readonly) {
        List<JuniorResearchInvestigatorCatalog> juniorResearchInvestigatorCatalogList = juniorResearchInvestigatorCatalogDAO.show(projectId);
        if(juniorResearchInvestigatorCatalogList.size()==0) {
            juniorResearchInvestigatorCatalogList = new ArrayList<>();
        }
        JSONObject object = new JSONObject();
        if(readonly){
            for(JuniorResearchInvestigatorCatalog juniorResearchInvestigatorCatalog : juniorResearchInvestigatorCatalogList){
                object.put(juniorResearchInvestigatorCatalog.getApplicationName(), juniorResearchInvestigatorCatalog.getReviewTime());
            }
        }
        else{
            for(JuniorResearchInvestigatorCatalog juniorResearchInvestigatorCatalog : juniorResearchInvestigatorCatalogList){
                object.put(juniorResearchInvestigatorCatalog.getApplicationName(), juniorResearchInvestigatorCatalog.getEditTime());
            }
        }
        return object;
    }
}
