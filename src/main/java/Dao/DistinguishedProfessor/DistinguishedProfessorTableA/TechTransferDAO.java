package Dao.DistinguishedProfessor.DistinguishedProfessorTableA;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.TechTransfer;

public interface TechTransferDAO {
    void save(TechTransfer object,String projectID);
    TechTransfer show(String projectID);
}