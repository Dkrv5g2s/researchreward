package Dao.ExcellentResearcher;

import Bean.ExcellentResearcher.Experiment;

public interface ExperimentDAO {
    void save(Experiment object);
    Experiment get(String userNumber);
}
