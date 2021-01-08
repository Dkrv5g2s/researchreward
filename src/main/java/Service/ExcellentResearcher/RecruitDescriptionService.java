package Service.ExcellentResearcher;

import Bean.ExcellentResearcher.RecruitDescription;
import Dao.ExcellentResearcher.Impl.RecruitDescriptionDAOImpl;
import Dao.ExcellentResearcher.RecruitDescriptionDAO;
import fr.opensagres.xdocreport.document.json.JSONObject;

public class RecruitDescriptionService {

    private RecruitDescriptionDAO recruitDescriptionDAO = new RecruitDescriptionDAOImpl();

    public void save(JSONObject jsonObject, String userNumber){
        recruitDescriptionDAO.save(new RecruitDescription(jsonObject.getString("recruitReason"),
                jsonObject.getString("recruitContent"),
                jsonObject.getString("expect"),
                jsonObject.getString("analysis"),
                jsonObject.getString("researchProduction"),
                jsonObject.getString("award"),
                jsonObject.getString("other"),
                jsonObject.getString("contribution"),
                userNumber));
    }
}
