package Dao.DistinguishedProfessor.DistinguishedProfessorTableA;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.ArticleTT;

public interface ArticleTTDAO {
    void save(ArticleTT object,String projectID);
    ArticleTT show(String projectID);
}