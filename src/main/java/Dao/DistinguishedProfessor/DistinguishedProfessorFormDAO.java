package Dao.DistinguishedProfessor;

import Bean.DistinguishedProfessor.DistinguishedProfessorForm;

public interface DistinguishedProfessorFormDAO {
    void save(DistinguishedProfessorForm object,String projectID);
    DistinguishedProfessorForm show(String projectID);
}
