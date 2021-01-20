package Bean.ExcellentResearcher.PersonalInformation;

import java.util.Date;

public class MOSTPlan {
    private String planName;
    private String planNumber;
    private Date startTime;
    private Date lastTime;
    private int projectId;

    public MOSTPlan() {

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public MOSTPlan(String planName, String planNumber, Date startTime, Date lastTime, int projectId) {
        this.planName = planName;
        this.planNumber = planNumber;
        this.startTime = startTime;
        this.lastTime = lastTime;
        this.projectId = projectId;
    }



    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(String planNumber) {
        this.planNumber = planNumber;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}
