package Bean.ExcellentResearcher.PersonalInformation;

public class Seniority {
    private String year;
    private String month;
    private String userNumber;

    public Seniority(String year, String month, String userNumber) {
        this.year = year;
        this.month = month;
        this.userNumber = userNumber;
    }

    public Seniority() {

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
