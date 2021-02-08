package Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA.CoopProject;

public interface CoopProjectDAO {
    void save(CoopProject object, String projectID);
    CoopProject show(String projectID);
}