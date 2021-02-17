package Bean.ExcellentResearcher.ResearchProduction.Second;


import java.util.ArrayList;
import java.util.List;

public class Aggregate {

    private List<Plan> planList = new ArrayList<>();
    private List<Paper> paperList = new ArrayList<>();
    private List<Book> bookList = new ArrayList<>();
    private List<Reward> rewardList = new ArrayList<>();
    private int projectId;

    public void addPlan(Plan object){
        this.planList.add(object);
    }
    public void addPaper(Paper object){
        this.paperList.add(object);
    }
    public void addBook(Book object){
        this.bookList.add(object);
    }
    public void addReward(Reward object){
        this.rewardList.add(object);
    }

    public List<Plan> getPlanList() {
        return planList;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Reward> getRewardList() {
        return rewardList;
    }
}
