package Dao.OutstandingResearchAward.JuniorResearchInvestigatorTableA;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.TechProject;

public interface TechProjectDAO {
    void save(TechProject object, String projectID);
    TechProject show(String projectID);
}