package Dao.OutstandingResearchAward.OutstandingResearchAwardTableA;

import Bean.OutstandingResearchAward.OutstandingResearchAwardTableA.TechTransfer;

public interface TechTransferDAO {
    void save(TechTransfer object, String projectID);
    TechTransfer get(String projectID);
}