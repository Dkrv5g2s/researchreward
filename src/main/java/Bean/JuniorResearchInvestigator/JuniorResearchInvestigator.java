package Bean.JuniorResearchInvestigator;

import java.sql.Date;

public class JuniorResearchInvestigator {
    private int project_id;
    private int user_number;
    private String user_name;
    private String applicant_title;
    private String department;
    private Date birth_date;
    private Date employment_date;
    private String identity_number;
    private String extension_number;
    private String cellphone_number;
    private String recommended_reason;

    public JuniorResearchInvestigator(int project_id, int user_number, String user_name, String applicant_title, String department, Date birth_date, String identity_number, Date employment_date, String extension_number, String cellphone_number, String recommended_reason) {
        this.project_id = project_id;
        this.user_number = user_number;
        this.user_name = user_name;
        this.applicant_title = applicant_title;
        this.department = department;
        this.birth_date = birth_date;
        this.identity_number = identity_number;
        this.employment_date = employment_date;
        this.extension_number = extension_number;
        this.cellphone_number = cellphone_number;
        this.recommended_reason = recommended_reason;
    }

    public JuniorResearchInvestigator() {}


    public int getProjectId() { return project_id; }
    public void setProjectId(int project_id) {
        this.project_id = project_id;
    }

    public int getUserNumber() {
        return user_number;
    }
    public void setUserNumber(int user_number) {
        this.user_number = user_number;
    }

    public String getUserName() {
        return user_name;
    }
    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public String getApplicantTitle() {
        return applicant_title;
    }
    public void setApplicantTitle(String applicant_title) {
        this.applicant_title = applicant_title;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getBirthDate() {
        return birth_date;
    }
    public void setBirthDate(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getIdentityNumber() {
        return identity_number;
    }
    public void setIdentityNumber(String identity_number) {
        this.identity_number = identity_number;
    }

    public Date getEmploymentDate() {
        return employment_date;
    }
    public void setEmploymentDate(Date employment_date) {
        this.employment_date = employment_date;
    }

    public String getExtensionNumber() {
        return extension_number;
    }
    public void setExtensionNumber(String extension_number) {
        this.extension_number = extension_number;
    }

    public String getCellphoneNumber() {
        return cellphone_number;
    }
    public void setCellphoneNumber(String cellphone_number) {
        this.cellphone_number = cellphone_number;
    }

    public String getRecommendedReason() {
        return recommended_reason;
    }
    public void setRecommendedReason(String recommended_reason) {
        this.recommended_reason = recommended_reason;
    }

}
