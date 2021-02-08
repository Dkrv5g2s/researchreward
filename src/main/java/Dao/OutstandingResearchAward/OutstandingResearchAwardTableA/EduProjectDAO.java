package Dao.OutstandingResearchAward.OutstandingResearchAwardTableA;

import Bean.OutstandingResearchAward.OutstandingResearchAwardTableA.EduProject;

public interface EduProjectDAO {
    void save(EduProject object, String projectID);
    EduProject get(String projectID);
}