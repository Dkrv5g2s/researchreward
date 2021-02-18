package Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA.ArticleSW;

public interface ArticleSWDAO {
    void save(ArticleSW object, String projectID);
    ArticleSW show(String projectID);
}