package Bean.LectureProfessorAndHonoraryLectureProfessor;

public class LectureProfessorExcellenceFormD{
    private String usernum;
    private String depart;
    private String name;
    private String speechTime;
    private String payment;
    private String performance;

    public LectureProfessorExcellenceFormD(String usernum, String depart, String name, String speechTime, String payment, String performance){
        this.usernum = usernum;
        this.depart = depart;
        this.name = name;
        this.speechTime = speechTime;
        this.payment = payment;
        this.performance = performance;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeechTime() {
        return speechTime;
    }

    public void setSpeechTime(String speechTime) {
        this.speechTime = speechTime;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    public String toString() {
        return "LectureProfessorExcellenceFormD{" +
                "usernum='" + usernum + '\'' +
                ", depart='" + depart + '\'' +
                ", name='" + name + '\'' +
                ", speechTime='" + speechTime + '\'' +
                ", payment='" + payment + '\'' +
                ", performance='" + performance + '\'' +
                '}';
    }
}
