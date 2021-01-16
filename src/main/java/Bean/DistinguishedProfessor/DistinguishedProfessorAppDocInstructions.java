package Bean.DistinguishedProfessor;

import java.util.ArrayList;
import java.util.List;

public class DistinguishedProfessorAppDocInstructions {
	private String userNumber;
	private String technologyTransferContractName;
	private String technologyTransferDepartment;
    private String contractDate;
    private String technologyTransferFund;
    private String technologyTransferFundBringInDate;
    private List<DistinguishedProfessorAppDocInstructions> distinguishedProfessorAppDocInstructionsList = new ArrayList<>();


	public DistinguishedProfessorAppDocInstructions(String userNumber, String technologyTransferContractName, String technologyTransferDepartment, String contractDate, String technologyTransferFund, String technologyTransferFundBringInDate) {
    	this.userNumber = userNumber;
    	this.technologyTransferContractName = technologyTransferContractName;
    	this.technologyTransferDepartment = technologyTransferDepartment;
        this.contractDate = contractDate;
        this.technologyTransferFund = technologyTransferFund;
        this.technologyTransferFundBringInDate = technologyTransferFundBringInDate;       
    }

    public DistinguishedProfessorAppDocInstructions() {

    }
    
    public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
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

	public String getContractDate() {
		return contractDate;
	}

	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}

	public String getTechnologyTransferFund() {
		return technologyTransferFund;
	}

	public void setTechnologyTransferFund(String technologyTransferFund) {
		this.technologyTransferFund = technologyTransferFund;
	}

	public String getTechnologyTransferFundBringInDate() {
		return technologyTransferFundBringInDate;
	}

	public void setTechnologyTransferFundBringInDate(String technologyTransferFundBringInDate) {
		this.technologyTransferFundBringInDate = technologyTransferFundBringInDate;
	}
	
	public List<DistinguishedProfessorAppDocInstructions> getDistinguishedProfessorAppDocInstructionsList() {
		return distinguishedProfessorAppDocInstructionsList;
	}

	public void setDistinguishedProfessorAppDocInstructionsList(
			List<DistinguishedProfessorAppDocInstructions> distinguishedProfessorAppDocInstructionsList) {
		this.distinguishedProfessorAppDocInstructionsList = distinguishedProfessorAppDocInstructionsList;
	}
}
