package Dao.ExcellentResearcher;


import Bean.ExcellentResearcher.Seniority;

public interface SeniorityDAO {
    void save(Seniority object);
    Seniority get(String userNumber);
}
