package Bean.LectureProfessorAndHonoraryLectureProfessor;

public class LectureProfessorExcellenceFormC {
    private String usernum;
    private String recommendationReason;

    public LectureProfessorExcellenceFormC(String usernum, String recommendationReason){
        this.usernum = usernum;
        this.recommendationReason = recommendationReason;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum;
    }

    public String getRecommendationReason() {
        return recommendationReason;
    }

    public void setRecommendationReason(String recommendationReason) {
        this.recommendationReason = recommendationReason;
    }

    @Override
    public String toString() {
        return "LectureProfessorExcellenceFormC{" +
                "usernum='" + usernum + '\'' +
                ", recommendationReason='" + recommendationReason + '\'' +
                '}';
    }
}
