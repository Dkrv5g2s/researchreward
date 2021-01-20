package Bean.ExcellentResearcher.PersonalInformation;

import java.util.Date;

public class MOSTPlan {
    private String planName;
    private String planNumber;
    private Date startTime;
    private Date lastTime;
    private String projectId;

    public MOSTPlan() {

    }

    public String getprojectId() {
        return projectId;
    }

    public void setprojectId(String projectId) {
        this.projectId = projectId;
    }

    public MOSTPlan(String planName, String planNumber, Date startTime, Date lastTime, String projectId) {
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
