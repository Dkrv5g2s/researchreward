package Bean.ExcellentResearcher.PersonalInformation;

public class Experiment {
    private String serviceOrganization;
    private String serviceDepartment;
    private String title;
    private String year;
    private String month;
    private String userNumber;

    public Experiment(String serviceOrganization, String serviceDepartment, String title, String year, String month, String userNumber) {
        this.serviceOrganization = serviceOrganization;
        this.serviceDepartment = serviceDepartment;
        this.title = title;
        this.year = year;
        this.month = month;
        this.userNumber = userNumber;
    }

    public Experiment() {

    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getServiceOrganization() {
        return serviceOrganization;
    }

    public void setServiceOrganization(String serviceOrganization) {
        this.serviceOrganization = serviceOrganization;
    }

    public String getServiceDepartment() {
        return serviceDepartment;
    }

    public void setServiceDepartment(String serviceDepartment) {
        this.serviceDepartment = serviceDepartment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
