package Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA.ArticleAB;

public interface ArticleABDAO {
    void save(ArticleAB object, String projectID);
    ArticleAB show(String projectID);
}