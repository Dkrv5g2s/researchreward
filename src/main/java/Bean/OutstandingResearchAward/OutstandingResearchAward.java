package Bean.OutstandingResearchAward;

import java.sql.Date;

public class OutstandingResearchAward {
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

    private String department_academic_year;
    private String department_semester;
    private String department_conference_times;
    private Date department_sign_date;

    private String college_academic_year;
    private String college_semester;
    private String college_conference_times;
    private Date college_sign_date;

    private String research_and_development_office_sign_year;
    private String research_and_development_office_sign_month;
    private String research_and_development_office_sign_date;

    public OutstandingResearchAward(int project_id, int user_number, String user_name, String applicant_title, String department, Date birth_date, Date employment_date, String identity_number, String extension_number, String cellphone_number, String recommended_reason, String department_academic_year, String department_semester, String department_conference_times, Date department_sign_date, String college_academic_year, String college_semester, String college_conference_times, Date college_sign_date, String research_and_development_office_sign_year, String research_and_development_office_sign_month, String research_and_development_office_sign_date) {
        this.project_id = project_id;
        this.user_number = user_number;
        this.user_name = user_name;
        this.applicant_title = applicant_title;
        this.department = department;
        this.birth_date = birth_date;
        this.employment_date = employment_date;
        // ID birthday removed from frontEnd
        this.identity_number = identity_number;
        this.extension_number = extension_number;
        //
        this.cellphone_number = cellphone_number;
        this.recommended_reason = recommended_reason;
        this.department_academic_year = department_academic_year;
        this.department_semester = department_semester;
        this.department_conference_times = department_conference_times;
        this.department_sign_date = department_sign_date;
        this.college_academic_year = college_academic_year;
        this.college_semester = college_semester;
        this.college_conference_times = college_conference_times;
        this.college_sign_date = college_sign_date;
        this.research_and_development_office_sign_year = research_and_development_office_sign_year;
        this.research_and_development_office_sign_month = research_and_development_office_sign_month;
        this.research_and_development_office_sign_date = research_and_development_office_sign_date;
    }

    public OutstandingResearchAward() {}


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


    public String getDepartmentAcademicYear() {
        return department_academic_year;
    }
    public void setDepartmentAcademicYear(String department_academic_year) {
        this.department_academic_year = department_academic_year;
    }

    public String getDepartmentSemester() {
        return department_semester;
    }
    public void setDepartmentSemester(String department_semester) {
        this.department_semester = department_semester;
    }

    public String getDepartmentConferenceTimes() {
        return department_conference_times;
    }
    public void setDepartmentConferenceTimes(String department_conference_times) {
        this.department_conference_times = department_conference_times;
    }

    public Date getDepartmentSignDate() {
        return department_sign_date;
    }
    public void setDepartmentSignDate(Date department_sign_date) {
        this.department_sign_date = department_sign_date;
    }

    public String getCollegeAcademicYear() {
        return college_academic_year;
    }
    public void setCollegeAcademicYear(String college_academic_year) {
        this.college_academic_year = college_academic_year;
    }

    public String getCollegeSemester() {
        return college_semester;
    }
    public void setCollegeSemester(String college_semester) {
        this.college_semester = college_semester;
    }

    public String getCollegeConferenceTimes() {
        return college_conference_times;
    }
    public void setCollegeConferenceTimes(String college_conference_times) {
        this.college_conference_times = college_conference_times;
    }

    public Date getCollegeSignDate() {
        return college_sign_date;
    }
    public void setCollegeSignDate(Date college_sign_date) {
        this.college_sign_date = college_sign_date;
    }

    public String getResearchAndDevelopmentOfficeSignYear() {
        return research_and_development_office_sign_year;
    }
    public void setResearchAndDevelopmentOfficeSignYear(String research_and_development_office_sign_year) {
        this.research_and_development_office_sign_year = research_and_development_office_sign_year;
    }

    public String getResearchAndDevelopmentOfficeSignMonth() {
        return research_and_development_office_sign_month;
    }
    public void setResearchAndDevelopmentOfficeSignMonth(String research_and_development_office_sign_month) {
        this.research_and_development_office_sign_month = research_and_development_office_sign_month;
    }

    public String getResearchAndDevelopmentOfficeSignDate() {
        return research_and_development_office_sign_date;
    }
    public void setResearchAndDevelopmentOfficeSignDate(String research_and_development_office_sign_date) {
        this.research_and_development_office_sign_date = research_and_development_office_sign_date;
    }
    @Override
    public String toString() {
        return "OutstandingResearchAward{" +
                "project_id='" + project_id + '\'' +
                ", user_number='" + user_number + '\'' +
                ", user_name='" + user_name + '\'' +
                ", applicant_title='" + applicant_title + '\'' +
                ", department='" + department + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", employment_date='" + employment_date + '\'' +
                ", identity_number='" + identity_number + '\'' +
                ", extension_number='" + extension_number + '\'' +
                ", cellphone_number='" + cellphone_number + '\'' +
                ", recommended_reason='" + recommended_reason + '\'' +
                '}';
    }
}
