package Dao.DistinguishedProfessor.DistinguishedProfessorTableA;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.ArticleAA;

public interface ArticleAADAO {
    void save(ArticleAA object,String projectID);
    ArticleAA show(String projectID);
}
