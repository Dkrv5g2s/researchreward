package Dao.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormB;

import java.util.List;

public interface LectureProfessorExcellenceFormBDAO {
    void save(List<LectureProfessorExcellenceFormB> object, String userNumber, String projectID);
    List<LectureProfessorExcellenceFormB> show(String projectID);
}
