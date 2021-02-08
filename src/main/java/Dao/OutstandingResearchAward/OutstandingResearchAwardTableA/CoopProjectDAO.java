package Dao.OutstandingResearchAward.OutstandingResearchAwardTableA;

import Bean.OutstandingResearchAward.OutstandingResearchAwardTableA.CoopProject;

public interface CoopProjectDAO {
    void save(CoopProject object, String projectID);
    CoopProject get(String projectID);
}