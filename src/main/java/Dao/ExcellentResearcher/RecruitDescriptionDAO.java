package Dao.ExcellentResearcher;

import Bean.ExcellentResearcher.RecruitDescription;

public interface RecruitDescriptionDAO {
    void save(RecruitDescription object);
    RecruitDescription get(String userNumber);
}
