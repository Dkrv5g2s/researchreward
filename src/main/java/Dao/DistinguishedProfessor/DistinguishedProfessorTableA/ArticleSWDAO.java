package Dao.DistinguishedProfessor.DistinguishedProfessorTableA;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.ArticleSW;

public interface ArticleSWDAO {
    void save(ArticleSW object,String projectID);
    ArticleSW show(String projectID);
}