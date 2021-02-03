package Service.OutstandingResearchAward;

import Bean.OutstandingResearchAward.OutstandingResearchAwardReviewInformation;
import Dao.OutstandingResearchAward.OutstandingResearchAwardReviewInformationDAO;
import Dao.OutstandingResearchAward.OutstandingResearchAwardReviewInformationDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONArray;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static Utils.ReflectUtils.addBeanPropertyToJson;

public class OutstandingResearchAwardReviewInformationService {

    private OutstandingResearchAwardReviewInformationDAO OutstandingResearchAwardReviewInformationDAO = new OutstandingResearchAwardReviewInformationDAOImpl();

    public void save(JSONArray jsonArray, int projectId){
        List<OutstandingResearchAwardReviewInformation> list = new ArrayList<>();
        for (Object element: jsonArray) {
            JSONObject jsonObject = (JSONObject)element;
            list.add(new OutstandingResearchAwardReviewInformation(
                    projectId,
                    jsonObject.getInt("userNumber"),
                    jsonObject.getString("technologyTransferContractName"),
                    jsonObject.getString("technologyTransferDepartment"),
                    jsonToDate(jsonObject, "contractDate"),
                    jsonObject.getString("technologyTransferFund"),
                    jsonToDate(jsonObject, "technologyTransferFundBringInDate")
            ));
        }
        OutstandingResearchAwardReviewInformationDAO.save(list, projectId);
    }

    public JSONArray get(int projectId) {
        List<OutstandingResearchAwardReviewInformation> ORAReviewInformationList = OutstandingResearchAwardReviewInformationDAO.get(projectId);
        if(ORAReviewInformationList.size()==0) {
            ORAReviewInformationList = new ArrayList<>();
        }
        JSONArray object = new JSONArray();
        try {
            object.add(toJsonArray(ORAReviewInformationList));
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }
        return object;
    }

    private JSONArray toJsonArray(List<OutstandingResearchAwardReviewInformation> list) throws IllegalAccessException {
        JSONArray array = new JSONArray();
        for(OutstandingResearchAwardReviewInformation ORAReviewInformationList : list){
            JSONObject object = new JSONObject();
            addBeanPropertyToJson(object,ORAReviewInformationList);
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
