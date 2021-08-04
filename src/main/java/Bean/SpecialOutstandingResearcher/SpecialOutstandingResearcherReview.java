package Bean.SpecialOutstandingResearcher;

import java.util.Date;

public class SpecialOutstandingResearcherReview {
    private int project_id ;

    private boolean department_review ;
    private String college_recommended_order;
    private Date college_review_date ;
    private Date research_office_review_date ;

    public SpecialOutstandingResearcherReview(int project_id, boolean department_review, String college_recommended_order, Date college_review_date, Date research_office_review_date) {
        this.project_id = project_id;
        this.department_review = department_review;
        this.college_recommended_order = college_recommended_order;
        this.college_review_date = college_review_date;
        this.research_office_review_date = research_office_review_date;
    }

    public SpecialOutstandingResearcherReview() {

    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public boolean getDepartment_review() {
        return department_review;
    }

    public void setDepartment_review(boolean department_review) {
        this.department_review = department_review;
    }

    public boolean isDepartment_review() {
        return department_review;
    }

    public String getCollege_recommended_order() {
        return college_recommended_order;
    }

    public void setCollege_recommended_order(String college_recommended_order) {
        this.college_recommended_order = college_recommended_order;
    }

    public Date getCollege_review_date() {
        return college_review_date;
    }

    public void setCollege_review_date(Date college_review_date) {
        this.college_review_date = college_review_date;
    }

    public Date getResearch_office_review_date() {
        return research_office_review_date;
    }

    public void setResearch_office_review_date(Date research_office_review_date) {
        this.research_office_review_date = research_office_review_date;
    }
}
