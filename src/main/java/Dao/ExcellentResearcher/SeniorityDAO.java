package Dao.ExcellentResearcher;


import Bean.ExcellentResearcher.PersonalInformation.Seniority;

public interface SeniorityDAO {
    void save(Seniority object);
    Seniority get(String userNumber);
}
