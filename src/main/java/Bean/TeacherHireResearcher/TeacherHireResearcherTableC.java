package Bean.TeacherHireResearcher;

public class TeacherHireResearcherTableC {
    private int rewardProjectId;
    private String numOfPerformancePeriod;

    public TeacherHireResearcherTableC(int rewardProjectId, String numOfPerformancePeriod) {
        this.rewardProjectId = rewardProjectId;
        this.numOfPerformancePeriod = numOfPerformancePeriod;
    }

    public TeacherHireResearcherTableC() {
    }

    public int getRewardProjectId() {
        return rewardProjectId;
    }

    public void setRewardProjectId(int rewardProjectId) {
        this.rewardProjectId = rewardProjectId;
    }

    public String getNumOfPerformancePeriod() {
        return numOfPerformancePeriod;
    }

    public void setNumOfPerformancePeriod(String numOfPerformancePeriod) {
        this.numOfPerformancePeriod = numOfPerformancePeriod;
    }
}
