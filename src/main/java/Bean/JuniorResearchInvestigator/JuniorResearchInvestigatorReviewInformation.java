package Bean.JuniorResearchInvestigator;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class JuniorResearchInvestigatorReviewInformation {
    private int projectId;
    private int userNumber;
    private String technologyTransferContractName;
    private String technologyTransferDepartment;
    private Date contractDate;
    private String technologyTransferFund;
    private Date technologyTransferFundBringInDate;
//    private List<JuniorResearchInvestigatorReviewInformation> juniorResearchInvestigatorReviewInformationList = new ArrayList<>();


    public JuniorResearchInvestigatorReviewInformation(int projectId, int userNumber, String technologyTransferContractName, String technologyTransferDepartment, Date contractDate, String technologyTransferFund, Date technologyTransferFundBringInDate) {
        this.projectId = projectId;
        this.userNumber = userNumber;
        this.technologyTransferContractName = technologyTransferContractName;
        this.technologyTransferDepartment = technologyTransferDepartment;
        this.contractDate = contractDate;
        this.technologyTransferFund = technologyTransferFund;
        this.technologyTransferFundBringInDate = technologyTransferFundBringInDate;
    }

    public JuniorResearchInvestigatorReviewInformation() {}


    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getTechnologyTransferContractName() {
        return technologyTransferContractName;
    }

    public void setTechnologyTransferContractName(String technologyTransferContractName) {
        this.technologyTransferContractName = technologyTransferContractName;
    }

    public String getTechnologyTransferDepartment() {
        return technologyTransferDepartment;
    }

    public void setTechnologyTransferDepartment(String technologyTransferDepartment) {
        this.technologyTransferDepartment = technologyTransferDepartment;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getTechnologyTransferFund() {
        return technologyTransferFund;
    }

    public void setTechnologyTransferFund(String technologyTransferFund) {
        this.technologyTransferFund = technologyTransferFund;
    }

    public Date getTechnologyTransferFundBringInDate() {
        return technologyTransferFundBringInDate;
    }

    public void setTechnologyTransferFundBringInDate(Date technologyTransferFundBringInDate) {
        this.technologyTransferFundBringInDate = technologyTransferFundBringInDate;
    }

//    public List<JuniorResearchInvestigatorReviewInformation> getJuniorResearchInvestigatorReviewInformationList() {
//        return juniorResearchInvestigatorReviewInformationList;
//    }
//
//    public void setJuniorResearchInvestigatorReviewInformationList(
//            List<JuniorResearchInvestigatorReviewInformation> juniorResearchInvestigatorReviewInformationList) {
//        this.juniorResearchInvestigatorReviewInformationList = juniorResearchInvestigatorReviewInformationList;
//    }
}
