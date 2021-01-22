package Dao.DistinguishedProfessor.DistinguishedProfessorTableA;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.ArticleAB;

public interface ArticleABDAO {
    void save(ArticleAB object,String projectID);
    ArticleAB show(String projectID);
}