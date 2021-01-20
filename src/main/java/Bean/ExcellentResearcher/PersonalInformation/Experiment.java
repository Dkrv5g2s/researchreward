package Bean.ExcellentResearcher.PersonalInformation;

public class Experiment {
    private String serviceOrganization;
    private String serviceDepartment;
    private String pastTitle;
    private String pastYear;
    private String pastMonth;
    private int projectId;

    public Experiment(String serviceOrganization, String serviceDepartment, String pastTitle, String pastYear, String pastMonth, int projectId) {
        this.serviceOrganization = serviceOrganization;
        this.serviceDepartment = serviceDepartment;
        this.pastTitle = pastTitle;
        this.pastYear = pastYear;
        this.pastMonth = pastMonth;
        this.projectId = projectId;
    }

    public Experiment() {

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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

    public String getPastTitle() {
        return pastTitle;
    }

    public void setPastTitle(String pastTitle) {
        this.pastTitle = pastTitle;
    }

    public String getPastYear() {
        return pastYear;
    }

    public void setPastYear(String pastYear) {
        this.pastYear = pastYear;
    }

    public String getPastMonth() {
        return pastMonth;
    }

    public void setPastMonth(String pastMonth) {
        this.pastMonth = pastMonth;
    }
}
