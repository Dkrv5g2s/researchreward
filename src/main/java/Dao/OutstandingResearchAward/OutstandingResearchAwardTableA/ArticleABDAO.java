package Dao.OutstandingResearchAward.OutstandingResearchAwardTableA;

import Bean.OutstandingResearchAward.OutstandingResearchAwardTableA.ArticleAB;

public interface ArticleABDAO {
    void save(ArticleAB object, String projectID);
    ArticleAB get(String projectID);
}