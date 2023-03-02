package Bean.Admin;

import java.sql.Date;

public class SpecialOutstandingResearcherSetting {

    private Date mostStart = new Date(System.currentTimeMillis());
    private Date mostEnd = new Date(System.currentTimeMillis());
    private Date seniority = new Date(System.currentTimeMillis());
    private int year;
    private int year_y;
    private int echelon_y;

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

    public int getYearY() { return year_y; }

    public void setYearY(int year_y) { this.year_y = year_y; }

    public int getEchelonY() { return echelon_y; }

    public void setEchelonY(int echelon_y) { this.echelon_y = echelon_y; }
}
