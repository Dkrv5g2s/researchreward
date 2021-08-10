package Service.Teacher;

import Bean.Project.ProjectFillRate;
import Bean.SpecialOutstandingResearcher.PaperPerformance;
import Bean.SpecialOutstandingResearcher.PaperPerformanceDescriptionForm;
import Dao.Project.ProjectFillRateDAO;
import Dao.Project.ProjectFillRateDAOImpl;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAO;
import Dao.SpecialOutstandingResearcherApplication.PaperPerformanceDescriptionDAOImpl;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProjectFillRateService {
    private ProjectFillRateDAO projectFillRateDAO = new ProjectFillRateDAOImpl();

    public JSONObject getFillFactors(int projectId) {
        List<ProjectFillRate> projectFillRateList = projectFillRateDAO.query(projectId);
        JSONObject fillRates = new JSONObject();
        for(ProjectFillRate projectFillRate: projectFillRateList){
            fillRates.put(projectFillRate.getColumnName(), projectFillRate.getFillRate());
        }
        fillRates.put("PaperPerformanceDescriptionUpload", getUploadRate(projectId));
        if (fillRates.containsKey("TeacherHireResearcherTableC"))   // 因為目前績優c表是用負數 暫時先這樣寫qq
            fillRates.put("TeacherHireResearcherTableCUpload", getUploadRate(-projectId));
        return fillRates;
    }


    public void save(int projectId, String columnName, Double fillRate){
        ProjectFillRate projectFillRate = new ProjectFillRate(projectId, columnName, fillRate);
        projectFillRateDAO.save(projectFillRate);
    }

    public void save(int projectId, JSONObject jsonObject){
        JSONObject fillRateJSONObject = jsonObject.getJSONObject("rateData");
        if (projectId < 0) // 因為目前績優c表是用負數 暫時先這樣寫qq
            this.save(Math.abs(projectId), "TeacherHireResearcherTableC", fillRateJSONObject.getDouble("fill_rate"));
        else
            this.save(projectId, fillRateJSONObject.getString("column_name"), fillRateJSONObject.getDouble("fill_rate"));
    }

    private Double getUploadRate(int projectId) {
        PaperPerformanceDescriptionDAO dao = new PaperPerformanceDescriptionDAOImpl() ;
        PaperPerformanceDescriptionForm paperPerformanceDescriptionForm = dao.query_specified_paper_performance_descripstion_form(projectId);
        List<PaperPerformance> paperPerformanceList = paperPerformanceDescriptionForm.getPaper_performance_list();
        List<Integer> paperIdList = new ArrayList<Integer>();
        for(PaperPerformance paperPerformance: paperPerformanceList){
            paperIdList.add(paperPerformance.getPaper_id());
        }
        Double upLoadNumber = 0.0;
        Double shouldUploadNumber = 0.0;
        for(int paperId: paperIdList){
            shouldUploadNumber += 2;
            PaperPerformance paperPerformance = dao.query_specified_paper_performance(paperId);
            if(paperPerformance.getJoint_authorization_agreement_file_path() != null){
                upLoadNumber++;
            }
            if(paperPerformance.getPaper_home_file_path() != null){
                upLoadNumber++;
            }
        }
        return Math.round(upLoadNumber/shouldUploadNumber*100.0)/100.0;
    }
}
