package Dao.OutstandingResearchAward.JuniorResearchInvestigatorTableA;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.ArticleSW;

public interface ArticleSWDAO {
    void save(ArticleSW object, String projectID);
    ArticleSW show(String projectID);
}
