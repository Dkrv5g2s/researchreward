package Bean.SolicitSpecialOutstandingResearcher;

import java.util.Date;

public class SolicitSpecialOutstandingResearcherForm {
    private int project_id;
    private short suitable_type;
    private short level_standard;
    private String recommend_seq;
    private short max_pay_year;
    private short current_pay_year;
    private Date upgrade_date;
    private Date department_review_date;
    private Date academy_review_date;
    private Date department_approve_date;
    private Date academy_approve_date;

    public SolicitSpecialOutstandingResearcherForm() {
    }

    public SolicitSpecialOutstandingResearcherForm(int project_id) {
        this.project_id = project_id;
    }

    public SolicitSpecialOutstandingResearcherForm(int project_id, short suitable_type, short level_standard, String recommend_seq, short max_pay_year, short current_pay_year, Date upgrade_date, Date department_review_date, Date academy_review_date, Date department_approve_date, Date academy_approve_date) {
        this.project_id = project_id;
        this.suitable_type = suitable_type;
        this.level_standard = level_standard;
        this.recommend_seq = recommend_seq;
        this.max_pay_year = max_pay_year;
        this.current_pay_year = current_pay_year;
        this.upgrade_date = upgrade_date;
        this.department_review_date = department_review_date;
        this.academy_review_date = academy_review_date;
        this.department_approve_date = department_approve_date;
        this.academy_approve_date = academy_approve_date;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public short getSuitable_type() {
        return suitable_type;
    }

    public void setSuitable_type(short suitable_type) {
        this.suitable_type = suitable_type;
    }

    public short getLevel_standard() {
        return level_standard;
    }

    public void setLevel_standard(short level_standard) {
        this.level_standard = level_standard;
    }

    public String getRecommend_seq() {
        return recommend_seq;
    }

    public void setRecommend_seq(String recommend_seq) {
        this.recommend_seq = recommend_seq;
    }

    public short getMax_pay_year() {
        return max_pay_year;
    }

    public void setMax_pay_year(short max_pay_year) {
        this.max_pay_year = max_pay_year;
    }

    public short getCurrent_pay_year() {
        return current_pay_year;
    }

    public void setCurrent_pay_year(short current_pay_year) {
        this.current_pay_year = current_pay_year;
    }

    public Date getUpgrade_date() {
        return upgrade_date;
    }

    public void setUpgrade_date(Date upgrade_date) {
        this.upgrade_date = upgrade_date;
    }

    public Date getDepartment_review_date() {
        return department_review_date;
    }

    public void setDepartment_review_date(Date department_review_date) {
        this.department_review_date = department_review_date;
    }

    public Date getAcademy_review_date() {
        return academy_review_date;
    }

    public void setAcademy_review_date(Date academy_review_date) {
        this.academy_review_date = academy_review_date;
    }

    public Date getDepartment_approve_date() {
        return department_approve_date;
    }

    public void setDepartment_approve_date(Date department_approve_date) {
        this.department_approve_date = department_approve_date;
    }

    public Date getAcademy_approve_date() {
        return academy_approve_date;
    }

    public void setAcademy_approve_date(Date academy_approve_date) {
        this.academy_approve_date = academy_approve_date;
    }
}
