package Dao.OutstandingResearchAward.OutstandingResearchAwardTableA;

import Bean.OutstandingResearchAward.OutstandingResearchAwardTableA.TechProject;

public interface TechProjectDAO {
    void save(TechProject object, String projectID);
    TechProject get(String projectID);
}