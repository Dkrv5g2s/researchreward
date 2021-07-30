package Bean.Project;

public class ProjectFillRate {
    private int project_id;
    private String column_name;
    private Double fill_rate;

    public ProjectFillRate(int project_id, String column_name, Double fill_rate) {
        this.project_id = project_id;
        this.column_name = column_name;
        this.fill_rate = fill_rate;
    }

    public int getProjectId() {
        return project_id;
    }

    public void setProjectId(int project_id) {
        this.project_id = project_id;
    }

    public String getColumnName() {
        return column_name;
    }

    public void setColumnName(String column_name) {
        this.column_name = column_name;
    }

    public Double getFillRate() {
        return fill_rate;
    }

    public void setFillRate(Double fill_rate) {
        this.fill_rate = fill_rate;
    }
}
