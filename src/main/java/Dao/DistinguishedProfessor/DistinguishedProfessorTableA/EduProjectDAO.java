package Dao.DistinguishedProfessor.DistinguishedProfessorTableA;

import Bean.DistinguishedProfessor.DistinguishedProfessorTableA.EduProject;

public interface EduProjectDAO {
    void save(EduProject object,String projectID);
    EduProject show(String projectID);
}