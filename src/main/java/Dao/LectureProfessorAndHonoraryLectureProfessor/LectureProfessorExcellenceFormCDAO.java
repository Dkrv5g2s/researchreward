package Dao.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormC;

public interface LectureProfessorExcellenceFormCDAO {
    void save(LectureProfessorExcellenceFormC object, String projectID);
    LectureProfessorExcellenceFormC show(String projectID);

}
