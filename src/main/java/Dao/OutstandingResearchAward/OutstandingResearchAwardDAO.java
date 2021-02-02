package Dao.OutstandingResearchAward;

import Bean.OutstandingResearchAward.OutstandingResearchAward;

public interface OutstandingResearchAwardDAO {
	void save(OutstandingResearchAward object, int project_id);
	OutstandingResearchAward get(int project_id);
}
