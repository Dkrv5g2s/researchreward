package Bean.SunshineScholarshipAward;

public class PersonalInformation {

    private String chineseName;
    private String englishName;
    private String nationalIDNumber;
    private String department;
    private String titles;
    private String levels;
    private String resignedTime;
    private String extensionNumber;
    private String cellphoneNumber;
    private String emailAddress;
    private int projectId;


    public PersonalInformation(String chineseName, String englishName, String nationalIDNumber, String department, String titles, String levels, String resignedTime, String extensionNumber, String cellphoneNumber, String emailAddress, int projectId) {
        this.chineseName = chineseName;
        this.englishName = englishName;
        this.nationalIDNumber = nationalIDNumber;
        this.department = department;
        this.titles = titles;
        this.levels = levels;
        this.resignedTime = resignedTime;
        this.extensionNumber = extensionNumber;
        this.cellphoneNumber = cellphoneNumber;
        this.emailAddress = emailAddress;
        this.projectId = projectId;
    }

    public PersonalInformation() {

    }


    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getNationalIDNumber() {
        return nationalIDNumber;
    }

    public void setNationalIDNumber(String nationalIDNumber) {
        this.nationalIDNumber = nationalIDNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getLevels() {
        return levels;
    }

    public void setLevels(String levels) {
        this.levels = levels;
    }

    public String getResignedTime() {
        return this.resignedTime;
    }

    public void setResignedTime(String resignedTime) {
        this.resignedTime = resignedTime;
    }

    public String getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(String extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "chineseName='" + chineseName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", nationalIDNumber='" + nationalIDNumber + '\'' +
                ", department='" + department + '\'' +
                ", titles='" + titles + '\'' +
                ", levels='" + levels + '\'' +
                ", resignedTime='" + resignedTime + '\'' +
                ", extensionNumber='" + extensionNumber + '\'' +
                ", cellphoneNumber='" + cellphoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", projectId='" + projectId + '\'' +
                '}';
    }

}
