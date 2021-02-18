package Dao.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorAppDocInstructions;
import java.util.List;

public interface LectureProfessorAppDocInstructionsDAO {
    void save(List<LectureProfessorAppDocInstructions> object, String userNumber, String projectID);
    List<LectureProfessorAppDocInstructions> show(String projectID);
}
