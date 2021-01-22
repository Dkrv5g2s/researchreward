package Bean.ExcellentResearcher.PersonalInformation;



public class PersonalInformation {
    private String college;
    private String department;
    private String hiredYear;
    private String hiredMonth;
    private Seniority seniority;
    private String cName;
    private String eName;
    private String title;
    private String country;
    private String gender;
    private Education education;
    private Experiment experiment;
    private MOSTPlan mostPlan;
    private Boolean qualification1;
    private Boolean qualification2;
    private String level;
    private String price;
    private int projectId;


    public PersonalInformation(String college, String department, String hiredYear, String hiredMonth, Seniority seniority, String cName, String eName, String title, String country, String gender, Education education, Experiment experiment, MOSTPlan mostPlan, Boolean qualification1, Boolean qualification2, String level, int projectId, String price) {
        this.college = college;
        this.department = department;
        this.hiredYear = hiredYear;
        this.hiredMonth = hiredMonth;
        this.seniority = seniority;
        this.cName = cName;
        this.eName = eName;
        this.title = title;
        this.country = country;
        this.gender = gender;
        this.education = education;
        this.experiment = experiment;
        this.mostPlan = mostPlan;
        this.qualification1 = qualification1;
        this.qualification2 = qualification2;
        this.level = level;
        this.projectId = projectId;
        this.price = price;
    }

    public PersonalInformation() {

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHiredYear() {
        return hiredYear;
    }

    public void setHiredYear(String hiredYear) {
        this.hiredYear = hiredYear;
    }

    public String getHiredMonth() {
        return hiredMonth;
    }

    public void setHiredMonth(String hiredMonth) {
        this.hiredMonth = hiredMonth;
    }

    public Seniority getSeniority() {
        return seniority;
    }

    public void setSeniority(Seniority seniority) {
        this.seniority = seniority;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Experiment getExperiment() {
        return experiment;
    }

    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    public MOSTPlan getMostPlan() {
        return mostPlan;
    }

    public void setMostPlan(MOSTPlan mostPlan) {
        this.mostPlan = mostPlan;
    }

    public Boolean getQualification1() {
        return qualification1;
    }

    public void setQualification1(Boolean qualification1) {
        this.qualification1 = qualification1;
    }

    public Boolean getQualification2() {
        return qualification2;
    }

    public void setQualification2(Boolean qualification2) {
        this.qualification2 = qualification2;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "college='" + college + '\'' +
                ", department='" + department + '\'' +
                ", hiredYear='" + hiredYear + '\'' +
                ", hiredMonth='" + hiredMonth + '\'' +
                ", seniority=" + seniority +
                ", cName='" + cName + '\'' +
                ", eName='" + eName + '\'' +
                ", title='" + title + '\'' +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", education=" + education +
                ", experiment=" + experiment +
                ", mostPlan=" + mostPlan +
                ", qualification1=" + qualification1 +
                ", qualification2=" + qualification2 +
                ", level='" + level + '\'' +
                ", price='" + price + '\'' +
                ", projectId='" + projectId + '\'' +
                '}';
    }
}
