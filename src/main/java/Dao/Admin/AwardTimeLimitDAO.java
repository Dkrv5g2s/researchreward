package Dao.Admin;

import Bean.Admin.AwardTimeLimit;

public interface AwardTimeLimitDAO {

    void save(AwardTimeLimit object);
    AwardTimeLimit get();
}
