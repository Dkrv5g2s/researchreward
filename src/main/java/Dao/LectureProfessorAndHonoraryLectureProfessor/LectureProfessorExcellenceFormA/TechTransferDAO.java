package Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA.TechTransfer;

public interface TechTransferDAO {
    void save(TechTransfer object, String projectID);
    TechTransfer show(String projectID);
}