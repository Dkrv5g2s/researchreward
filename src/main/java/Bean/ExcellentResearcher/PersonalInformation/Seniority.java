package Bean.ExcellentResearcher.PersonalInformation;

public class Seniority {
    private String year;
    private String month;
    private int projectId;

    public Seniority(String year, String month, int projectId) {
        this.year = year;
        this.month = month;
        this.projectId = projectId;
    }

    public Seniority() {

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
