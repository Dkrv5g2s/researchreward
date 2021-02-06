package Dao.OutstandingResearchAward.OutstandingResearchAwardTableA;

import Bean.OutstandingResearchAward.OutstandingResearchAwardTableA.ArticleTT;

public interface ArticleTTDAO {
    void save(ArticleTT object, String projectID);
    ArticleTT get(String projectID);
}