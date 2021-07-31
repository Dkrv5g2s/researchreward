package Bean.TeacherHireResearcher;

import java.sql.Date;

public class TeacherHireResearcherForm {
    private int rewardProjectId;
    private String applicantName;
    private String applicantJobTitle;
    private String applicantDepartment;
    private String applicantEmail;
    private String applicantSeniority;
    private String applicantResearchRoomExt;
    private String applicantPhone;
    private String researcherType;
    private String researcherName;
    private String researcherJobTitle;
    private String researcherSalaryScale;
    private String projectCategory;
    private String projectName;
    private String projectAmount;
    private String expectedPerformanceNearFiveYears;
    private String expectedPerformancePerYears;
    private String expectedPerformanceOthers;
    private String applyForSubsidies;

    private String departmentAcademicYear;
    private String departmentSemester;
    private String departmentConferenceTimes;
    private Date departmentSignDate;

    private String collegeAcademicYear;
    private String collegeSemester;
    private String collegeConferenceTimes;
    private Date collegeSignDate;

    private String researchAndDevelopmentOfficeSignYear;
    private String researchAndDevelopmentOfficeSignMonth;
    private String researchAndDevelopmentOfficeSignDate;

    public TeacherHireResearcherForm(int rewardProjectId, String applicantName,
                                     String applicantJobTitle, String applicantDepartment, String applicantEmail, String applicantSeniority,
                                     String applicantResearchRoomExt, String applicantPhone, String researcherType, String researcherName,
                                     String researcherJobTitle, String researcherSalaryScale,
                                     String projectCategory, String projectName, String projectAmount, String expectedPerformanceNearFiveYears,
                                     String expectedPerformancePerYears, String expectedPerformanceOthers, String applyForSubsidies){
        this.rewardProjectId = rewardProjectId;
        this.applicantName = applicantName;
        this.applicantJobTitle = applicantJobTitle;
        this.applicantDepartment = applicantDepartment;
        this.applicantEmail = applicantEmail;
        this.applicantSeniority = applicantSeniority;
        this.applicantResearchRoomExt = applicantResearchRoomExt;
        this.applicantPhone = applicantPhone;
        this.researcherType = researcherType;
        this.researcherName = researcherName;
        this.researcherJobTitle = researcherJobTitle;
        this.researcherSalaryScale = researcherSalaryScale;
        this.projectCategory = projectCategory;
        this.projectName = projectName;
        this.projectAmount = projectAmount;
        this.expectedPerformanceNearFiveYears = expectedPerformanceNearFiveYears;
        this.expectedPerformancePerYears = expectedPerformancePerYears;
        this.expectedPerformanceOthers = expectedPerformanceOthers;
        this.applyForSubsidies = applyForSubsidies;
    }

    public TeacherHireResearcherForm(int rewardProjectId, String applicantName,
                                     String applicantJobTitle, String applicantDepartment, String applicantEmail, String applicantSeniority,
                                     String applicantResearchRoomExt, String applicantPhone, String researcherType, String researcherName,
                                     String researcherJobTitle, String researcherSalaryScale,
                                     String projectCategory, String projectName, String projectAmount, String expectedPerformanceNearFiveYears,
                                     String expectedPerformancePerYears, String expectedPerformanceOthers, String applyForSubsidies,
                                     String departmentAcademicYear, String departmentSemester, String departmentConferenceTimes, Date departmentSignDate,
                                     String collegeAcademicYear, String collegeSemester, String collegeConferenceTimes, Date collegeSignDate,
                                     String researchAndDevelopmentOfficeSignYear, String researchAndDevelopmentOfficeSignMonth,
                                     String researchAndDevelopmentOfficeSignDate){
        this.rewardProjectId = rewardProjectId;
        this.applicantName = applicantName;
        this.applicantJobTitle = applicantJobTitle;
        this.applicantDepartment = applicantDepartment;
        this.applicantEmail = applicantEmail;
        this.applicantSeniority = applicantSeniority;
        this.applicantResearchRoomExt = applicantResearchRoomExt;
        this.applicantPhone = applicantPhone;
        this.researcherType = researcherType;
        this.researcherName = researcherName;
        this.researcherJobTitle = researcherJobTitle;
        this.researcherSalaryScale = researcherSalaryScale;
        this.projectCategory = projectCategory;
        this.projectName = projectName;
        this.projectAmount = projectAmount;
        this.expectedPerformanceNearFiveYears = expectedPerformanceNearFiveYears;
        this.expectedPerformancePerYears = expectedPerformancePerYears;
        this.expectedPerformanceOthers = expectedPerformanceOthers;
        this.applyForSubsidies = applyForSubsidies;

        this.departmentAcademicYear = departmentAcademicYear;
        this.departmentSemester = departmentSemester;
        this.departmentConferenceTimes = departmentConferenceTimes;
        this.departmentSignDate = departmentSignDate;
        this.collegeAcademicYear = collegeAcademicYear;
        this.collegeSemester = collegeSemester;
        this.collegeConferenceTimes = collegeConferenceTimes;
        this.collegeSignDate = collegeSignDate;
        this.researchAndDevelopmentOfficeSignYear = researchAndDevelopmentOfficeSignYear;
        this.researchAndDevelopmentOfficeSignMonth = researchAndDevelopmentOfficeSignMonth;
        this.researchAndDevelopmentOfficeSignDate = researchAndDevelopmentOfficeSignDate;
    }

    public TeacherHireResearcherForm(){

    }

    public int getRewardProjectId() {
        return rewardProjectId;
    }

    public void setRewardProjectId(int rewardProjectId) {
        this.rewardProjectId = rewardProjectId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantJobTitle() {
        return applicantJobTitle;
    }

    public void setApplicantJobTitle(String applicantJobTitle) {
        this.applicantJobTitle = applicantJobTitle;
    }

    public String getApplicantDepartment() {
        return applicantDepartment;
    }

    public void setApplicantDepartment(String applicantDepartment) {
        this.applicantDepartment = applicantDepartment;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public String getApplicantSeniority() {
        return applicantSeniority;
    }

    public void setApplicantSeniority(String applicantSeniority) {
        this.applicantSeniority = applicantSeniority;
    }

    public String getApplicantResearchRoomExt() {
        return applicantResearchRoomExt;
    }

    public void setApplicantResearchRoomExt(String applicantResearchRoomExt) {
        this.applicantResearchRoomExt = applicantResearchRoomExt;
    }

    public String getApplicantPhone() {
        return applicantPhone;
    }

    public void setApplicantPhone(String applicantPhone) {
        this.applicantPhone = applicantPhone;
    }

    public String getResearcherType() {
        return researcherType;
    }

    public void setResearcherType(String researcherType) {
        this.researcherType = researcherType;
    }

    public String getResearcherName() {
        return researcherName;
    }

    public void setResearcherName(String researcherName) {
        this.researcherName = researcherName;
    }

    public String getResearcherJobTitle() {
        return researcherJobTitle;
    }

    public void setResearcherJobTitle(String researcherJobTitle) {
        this.researcherJobTitle = researcherJobTitle;
    }

    public String getResearcherSalaryScale() {
        return researcherSalaryScale;
    }

    public void setResearcherSalaryScale(String researcherSalaryScale) {
        this.researcherSalaryScale = researcherSalaryScale;
    }

    public String getProjectCategory() {
        return projectCategory;
    }

    public void setProjectCategory(String projectCategory) {
        this.projectCategory = projectCategory;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectAmount() {
        return projectAmount;
    }

    public void setProjectAmount(String projectAmount) {
        this.projectAmount = projectAmount;
    }

    public String getExpectedPerformanceNearFiveYears() {
        return expectedPerformanceNearFiveYears;
    }

    public void setExpectedPerformanceNearFiveYears(String expectedPerformanceNearFiveYears) {
        this.expectedPerformanceNearFiveYears = expectedPerformanceNearFiveYears;
    }

    public String getExpectedPerformancePerYears() {
        return expectedPerformancePerYears;
    }

    public void setExpectedPerformancePerYears(String expectedPerformancePerYears) {
        this.expectedPerformancePerYears = expectedPerformancePerYears;
    }

    public String getExpectedPerformanceOthers() {
        return expectedPerformanceOthers;
    }

    public void setExpectedPerformanceOthers(String expectedPerformanceOthers) {
        this.expectedPerformanceOthers = expectedPerformanceOthers;
    }

    public String getApplyForSubsidies() {
        return applyForSubsidies;
    }

    public void setApplyForSubsidies(String applyForSubsidies) {
        this.applyForSubsidies = applyForSubsidies;
    }

    public String getDepartmentAcademicYear() {
        return departmentAcademicYear;
    }

    public void setDepartmentAcademicYear(String departmentAcademicYear) {
        this.departmentAcademicYear = departmentAcademicYear;
    }

    public String getDepartmentSemester() {
        return departmentSemester;
    }

    public void setDepartmentSemester(String departmentSemester) {
        this.departmentSemester = departmentSemester;
    }

    public String getDepartmentConferenceTimes() {
        return departmentConferenceTimes;
    }

    public void setDepartmentConferenceTimes(String departmentConferenceTimes) {
        this.departmentConferenceTimes = departmentConferenceTimes;
    }

    public Date getDepartmentSignDate() {
        return departmentSignDate;
    }

    public void setDepartmentSignDate(Date departmentSignDate) {
        this.departmentSignDate = departmentSignDate;
    }

    public String getCollegeAcademicYear() {
        return collegeAcademicYear;
    }

    public void setCollegeAcademicYear(String collegeAcademicYear) {
        this.collegeAcademicYear = collegeAcademicYear;
    }

    public String getCollegeSemester() {
        return collegeSemester;
    }

    public void setCollegeSemester(String collegeSemester) {
        this.collegeSemester = collegeSemester;
    }

    public String getCollegeConferenceTimes() {
        return collegeConferenceTimes;
    }

    public void setCollegeConferenceTimes(String collegeConferenceTimes) {
        this.collegeConferenceTimes = collegeConferenceTimes;
    }

    public Date getCollegeSignDate() {
        return collegeSignDate;
    }

    public void setCollegeSignDate(Date collegeSignDate) {
        this.collegeSignDate = collegeSignDate;
    }

    public String getResearchAndDevelopmentOfficeSignYear() {
        return researchAndDevelopmentOfficeSignYear;
    }

    public void setResearchAndDevelopmentOfficeSignYear(String researchAndDevelopmentOfficeSignYear) {
        this.researchAndDevelopmentOfficeSignYear = researchAndDevelopmentOfficeSignYear;
    }

    public String getResearchAndDevelopmentOfficeSignMonth() {
        return researchAndDevelopmentOfficeSignMonth;
    }

    public void setResearchAndDevelopmentOfficeSignMonth(String researchAndDevelopmentOfficeSignMonth) {
        this.researchAndDevelopmentOfficeSignMonth = researchAndDevelopmentOfficeSignMonth;
    }

    public String getResearchAndDevelopmentOfficeSignDate() {
        return researchAndDevelopmentOfficeSignDate;
    }

    public void setResearchAndDevelopmentOfficeSignDate(String researchAndDevelopmentOfficeSignDate) {
        this.researchAndDevelopmentOfficeSignDate = researchAndDevelopmentOfficeSignDate;
    }
}
