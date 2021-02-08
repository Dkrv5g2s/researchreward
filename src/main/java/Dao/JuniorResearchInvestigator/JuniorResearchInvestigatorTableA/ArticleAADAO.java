package Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA;


import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.ArticleAA;

public interface ArticleAADAO {
    void save(ArticleAA object, String projectID);
    ArticleAA show(String projectID);
}
