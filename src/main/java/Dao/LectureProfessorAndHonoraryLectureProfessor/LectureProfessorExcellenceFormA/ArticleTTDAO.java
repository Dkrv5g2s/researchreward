package Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA.ArticleTT;

public interface ArticleTTDAO {
    void save(ArticleTT object, String projectID);
    ArticleTT show(String projectID);
}