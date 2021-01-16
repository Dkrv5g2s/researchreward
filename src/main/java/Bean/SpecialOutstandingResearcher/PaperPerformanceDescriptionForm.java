package Bean.SpecialOutstandingResearcher;

import java.util.List;

public class PaperPerformanceDescriptionForm {
    private int project_id ;
    private String fwci_value_past_five_year;
    private String total_point ;
    List<PaperPerformance> paper_performance_list ;




    public PaperPerformanceDescriptionForm() {
    }

    public PaperPerformanceDescriptionForm(int project_id, String fwci_value_past_five_year, String total_point, List<PaperPerformance> paper_performance_list) {
        this.project_id = project_id;
        this.fwci_value_past_five_year = fwci_value_past_five_year;
        this.total_point = total_point;
        this.paper_performance_list = paper_performance_list;
    }

    public PaperPerformanceDescriptionForm(int project_id) {
        this.project_id = project_id;
    }

    public String getFwci_value_past_five_year() {
        return fwci_value_past_five_year;
    }

    public void setFwci_value_past_five_year(String fwci_value_past_five_year) {
        this.fwci_value_past_five_year = fwci_value_past_five_year;
    }

    public String getTotal_point() {
        return total_point;
    }

    public void setTotal_point(String total_point) {
        this.total_point = total_point;
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
