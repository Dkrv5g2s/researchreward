package Dao.ExcellentResearcher;


import Bean.ExcellentResearcher.PersonalInformation.MOSTPlan;

public interface MOSTPlanDAO {
    void save(MOSTPlan object);
    MOSTPlan get(int projectId);
}
