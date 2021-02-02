package Dao.OutstandingResearchAward.JuniorResearchInvestigatorTableA;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.ArticleAB;

public interface ArticleABDAO {
    void save(ArticleAB object, String projectID);
    ArticleAB show(String projectID);
}