package Dao.ExcellentResearcher;

import Bean.ExcellentResearcher.PersonalInformation.Education;

public interface EducationDAO {
    void save(Education object);
    Education get(String projectId);
}
