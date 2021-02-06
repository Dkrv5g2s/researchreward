package Dao.OutstandingResearchAward.OutstandingResearchAwardTableA;

import Bean.OutstandingResearchAward.OutstandingResearchAwardTableA.OtherData;

public interface OtherDataDAO {
    void save(OtherData object, String projectID);
    OtherData get(String projectID);
}