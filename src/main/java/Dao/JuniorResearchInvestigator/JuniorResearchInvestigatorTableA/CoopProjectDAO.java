package Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.CoopProject;

public interface CoopProjectDAO {
    void save(CoopProject object, String projectID);
    CoopProject show(String projectID);
}