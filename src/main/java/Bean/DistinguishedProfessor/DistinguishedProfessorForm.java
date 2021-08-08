package Bean.DistinguishedProfessor;


import java.sql.Date;

public class DistinguishedProfessorForm {
    private String usernum;
	private String name;
	private String department;
    private String hireddate;
    private String certificatenum;
    private String upgradedate;
    private String seniority;
    private String email;
    private String researchroomext;
    private String cellphone;
    private Boolean applicationrequirements1;
    private Boolean applicationrequirements2;
    private Boolean applicationrequirements3;
    private Boolean applicationrequirements4;
    private Boolean applicationrequirements5;
    private Boolean applicationrequirements6;
    private Boolean applicationrequirements7;
    private Boolean applicationrequirements8;
    private Boolean applicationrequirements9;

	private String department_academic_year;
	private String department_semester;
	private String department_conference_times;
	private String department_sign_date;

	private String college_academic_year;
	private String college_semester;
	private String college_conference_times;
	private String college_sign_date;

	private String research_and_development_office_sign_year;
	private String research_and_development_office_sign_month;
	private String research_and_development_office_sign_date;

	public DistinguishedProfessorForm(String usernum, String name, String department, String hireddate, String certificatenum, String upgradedate, String seniority, String email, String researchroomext, String cellphone, Boolean applicationrequirements1, Boolean applicationrequirements2, Boolean applicationrequirements3, Boolean applicationrequirements4, Boolean applicationrequirements5, Boolean applicationrequirements6, Boolean applicationrequirements7, Boolean applicationrequirements8, Boolean applicationrequirements9, String department_academic_year, String department_semester, String department_conference_times, String department_sign_date, String college_academic_year, String college_semester, String college_conference_times, String college_sign_date, String research_and_development_office_sign_year, String research_and_development_office_sign_month, String research_and_development_office_sign_date) {
		this.usernum = usernum;
		this.name = name;
		this.department = department;
		this.hireddate = hireddate;
		this.certificatenum = certificatenum;
		this.upgradedate = upgradedate;
		this.seniority = seniority;
		this.email = email;
		this.researchroomext = researchroomext;
		this.cellphone = cellphone;
		this.applicationrequirements1 = applicationrequirements1;
		this.applicationrequirements2 = applicationrequirements2;
		this.applicationrequirements3 = applicationrequirements3;
		this.applicationrequirements4 = applicationrequirements4;
		this.applicationrequirements5 = applicationrequirements5;
		this.applicationrequirements6 = applicationrequirements6;
		this.applicationrequirements7 = applicationrequirements7;
		this.applicationrequirements8 = applicationrequirements8;
		this.applicationrequirements9 = applicationrequirements9;
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

	public DistinguishedProfessorForm(String usernum, String name, String department, String hireddate, String certificatenum, String upgradedate, String seniority, String email, String researchroomext, String cellphone, Boolean applicationrequirements1, Boolean applicationrequirements2, Boolean applicationrequirements3, Boolean applicationrequirements4, Boolean applicationrequirements5, Boolean applicationrequirements6, Boolean applicationrequirements7, Boolean applicationrequirements8, Boolean applicationrequirements9) {
		this.usernum = usernum;
		this.name = name;
		this.department = department;
		this.hireddate = hireddate;
		this.certificatenum = certificatenum;
		this.upgradedate = upgradedate;
		this.seniority = seniority;
		this.email = email;
		this.researchroomext = researchroomext;
		this.cellphone = cellphone;
		this.applicationrequirements1 = applicationrequirements1;
		this.applicationrequirements2 = applicationrequirements2;
		this.applicationrequirements3 = applicationrequirements3;
		this.applicationrequirements4 = applicationrequirements4;
		this.applicationrequirements5 = applicationrequirements5;
		this.applicationrequirements6 = applicationrequirements6;
		this.applicationrequirements7 = applicationrequirements7;
		this.applicationrequirements8 = applicationrequirements8;
		this.applicationrequirements9 = applicationrequirements9;
	}

	public DistinguishedProfessorForm() {

    }

	public String getUsernum() {
		return usernum;
	}

	public void setUsernum(String usernum) {
		this.usernum = usernum;
	}
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getHireddate() {
		return hireddate;
	}

	public void setHireddate(String hireddate) {
		this.hireddate = hireddate;
	}

	public String getCertificatenum() {
		return certificatenum;
	}

	public void setCertificatenum(String certificatenum) {
		this.certificatenum = certificatenum;
	}

	public String getUpgradedate() {
		return upgradedate;
	}

	public void setUpgradedate(String upgradedate) {
		this.upgradedate = upgradedate;
	}

	public String getSeniority() {
		return seniority;
	}

	public void setSeniority(String seniority) {
		this.seniority = seniority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResearchroomext() {
		return researchroomext;
	}

	public void setResearchroomext(String researchroomext) {
		this.researchroomext = researchroomext;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Boolean getApplicationrequirements1() {
		return applicationrequirements1;
	}
	
	public void setApplicationrequirements1(Boolean applicationrequirements1) {
		this.applicationrequirements1 = applicationrequirements1;
	}

	public Boolean getApplicationrequirements2() {
		return applicationrequirements2;
	}

	public void setApplicationrequirements2(Boolean applicationrequirements2) {
		this.applicationrequirements2 = applicationrequirements2;
	}

	public Boolean getApplicationrequirements3() {
		return applicationrequirements3;
	}

	public void setApplicationrequirements3(Boolean applicationrequirements3) {
		this.applicationrequirements3 = applicationrequirements3;
	}

	public Boolean getApplicationrequirements4() {
		return applicationrequirements4;
	}

	public void setApplicationrequirements4(Boolean applicationrequirements4) {
		this.applicationrequirements4 = applicationrequirements4;
	}

	public Boolean getApplicationrequirements5() {
		return applicationrequirements5;
	}

	public void setApplicationrequirements5(Boolean applicationrequirements5) {
		this.applicationrequirements5 = applicationrequirements5;
	}

	public Boolean getApplicationrequirements6() {
		return applicationrequirements6;
	}

	public void setApplicationrequirements6(Boolean applicationrequirements6) {
		this.applicationrequirements6 = applicationrequirements6;
	}

	public Boolean getApplicationrequirements7() {
		return applicationrequirements7;
	}

	public void setApplicationrequirements7(Boolean applicationrequirements7) {
		this.applicationrequirements7 = applicationrequirements7;
	}

	public Boolean getApplicationrequirements8() {
		return applicationrequirements8;
	}

	public void setApplicationrequirements8(Boolean applicationrequirements8) {
		this.applicationrequirements8 = applicationrequirements8;
	}

	public Boolean getApplicationrequirements9() {
		return applicationrequirements9;
	}

	public void setApplicationrequirements9(Boolean applicationrequirements9) {
		this.applicationrequirements9 = applicationrequirements9;
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

	public String getDepartmentSignDate() {
		return department_sign_date;
	}

	public void setDepartmentSignDate(String department_sign_date) {
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

	public String getCollegeSignDate() {
		return college_sign_date;
	}

	public void setCollegeSignDate(String college_sign_date) {
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
        return "DistinguishedProfessorForm{" +
                "usernum='" + usernum + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", hireddate='" + hireddate + '\'' +
                ", certificatenum='" + certificatenum + '\'' +
                ", upgradedate=" + upgradedate +
                ", seniority='" + seniority + '\'' +
                ", email='" + email + '\'' +
                ", researchroomext='" + researchroomext + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", applicationrequirements1='" + applicationrequirements1 + '\'' +
                ", applicationrequirements2='" + applicationrequirements2 + '\'' +
                ", applicationrequirements3='" + applicationrequirements3 + '\'' +
                ", applicationrequirements4='" + applicationrequirements4 + '\'' +
                ", applicationrequirements5='" + applicationrequirements5 + '\'' +
                ", applicationrequirements6='" + applicationrequirements6 + '\'' +
                ", applicationrequirements7='" + applicationrequirements7 + '\'' +
                ", applicationrequirements8='" + applicationrequirements8 + '\'' +
                ", applicationrequirements9='" + applicationrequirements9 + '\'' +
                '}';
    }
}
