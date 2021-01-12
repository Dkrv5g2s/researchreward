package Bean.ExcellentResearcher;

public class CatalogOfWork {

    private String work;
    private String userNumber;

    public CatalogOfWork(String work, String userNumber) {
        this.work = work;
        this.userNumber = userNumber;
    }

    public CatalogOfWork() {

    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
