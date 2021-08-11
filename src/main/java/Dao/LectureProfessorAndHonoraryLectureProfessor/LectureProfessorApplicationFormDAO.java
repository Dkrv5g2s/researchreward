package Dao.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorApplicationForm;
import Bean.OutstandingResearchAward.OutstandingResearchAward;

public interface LectureProfessorApplicationFormDAO {
    void save(LectureProfessorApplicationForm object, String projectID);
    LectureProfessorApplicationForm show(String projectID);
    void updateDepartmentData(LectureProfessorApplicationForm object);
    void updateCollegeData(LectureProfessorApplicationForm object);
    void updateRADOData(LectureProfessorApplicationForm object);
}
