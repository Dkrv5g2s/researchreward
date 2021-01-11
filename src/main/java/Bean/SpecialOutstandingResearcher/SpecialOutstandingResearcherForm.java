package Bean.SpecialOutstandingResearcher;


import java.sql.Date;
import java.util.List;

public class SpecialOutstandingResearcherForm {
    private int project_id ;
    private String applicant_name ;
    private String job ;
    private String college ;
    private String department ;
    private String seniority ;
    private boolean executed_tech_proj ;
    private String tech_proj_id ;
    private Date tech_proj_start_time ;
    private Date tech_proj_end_time ;

    private List<SpecialOutstandingResearcherStandard> standard_list ;

    public SpecialOutstandingResearcherForm() {
    }

    public SpecialOutstandingResearcherForm(int project_id, String applicant_name, String job, String college, String department, String seniority, boolean executed_tech_proj, String tech_proj_id, Date tech_proj_start_time, Date tech_proj_end_time, List<SpecialOutstandingResearcherStandard> standard_list) {
        this.project_id = project_id;
        this.applicant_name = applicant_name;
        this.job = job;
        this.college = college;
        this.department = department;
        this.seniority = seniority;
        this.executed_tech_proj = executed_tech_proj;
        this.tech_proj_id = tech_proj_id;
        this.tech_proj_start_time = tech_proj_start_time;
        this.tech_proj_end_time = tech_proj_end_time;
        this.standard_list = standard_list;
    }


    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public boolean isExecuted_tech_proj() {
        return executed_tech_proj;
    }

    public void setExecuted_tech_proj(boolean executed_tech_proj) {
        this.executed_tech_proj = executed_tech_proj;
    }

    public String getTech_proj_id() {
        return tech_proj_id;
    }

    public void setTech_proj_id(String tech_proj_id) {
        this.tech_proj_id = tech_proj_id;
    }

    public Date getTech_proj_start_time() {
        return tech_proj_start_time;
    }

    public void setTech_proj_start_time(Date tech_proj_start_time) {
        this.tech_proj_start_time = tech_proj_start_time;
    }

    public Date getTech_proj_end_time() {
        return tech_proj_end_time;
    }

    public void setTech_proj_end_time(Date tech_proj_end_time) {
        this.tech_proj_end_time = tech_proj_end_time;
    }

    public List<SpecialOutstandingResearcherStandard> getStandard_list() {
        return standard_list;
    }

    public void setStandard_list(List<SpecialOutstandingResearcherStandard> standard_list) {
        this.standard_list = standard_list;
    }
}
