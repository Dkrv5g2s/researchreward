package Dao.ExcellentResearcher;


import Bean.ExcellentResearcher.MOSTPlan;

public interface MOSTPlanDAO {
    void save(MOSTPlan object);
    MOSTPlan get(String userNumber);
}
