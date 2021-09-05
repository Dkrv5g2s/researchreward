package Bean.SpecialOutstandingResearcher;

import java.util.List;

public class PaperPerformanceDescriptionForm {
    private int project_id ;
    private String commit_date;
    List<PaperPerformance> paper_performance_list ;

    public PaperPerformanceDescriptionForm() {
    }

    public PaperPerformanceDescriptionForm(int project_id, String commit_date, List<PaperPerformance> paper_performance_list) {
        this.project_id = project_id;
        this.commit_date = commit_date;
        this.paper_performance_list = paper_performance_list;
    }

    public PaperPerformanceDescriptionForm(int project_id) {
        this.project_id = project_id;
    }

    public String getCommitDate() {
        return commit_date;
    }

    public void setCommitDate(String commit_date) {
        this.commit_date = commit_date;
    }

    public List<PaperPerformance> getPaper_performance_list() {
        return paper_performance_list;
    }

    public void setPaper_performance_list(List<PaperPerformance> paper_performance_list) {
        this.paper_performance_list = paper_performance_list;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
}
