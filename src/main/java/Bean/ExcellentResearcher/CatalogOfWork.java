package Bean.ExcellentResearcher;

public class CatalogOfWork {

    private String work;
    private String projectId;

    public CatalogOfWork(String work, String projectId) {
        this.work = work;
        this.projectId = projectId;
    }

    public CatalogOfWork() {

    }

    public String getprojectId() {
        return projectId;
    }

    public void setprojectId(String projectId) {
        this.projectId = projectId;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
