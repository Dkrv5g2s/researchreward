package Bean.Award;

import java.sql.Date;

public class Award {
    private String awardName;
    private Date startTime;
    private Date endTime;

    public Award(String awardName, Date startTime, Date endTime) {
        this.awardName = awardName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAwardNameWithApplicationPeriod(){
        return this.getAwardName() + "("+ this.getStartTime() + "～" + this.getEndTime() + ")";
    }
}
