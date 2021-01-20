package Dao.DistinguishedProfessor.DistinguishedProfessorTableA;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.OtherData;

public interface OtherDataDAO {
    void save(OtherData object,String projectID);
    OtherData show(String projectID);
}