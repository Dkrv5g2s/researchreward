package Dao.JuniorResearchInvestigator;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigator;

public interface JuniorResearchInvestigatorDAO {
	void save(JuniorResearchInvestigator object, int projectId);
	JuniorResearchInvestigator show(int projectId);
}
