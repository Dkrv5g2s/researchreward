package Bean.ExcellentResearcher.ResearchProduction;

import java.util.Date;

public class Patent {
    private String patentClass;
    private String patentName;
    private String country;
    private String patentNumber;
    private String inventor;
    private String patentee;
    private Date approvalDate;
    private String mstPlanNumber;
    private int projectId;

    public Patent(String patentClass, String patentName, String country, String patentNumber, String inventor, String patentee, Date approvalDate, String mstPlanNumber, int projectId) {
        this.patentClass = patentClass;
        this.patentName = patentName;
        this.country = country;
        this.patentNumber = patentNumber;
        this.inventor = inventor;
        this.patentee = patentee;
        this.approvalDate = approvalDate;
        this.mstPlanNumber = mstPlanNumber;
        this.projectId = projectId;
    }

    public Patent() {

    }

    public String getPatentClass() {
        return patentClass;
    }

    public void setPatentClass(String patentClass) {
        this.patentClass = patentClass;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPatentNumber() {
        return patentNumber;
    }

    public void setPatentNumber(String patentNumber) {
        this.patentNumber = patentNumber;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }

    public String getPatentee() {
        return patentee;
    }

    public void setPatentee(String patentee) {
        this.patentee = patentee;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getMstPlanNumber() {
        return mstPlanNumber;
    }

    public void setMstPlanNumber(String mstPlanNumber) {
        this.mstPlanNumber = mstPlanNumber;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
