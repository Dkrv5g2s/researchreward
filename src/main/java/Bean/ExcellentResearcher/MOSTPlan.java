package Bean.ExcellentResearcher;

import java.util.Date;

public class MOSTPlan {
    private String planName;
    private String planNumber;
    private Date startTime;
    private Date lastTime;
    private String userNumber;

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public MOSTPlan(String planName, String planNumber, Date startTime, Date lastTime, String userNumber) {
        this.planName = planName;
        this.planNumber = planNumber;
        this.startTime = startTime;
        this.lastTime = lastTime;
        this.userNumber = userNumber;
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
