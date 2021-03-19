package Bean.SunshineScholarshipAward;

public class FWCIUserInputInfomation {

    private String swArticleCountOne;
    private String swPointOne;
    private String fwciValueOfUser;
    private String h5IndexOfUser;
    private boolean teacherFormCheck;
    private String commitDate;
    private int projectId;

    public FWCIUserInputInfomation(String swArticleCountOne, String swPointOne, String fwciValueOfUser, boolean teacherFormCheck, String commitDate, int projectId,String h5IndexOfUser) {
        this.swArticleCountOne = swArticleCountOne;
        this.swPointOne = swPointOne;
        this.fwciValueOfUser = fwciValueOfUser;
        this.teacherFormCheck = teacherFormCheck;
        this.commitDate = commitDate;
        this.projectId = projectId;
        this.h5IndexOfUser = h5IndexOfUser;

    }

    public FWCIUserInputInfomation(){

    }
    public String getSwArticleCountOne() {
        return swArticleCountOne;
    }

    public void setSwArticleCountOne(String swArticleCountOne) {
        this.swArticleCountOne = swArticleCountOne;
    }

    public String getSwPointOne() {
        return swPointOne;
    }

    public void setSwPointOne(String swPointOne) {
        this.swPointOne = swPointOne;
    }

    public String getFwciValueOfUser() {
        return fwciValueOfUser;
    }

    public void setFwciValueOfUser(String fwciValueOfUser) {
        this.fwciValueOfUser = fwciValueOfUser;
    }

    public boolean isTeacherFormCheck() {
        return teacherFormCheck;
    }

    public void setTeacherFormCheck(boolean teacherFormCheck) {
        this.teacherFormCheck = teacherFormCheck;
    }

    public String getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(String commitDate) {
        this.commitDate = commitDate;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getH5IndexOfUser() {
        return h5IndexOfUser;
    }

    public void setH5IndexOfUser(String h5IndexOfUser) {
        this.h5IndexOfUser = h5IndexOfUser;
    }
}
