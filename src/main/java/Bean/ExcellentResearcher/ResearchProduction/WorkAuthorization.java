package Bean.ExcellentResearcher.ResearchProduction;

public class WorkAuthorization {
    private String agent;
    private String author;
    private String authorizationClass;
    private String copyrightOwner;
    private String mstPlanNumber;
    private String workName;
    private String userNumber;

    public WorkAuthorization(String agent, String author, String authorizationClass, String copyrightOwner, String mstPlanNumber, String patentClass, String userNumber) {
        this.agent = agent;
        this.author = author;
        this.authorizationClass = authorizationClass;
        this.copyrightOwner = copyrightOwner;
        this.mstPlanNumber = mstPlanNumber;
        this.workName = patentClass;
        this.userNumber = userNumber;
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

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
