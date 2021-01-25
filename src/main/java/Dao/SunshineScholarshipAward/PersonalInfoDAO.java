package Dao.SunshineScholarshipAward;

import Bean.SunshineScholarshipAward.PersonalInformation;

public interface PersonalInfoDAO {
    void save(PersonalInformation object);
    PersonalInformation get(int projectId);
}
