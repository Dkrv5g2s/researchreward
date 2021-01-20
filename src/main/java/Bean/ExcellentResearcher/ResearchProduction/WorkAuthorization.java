package Bean.ExcellentResearcher.ResearchProduction;

public class WorkAuthorization {
    private String agent;
    private String author;
    private String authorizationClass;
    private String copyrightOwner;
    private String mstPlanNumber;
    private String workName;
    private String projectId;

    public WorkAuthorization(String agent, String author, String authorizationClass, String copyrightOwner, String mstPlanNumber, String patentClass, String projectId) {
        this.agent = agent;
        this.author = author;
        this.authorizationClass = authorizationClass;
        this.copyrightOwner = copyrightOwner;
        this.mstPlanNumber = mstPlanNumber;
        this.workName = patentClass;
        this.projectId = projectId;
    }

    public WorkAuthorization() {

    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorizationClass() {
        return authorizationClass;
    }

    public void setAuthorizationClass(String authorizationClass) {
        this.authorizationClass = authorizationClass;
    }

    public String getCopyrightOwner() {
        return copyrightOwner;
    }

    public void setCopyrightOwner(String copyrightOwner) {
        this.copyrightOwner = copyrightOwner;
    }

    public String getMstPlanNumber() {
        return mstPlanNumber;
    }

    public void setMstPlanNumber(String mstPlanNumber) {
        this.mstPlanNumber = mstPlanNumber;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getprojectId() {
        return projectId;
    }

    public void setprojectId(String projectId) {
        this.projectId = projectId;
    }
}
