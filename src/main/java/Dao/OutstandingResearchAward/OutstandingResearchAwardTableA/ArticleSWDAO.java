package Dao.OutstandingResearchAward.OutstandingResearchAwardTableA;

import Bean.OutstandingResearchAward.OutstandingResearchAwardTableA.ArticleSW;

public interface ArticleSWDAO {
    void save(ArticleSW object, String projectID);
    ArticleSW get(String projectID);
}
