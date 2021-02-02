package Dao.OutstandingResearchAward.JuniorResearchInvestigatorTableA;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.ArticleTT;

public interface ArticleTTDAO {
    void save(ArticleTT object, String projectID);
    ArticleTT show(String projectID);
}