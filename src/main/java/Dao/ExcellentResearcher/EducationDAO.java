package Dao.ExcellentResearcher;

import Bean.ExcellentResearcher.Education;

public interface EducationDAO {
    void save(Education object);
    Education get(String userNumber);
}
