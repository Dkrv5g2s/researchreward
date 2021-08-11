package Bean.LectureProfessorAndHonoraryLectureProfessor;

public class LectureProfessorHonoraryApplicationForm {
    private String usernum;
    private String name;
    private String jobAndDept;
    private String email;
//    private String researchroomext;
    private String cellphone;
    private String indivisualEducation;
    private String recommendationReason;
    private String commitDate;

    public LectureProfessorHonoraryApplicationForm(String usernum, String name, String jobAndDept, String email, String cellphone, String indivisualEducation, String recommendationReason){
        this.usernum = usernum;
        this.name = name;
        this.jobAndDept = jobAndDept;
        this.email = email;
        this.cellphone = cellphone;
        this.indivisualEducation = indivisualEducation;
        this.recommendationReason = recommendationReason;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobAndDept() {
        return jobAndDept;
    }

    public void setJobAndDept(String jobAndDept) {
        this.jobAndDept = jobAndDept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getIndivisualEducation() {
        return indivisualEducation;
    }

    public void setIndivisualEducation(String indivisualEducation) {
        this.indivisualEducation = indivisualEducation;
    }

    public String getRecommendationReason() {
        return recommendationReason;
    }

    public void setRecommendationReason(String recommendationReason) {
        this.recommendationReason = recommendationReason;
    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = commitDate;
    }

    @Override
    public String toString() {
        return "LectureProfessorHonoraryApplicationForm{" +
                "usernum='" + usernum + '\'' +
                ", name='" + name + '\'' +
                ", jobAndDept='" + jobAndDept + '\'' +
                ", email='" + email + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", indivisualEducation='" + indivisualEducation + '\'' +
                ", recommendationReason='" + recommendationReason + '\'' +
                ", commitDate='" + commitDate + '\'' +
                '}';
    }
}
