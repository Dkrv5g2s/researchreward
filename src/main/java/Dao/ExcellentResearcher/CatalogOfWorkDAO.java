package Dao.ExcellentResearcher;


import Bean.ExcellentResearcher.CatalogOfWork;

public interface CatalogOfWorkDAO {
    void save(CatalogOfWork object);
    CatalogOfWork get(int projectId);
}
