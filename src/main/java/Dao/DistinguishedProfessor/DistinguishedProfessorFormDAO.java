package Dao.DistinguishedProfessor;

import Bean.DistinguishedProfessor.DistinguishedProfessorForm;

public interface DistinguishedProfessorFormDAO {
    void save(DistinguishedProfessorForm object);
    DistinguishedProfessorForm show(String userNumber);
    DistinguishedProfessorForm get(String userNumber);
}
