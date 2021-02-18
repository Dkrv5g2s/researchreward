package Dao.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorApplicationForm;

public interface LectureProfessorApplicationFormDAO {
    void save(LectureProfessorApplicationForm object, String projectID);
    LectureProfessorApplicationForm show(String projectID);
}
