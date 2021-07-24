package Dao.JuniorResearchInvestigator;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigator;

public interface JuniorResearchInvestigatorDAO {
	void save(JuniorResearchInvestigator juniorResearchInvestigator);
	JuniorResearchInvestigator show(int projectId);
	void updateDepartmentData(JuniorResearchInvestigator juniorResearchInvestigator);
	void updateCollegeData(JuniorResearchInvestigator juniorResearchInvestigator);
	void updateRADOData(JuniorResearchInvestigator juniorResearchInvestigator);
}
