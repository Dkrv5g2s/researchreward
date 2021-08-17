package Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormA;

public class OtherData {
	private String year1;
	private String year2;
	private String year3;
    private String year4;
    private String year5;
    private String projectID;
	private String other_data;
	private String commit_date;

	public OtherData(String year1, String year2, String year3, String year4, String year5, String projectID,
					 String other_data, String commit_date) {
		this.year1 = year1;
		this.year2 = year2;
		this.year3 = year3;
		this.year4 = year4;
		this.year5 = year5;
		this.projectID = projectID;
		this.other_data = other_data;
		this.commit_date = commit_date;
	}

	public OtherData(String projectID,
					 String other_data, String commit_date) {
		this.projectID = projectID;
		this.other_data = other_data;
		this.commit_date = commit_date;
	}

	public String getYear1() {
		return year1;
	}

	public void setYear1(String year1) {
		this.year1 = year1;
	}

	public String getYear2() {
		return year2;
	}

	public void setYear2(String year2) {
		this.year2 = year2;
	}

	public String getYear3() {
		return year3;
	}

	public void setYear3(String year3) {
		this.year3 = year3;
	}

	public String getYear4() {
		return year4;
	}

	public void setYear4(String year4) {
		this.year4 = year4;
	}

	public String getYear5() {
		return year5;
	}

	public void setYear5(String year5) {
		this.year5 = year5;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getOther_data() {
		return other_data;
	}

	public void setOther_data(String other_data) {
		this.other_data = other_data;
	}

	public String getCommit_date() {
		return commit_date;
	}

	public void setCommit_date(String commit_date) {
		this.commit_date = commit_date;
	}
	
	
	
}
