package Dao.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormD;

public interface LectureProfessorExcellenceFormDDAO {
    void save(LectureProfessorExcellenceFormD object, String projectID);
    LectureProfessorExcellenceFormD show(String projectID);

}
