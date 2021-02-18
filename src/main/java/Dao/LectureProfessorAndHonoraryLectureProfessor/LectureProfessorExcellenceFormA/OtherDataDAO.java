package Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA.OtherData;

public interface OtherDataDAO {
    void save(OtherData object, String projectID);
    OtherData show(String projectID);
}