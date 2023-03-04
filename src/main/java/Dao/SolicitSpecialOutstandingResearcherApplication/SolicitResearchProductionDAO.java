package Dao.SolicitSpecialOutstandingResearcherApplication;

import Bean.SolicitSpecialOutstandingResearcher.SolicitResearchProduction;

public interface SolicitResearchProductionDAO {
    public SolicitResearchProduction query(int project_id);
    public void update(SolicitResearchProduction solicitResearchProduction);
}
