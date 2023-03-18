package Bean.SolicitSpecialOutstandingResearcher;

public class SolicitResearchProduction {
    private int project_id;
    private boolean applicant_declaration;

    public SolicitResearchProduction() {
    }

    public SolicitResearchProduction(int project_id) {
        this.project_id = project_id;
    }

    public SolicitResearchProduction(int project_id, boolean applicant_declaration) {
        this.project_id = project_id;
        this.applicant_declaration = applicant_declaration;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public boolean getApplicant_declaration() {
        return applicant_declaration;
    }

    public void setApplicant_declaration(boolean applicant_declaration) {
        this.applicant_declaration = applicant_declaration;
    }
}
