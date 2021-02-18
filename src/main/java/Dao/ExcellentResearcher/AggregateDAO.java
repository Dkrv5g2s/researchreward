package Dao.ExcellentResearcher;

import Bean.ExcellentResearcher.ResearchProduction.Second.Aggregate;

public interface AggregateDAO {

    public void save(Aggregate object);
    public Aggregate get(int projectId);
}
