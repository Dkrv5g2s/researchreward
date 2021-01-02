package Dao.ExcellentResearcher;

import Bean.ExcellentResearcher.Education;
import Bean.ExcellentResearcher.Experiment;

public interface EducationDAO {
    void save(Education object);
    Education get(String userNumber);
}
