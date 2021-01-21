package Dao.DistinguishedProfessor.DistinguishedProfessorTableA;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.TechProject;

public interface TechProjectDAO {
    void save(TechProject object,String projectID);
    TechProject show(String projectID);
}