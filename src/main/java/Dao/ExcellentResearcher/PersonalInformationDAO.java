package Dao.ExcellentResearcher;

import Bean.ExcellentResearcher.PersonalInformation.PersonalInformation;

public interface PersonalInformationDAO {
    void save(PersonalInformation object);
    PersonalInformation get(int projectId);
    void updateDepartmentReviewData(PersonalInformation object);
    void updateCollegeReviewData(PersonalInformation object);
}
