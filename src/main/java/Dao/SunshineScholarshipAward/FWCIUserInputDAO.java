package Dao.SunshineScholarshipAward;

import Bean.SunshineScholarshipAward.FWCIUserInputInfomation;

public interface FWCIUserInputDAO {
    void save(FWCIUserInputInfomation object);
    FWCIUserInputInfomation get(int projectId);
}
