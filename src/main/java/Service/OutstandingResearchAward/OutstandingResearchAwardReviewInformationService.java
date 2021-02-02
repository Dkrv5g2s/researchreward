package Service.OutstandingResearchAward;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorReviewInformation;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorReviewInformationDAO;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorReviewInformationDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class OutstandingResearchAwardReviewInformationService {

    private JuniorResearchInvestigatorReviewInformationDAO juniorResearchInvestigatorReviewInformationDAO = new JuniorResearchInvestigatorReviewInformationDAOImpl();

    public void save(JSONArray jsonArray, int projectId){
        List<JuniorResearchInvestigatorReviewInformation> list = new ArrayList<>();
        for (Object element: jsonArray) {
            JSONObject jsonObject = (JSONObject)element;
            list.add(new JuniorResearchInvestigatorReviewInformation(
                    projectId,
                    jsonObject.getInt("userNumber"),
                    jsonObject.getString("technologyTransferContractName"),
                    jsonObject.getString("technologyTransferDepartment"),
                    jsonToDate(jsonObject, "contractDate"),
                    jsonObject.getString("technologyTransferFund"),
                    jsonToDate(jsonObject, "technologyTransferFundBringInDate")
            ));
        }
        juniorResearchInvestigatorReviewInformationDAO.save(list, projectId);
    }

    public JSONArray show(int projectId) {
        List<JuniorResearchInvestigatorReviewInformation> juniorResearchInvestigatorReviewInformationList = juniorResearchInvestigatorReviewInformationDAO.show(projectId);
        if(juniorResearchInvestigatorReviewInformationList.size()==0) {
            juniorResearchInvestigatorReviewInformationList = new ArrayList<>();
        }
        JSONArray object = new JSONArray();
        try {
            object.add(toJsonArray(juniorResearchInvestigatorReviewInformationList));
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }
        return object;
    }

    private JSONArray toJsonArray(List<JuniorResearchInvestigatorReviewInformation> list) throws IllegalAccessException {
        JSONArray array = new JSONArray();
        for(JuniorResearchInvestigatorReviewInformation juniorResearchInvestigatorReviewInformation : list){
            JSONObject object = new JSONObject();
            addBeanPropertyToJson(object,juniorResearchInvestigatorReviewInformation);
            array.add(object);
        }
        return array;
    }

    private Date jsonToDate(JSONObject jsonObject, String str) {
        try {
            return new Date(jsonObject.getDate(str).getTime());
        }catch(Exception e){
            return null;
        }
    }
}
