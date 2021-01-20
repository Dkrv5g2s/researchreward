package Bean.ExcellentResearcher.PersonalInformation;

public class Seniority {
    private String year;
    private String month;
    private String projectId;

    public Seniority(String year, String month, String projectId) {
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

    public String getprojectId() {
        return projectId;
    }

    public void setprojectId(String projectId) {
        this.projectId = projectId;
    }
}
