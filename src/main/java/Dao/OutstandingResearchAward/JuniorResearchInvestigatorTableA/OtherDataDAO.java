package Dao.OutstandingResearchAward.JuniorResearchInvestigatorTableA;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.OtherData;

public interface OtherDataDAO {
    void save(OtherData object, String projectID);
    OtherData show(String projectID);
}