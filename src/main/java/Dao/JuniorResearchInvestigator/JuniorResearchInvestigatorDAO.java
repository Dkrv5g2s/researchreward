package Dao.JuniorResearchInvestigator;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigator;

public interface JuniorResearchInvestigatorDAO {
	void save(JuniorResearchInvestigator object, int project_id);
	JuniorResearchInvestigator show(int project_id);
}
