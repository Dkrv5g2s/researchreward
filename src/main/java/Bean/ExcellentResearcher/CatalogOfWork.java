package Bean.ExcellentResearcher;

public class CatalogOfWork {

    private String work;
    private int projectId;

    public CatalogOfWork(String work, int projectId) {
        this.work = work;
        this.projectId = projectId;
    }

    public CatalogOfWork() {

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
