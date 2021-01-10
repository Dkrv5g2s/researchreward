package Dao.SpecialOutstandingResearcherApplication;

import Bean.ExcellentResearcher.Education;

public interface SpecialOutstandingResearcherApplicaiotnDAO {
    void save(Education object);
    Education get(String userNumber);
}
