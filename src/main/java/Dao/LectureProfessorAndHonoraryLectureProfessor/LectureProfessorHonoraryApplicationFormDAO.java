package Dao.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorHonoraryApplicationForm;

public interface LectureProfessorHonoraryApplicationFormDAO {
    void save(LectureProfessorHonoraryApplicationForm object, String projectID);
    LectureProfessorHonoraryApplicationForm show(String projectID);
}
