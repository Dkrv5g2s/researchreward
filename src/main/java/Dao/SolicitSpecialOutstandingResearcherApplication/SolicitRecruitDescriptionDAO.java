package Dao.SolicitSpecialOutstandingResearcherApplication;

import Bean.SolicitSpecialOutstandingResearcher.SolicitRecruitDescription;

public interface SolicitRecruitDescriptionDAO {
    public SolicitRecruitDescription query(int project_id);
    public void update(SolicitRecruitDescription solicitRecruitDescription);
}
