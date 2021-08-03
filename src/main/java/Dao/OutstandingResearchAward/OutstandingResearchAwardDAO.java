package Dao.OutstandingResearchAward;


import Bean.OutstandingResearchAward.OutstandingResearchAward;

public interface OutstandingResearchAwardDAO {
	void save(OutstandingResearchAward object, int project_id);
	OutstandingResearchAward get(int project_id);
	void updateDepartmentData(OutstandingResearchAward object);
	void updateCollegeData(OutstandingResearchAward object);
	void updateRADOData(OutstandingResearchAward object);
}
