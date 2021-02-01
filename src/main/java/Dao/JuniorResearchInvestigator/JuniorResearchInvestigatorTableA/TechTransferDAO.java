package Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.TechTransfer;

public interface TechTransferDAO {
    void save(TechTransfer object, String projectID);
    TechTransfer show(String projectID);
}