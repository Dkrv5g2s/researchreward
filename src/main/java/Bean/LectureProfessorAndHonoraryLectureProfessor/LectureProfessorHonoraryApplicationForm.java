package Bean.LectureProfessorAndHonoraryLectureProfessor;

public class LectureProfessorHonoraryApplicationForm {
    private String usernum;
    private String name;
    private String jobAndDept;
    private String email;
    private String researchroomext;
    private String cellphone;
    private String indivisualEducation;
    private String recommendationReason;

    public LectureProfessorHonoraryApplicationForm(String usernum, String name, String jobAndDept, String email, String researchroomext, String cellphone, String indivisualEducation, String recommendationReason){
        this.usernum = usernum;
        this.name = name;
        this.jobAndDept = jobAndDept;
        this.email = email;
        this.researchroomext = researchroomext;
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

    public String getResearchroomext() {
        return researchroomext;
    }

    public void setResearchroomext(String researchroomext) {
        this.researchroomext = researchroomext;
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

    @Override
    public String toString() {
        return "LectureProfessorHonoraryApplicationForm{" +
                "usernum='" + usernum + '\'' +
                ", name='" + name + '\'' +
                ", jobAndDept='" + jobAndDept + '\'' +
                ", email='" + email + '\'' +
                ", researchroomext='" + researchroomext + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", indivisualEducation='" + indivisualEducation + '\'' +
                ", recommendationReason='" + recommendationReason + '\'' +
                '}';
    }
}
