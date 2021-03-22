package Bean.Admin;

import java.sql.Date;

public class SpecialOutstandingResearcherSetting {

    private Date mostStart = new Date(System.currentTimeMillis());
    private Date mostEnd = new Date(System.currentTimeMillis());
    private Date seniority = new Date(System.currentTimeMillis());
    private int year;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getMostStart() {
        return mostStart;
    }

    public void setMostStart(Date mostStart) {
        this.mostStart = mostStart;
    }

    public Date getMostEnd() {
        return mostEnd;
    }

    public void setMostEnd(Date mostEnd) {
        this.mostEnd = mostEnd;
    }

    public Date getSeniority() {
        return seniority;
    }

    public void setSeniority(Date seniority) {
        this.seniority = seniority;
    }
}
