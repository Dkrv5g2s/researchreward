package Bean.ExcellentResearcher.PersonalInformation;

public class Education {
    private String schoolName;
    private String major;
    private String degree;
    private String graduateYear;
    private String graduateMonth;
    private int projectId;

    public Education(String schoolName, String major, String degree, String graduateYear, String graduateMonth, int projectId) {
        this.schoolName = schoolName;
        this.major = major;
        this.degree = degree;
        this.degree = degree;
        this.graduateYear = graduateYear;
        this.graduateMonth = graduateMonth;
        this.projectId = projectId;
    }

    public Education() {

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(String graduateYear) {
        this.graduateYear = graduateYear;
    }

    public String getGraduateMonth() {
        return graduateMonth;
    }

    public void setGraduateMonth(String graduateMonth) {
        this.graduateMonth = graduateMonth;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
