package Dao.ExcellentResearcher;


import Bean.ExcellentResearcher.ResearchProduction.ResearchProduction;

public interface ResearchProductionDAO {
    void save(ResearchProduction object);
    ResearchProduction get(String userNumber);
}
