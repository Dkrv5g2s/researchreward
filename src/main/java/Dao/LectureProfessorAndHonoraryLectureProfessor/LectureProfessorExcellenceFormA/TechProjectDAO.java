package Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA.TechProject;

public interface TechProjectDAO {
    void save(TechProject object, String projectID);
    TechProject show(String projectID);
}