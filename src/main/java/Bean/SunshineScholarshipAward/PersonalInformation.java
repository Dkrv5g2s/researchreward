package Bean.SunshineScholarshipAward;

public class PersonalInformation {
    private String chinese_name;
    private String english_name;
    private String national_ID_number;
    private String department;
    private String titles;
    private String levels;
    private String resigned_time;
    private String extension_number;
    private String cellphone_number;
    private String email_address;
    private int projectId;

    public PersonalInformation(String chinese_name,
                               String english_name,
                               String national_ID_number,
                               String department,
                               String titles,
                               String levels,
                               String resigned_time,
                               String extension_number,
                               String cellphone_number,
                               String email_address,
                               int projectId) {
        this.chinese_name = chinese_name;
        this.english_name = english_name;
        this.national_ID_number = national_ID_number;
        this.department = department;
        this.titles = titles;
        this.levels = levels;
        this.resigned_time = resigned_time;
        this.extension_number = extension_number;
        this.cellphone_number = cellphone_number;
        this.email_address = email_address;
        this.projectId = projectId;
    }
    public PersonalInformation() {

    }


    public String getChinese_name() {
        return chinese_name;
    }

    public void setChinese_name(String chinese_name) {
        this.chinese_name = chinese_name;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public String getNational_ID_number() {
        return national_ID_number;
    }

    public void setNational_ID_number(String national_ID_number) {
        this.national_ID_number = national_ID_number;
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

    public String getResigned_time() {
        return resigned_time;
    }

    public void setResigned_time(String resigned_time) {
        this.resigned_time = resigned_time;
    }

    public String getExtension_number() {
        return extension_number;
    }

    public void setExtension_number(String extension_number) {
        this.extension_number = extension_number;
    }

    public String getCellphone_number() {
        return cellphone_number;
    }

    public void setCellphone_number(String cellphone_number) {
        this.cellphone_number = cellphone_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
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
                "chinese_name='" + chinese_name + '\'' +
                ", english_name='" + english_name + '\'' +
                ", national_ID_number='" + national_ID_number + '\'' +
                ", department='" + department + '\'' +
                ", titles='" + titles + '\'' +
                ", levels='" + levels + '\'' +
                ", resigned_time='" + resigned_time + '\'' +
                ", extension_number='" + extension_number + '\'' +
                ", cellphone_number='" + cellphone_number + '\'' +
                ", email_address='" + email_address + '\'' +
                ", projectId='" + projectId + '\'' +
                '}';
    }



}
