package Dao.OutstandingResearchAward.JuniorResearchInvestigatorTableA;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.EduProject;

public interface EduProjectDAO {
    void save(EduProject object, String projectID);
    EduProject show(String projectID);
}