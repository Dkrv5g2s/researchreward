package Bean.Project;

import java.sql.Date;

public class RewardProject {
    private int project_id;
    private String staff_code ;
    private String reward_type ;
    private int status_id;
    private Date apply_date;
    private String status ;
    private String reason_for_return;
    private String department_reviewer;
    private String college_reviewer;
    private String industry_liaison_office_reviewer;
    private String research_and_development_office_reviewer;
    private String department_review_time;
    private String college_review_time;
    private String industry_liaison_office_review_time;
    private String research_and_development_office_review_time;

    public RewardProject(int project_id, String staff_code, String status, Date apply_date, String reward_type) {
        this.project_id = project_id;
        this.staff_code = staff_code;
        this.status = status;
        this.apply_date = apply_date;
        this.reward_type = reward_type;
    }

    public RewardProject(int project_id, String staff_code, String reward_type, int status_id, Date apply_date, String status,
                         String reason_for_return, String department_reviewer, String college_reviewer,
                         String industry_liaison_office_reviewer, String research_and_development_office_reviewer,
                         String department_review_time, String college_review_time,
                         String industry_liaison_office_review_time, String research_and_development_office_review_time) {
        this.project_id = project_id;
        this.staff_code = staff_code;
        this.reward_type = reward_type;
        this.status_id = status_id;
        this.apply_date = apply_date;
        this.status = status;
        this.reason_for_return = reason_for_return;
        this.department_reviewer = department_reviewer;
        this.college_reviewer = college_reviewer;
        this.industry_liaison_office_reviewer = industry_liaison_office_reviewer;
        this.research_and_development_office_reviewer = research_and_development_office_reviewer;
        this.department_review_time = department_review_time;
        this.college_review_time = college_review_time;
        this.industry_liaison_office_review_time = industry_liaison_office_review_time;
        this.research_and_development_office_review_time = research_and_development_office_review_time;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getStaff_code() {
        return staff_code;
    }

    public void setStaff_code(String staff_code) {
        this.staff_code = staff_code;
    }

    public String getReward_type() {
        return reward_type;
    }

    public void setReward_type(String reward_type) {
        this.reward_type = reward_type;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getApply_date() {
        return apply_date;
    }

    public void setApply_date(Date apply_date) {
        this.apply_date = apply_date;
    }

    public String getReason_for_return() {
        return reason_for_return;
    }

    public void setReason_for_return(String reason_for_return) {
        this.reason_for_return = reason_for_return;
    }

    public String getDepartment_reviewer() {
        return department_reviewer;
    }

    public void setDepartment_reviewer(String department_reviewer) {
        this.department_reviewer = department_reviewer;
    }

    public String getCollege_reviewer() {
        return college_reviewer;
    }

    public void setCollege_reviewer(String college_reviewer) {
        this.college_reviewer = college_reviewer;
    }

    public String getIndustry_liaison_office_reviewer() {
        return industry_liaison_office_reviewer;
    }

    public void setIndustry_liaison_office_reviewer(String industry_liaison_office_reviewer) {
        this.industry_liaison_office_reviewer = industry_liaison_office_reviewer;
    }

    public String getResearch_and_development_office_reviewer() {
        return research_and_development_office_reviewer;
    }

    public void setResearch_and_development_office_reviewer(String research_and_development_office_reviewer) {
        this.research_and_development_office_reviewer = research_and_development_office_reviewer;
    }

    public String getDepartment_review_time() {
        return department_review_time;
    }

    public void setDepartment_review_time(String department_review_time) {
        this.department_review_time = department_review_time;
    }

    public String getCollege_review_time() {
        return college_review_time;
    }

    public void setCollege_review_time(String college_review_time) {
        this.college_review_time = college_review_time;
    }

    public String getIndustry_liaison_office_review_time() {
        return industry_liaison_office_review_time;
    }

    public void setIndustry_liaison_office_review_time(String industry_liaison_office_review_time) {
        this.industry_liaison_office_review_time = industry_liaison_office_review_time;
    }

    public String getResearch_and_development_office_review_time() {
        return research_and_development_office_review_time;
    }

    public void setResearch_and_development_office_review_time(String research_and_development_office_review_time) {
        this.research_and_development_office_review_time = research_and_development_office_review_time;
    }
}
