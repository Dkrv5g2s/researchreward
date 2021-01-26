package Dao.DistinguishedProfessor;

import java.util.List;

import Bean.DistinguishedProfessor.DistinguishedProfessorAppDocInstructions;

public interface DistinguishedProfessorAppDocInstructionsDAO {
	void save(List<DistinguishedProfessorAppDocInstructions> object, String userNumber,String projectID);
	List<DistinguishedProfessorAppDocInstructions> show(String projectID);
}
