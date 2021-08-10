package Dao.DistinguishedProfessor;

import Bean.DistinguishedProfessor.DistinguishedProfessorForm;

public interface DistinguishedProfessorFormDAO {
    void save(DistinguishedProfessorForm object,String projectID);
    DistinguishedProfessorForm show(String projectID);

    void saveDepartmentData(DistinguishedProfessorForm object, String projectID);

    void saveCollegeData(DistinguishedProfessorForm object, String projectID);

    void saveRADOData(DistinguishedProfessorForm object, String projectID);
}
