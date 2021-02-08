package Dao.OutstandingResearchAward.OutstandingResearchAwardTableA;


import Bean.OutstandingResearchAward.OutstandingResearchAwardTableA.ArticleAA;

public interface ArticleAADAO {
    void save(ArticleAA object, String projectID);
    ArticleAA get(String projectID);
}
