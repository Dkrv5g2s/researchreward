package Bean.ExcellentResearcher;

public class RecruitDescription {

    private String recruitReason;
    private String recruitContent;
    private String expect;
    private String analysis;
    private String researchProduction;
    private String award;
    private String other;
    private String contribution;
    private int projectId;

    public RecruitDescription(String recruitReason, String recruitContent, String expect, String analysis, String researchProduction, String award, String other, String contribution, int projectId) {
        this.recruitReason = recruitReason;
        this.recruitContent = recruitContent;
        this.expect = expect;
        this.analysis = analysis;
        this.researchProduction = researchProduction;
        this.award = award;
        this.other = other;
        this.contribution = contribution;
        this.projectId = projectId;
    }

    public RecruitDescription() {

    }

    public String getRecruitReason() {
        return recruitReason;
    }

    public void setRecruitReason(String recruitReason) {
        this.recruitReason = recruitReason;
    }

    public String getRecruitContent() {
        return recruitContent;
    }

    public void setRecruitContent(String recruitContent) {
        this.recruitContent = recruitContent;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getResearchProduction() {
        return researchProduction;
    }

    public void setResearchProduction(String researchProduction) {
        this.researchProduction = researchProduction;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getContribution() {
        return contribution;
    }

    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
