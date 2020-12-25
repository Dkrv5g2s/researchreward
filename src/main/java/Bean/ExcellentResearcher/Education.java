package Bean.ExcellentResearcher;

public class Education {
    private String schoolName;
    private String major;
    private String degree;
    private Integer graduateYear;
    private Integer graduateMonth;

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

    public Integer getGraduateYear() {
        return graduateYear;
    }

    public void setGraduateYear(Integer graduateYear) {
        this.graduateYear = graduateYear;
    }

    public Integer getGraduateMonth() {
        return graduateMonth;
    }

    public void setGraduateMonth(Integer graduateMonth) {
        this.graduateMonth = graduateMonth;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
