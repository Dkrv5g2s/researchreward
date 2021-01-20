package Dao.DistinguishedProfessor.DistinguishedProfessorTableA;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.CoopProject;

public interface CoopProjectDAO {
    void save(CoopProject object,String projectID);
    CoopProject show(String projectID);
}