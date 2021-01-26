package Dao.JuniorResearchInvestigator;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorReviewInformation;

import java.util.List;

public interface JuniorResearchInvestigatorReviewInformationDAO {
	void save(List<JuniorResearchInvestigatorReviewInformation> object, int projectId);
	List<JuniorResearchInvestigatorReviewInformation> show(int projectId);
}
