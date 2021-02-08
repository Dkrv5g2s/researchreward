package Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA.ArticleAA;

public interface ArticleAADAO {
    void save(ArticleAA object, String projectID);
    ArticleAA show(String projectID);
}
