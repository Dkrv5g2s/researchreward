package Bean.SolicitSpecialOutstandingResearcher;

public class SolicitRecruitDescription {
    private int project_id;
    private String application_reason;

    public SolicitRecruitDescription() {
    }

    public SolicitRecruitDescription(int project_id) {
        this.project_id = project_id;
    }

    public SolicitRecruitDescription(int project_id, String application_reason) {
        this.project_id = project_id;
        this.application_reason = application_reason;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getApplication_reason() {
        return application_reason;
    }

    public void setApplication_reason(String application_reason) {
        this.application_reason = application_reason;
    }
}
