package Bean.ExcellentResearcher.ResearchProduction;

import java.util.Date;

public class Technology {
    private String authorizedUnit;
    private String patentName;
    private Date contractDate;
    private String technologyName;
    private String toAuthorizedUnit;
    private String mstPlanNumber;
    private String projectId;

    public Technology(String authorizedUnit, String patentName, Date contractDate, String technologyName, String toAuthorizedUnit, String mstPlanNumber, String projectId) {
        this.authorizedUnit = authorizedUnit;
        this.patentName = patentName;
        this.contractDate = contractDate;
        this.technologyName = technologyName;
        this.toAuthorizedUnit = toAuthorizedUnit;
        this.mstPlanNumber = mstPlanNumber;
        this.projectId = projectId;
    }

    public Technology() {

    }

    public String getAuthorizedUnit() {
        return authorizedUnit;
    }

    public void setAuthorizedUnit(String authorizedUnit) {
        this.authorizedUnit = authorizedUnit;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public String getToAuthorizedUnit() {
        return toAuthorizedUnit;
    }

    public void setToAuthorizedUnit(String toAuthorizedUnit) {
        this.toAuthorizedUnit = toAuthorizedUnit;
    }

    public String getMstPlanNumber() {
        return mstPlanNumber;
    }

    public void setMstPlanNumber(String mstPlanNumber) {
        this.mstPlanNumber = mstPlanNumber;
    }

    public String getprojectId() {
        return projectId;
    }

    public void setprojectId(String projectId) {
        this.projectId = projectId;
    }
}
