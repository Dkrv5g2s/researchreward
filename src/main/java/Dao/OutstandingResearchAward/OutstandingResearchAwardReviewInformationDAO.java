package Dao.OutstandingResearchAward;

import Bean.OutstandingResearchAward.OutstandingResearchAwardReviewInformation;

import java.util.List;

public interface OutstandingResearchAwardReviewInformationDAO {
	void save(List<OutstandingResearchAwardReviewInformation> object, int projectId);
	List<OutstandingResearchAwardReviewInformation> get(int projectId);
}
