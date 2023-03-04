package Dao.SolicitSpecialOutstandingResearcherApplication;


import Bean.SolicitSpecialOutstandingResearcher.SolicitSpecialOutstandingResearcherForm;

public interface SolicitSpecialOutstandingResearcherApplicationDAO {
    public SolicitSpecialOutstandingResearcherForm query(int project_id);
    public void update(SolicitSpecialOutstandingResearcherForm solicitSpecialOutstandingResearcherForm);
}
