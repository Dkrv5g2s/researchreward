package Bean.Common;

import java.util.List;

public class OtherFileUploadForm {
    private int projectID;
    private List<OtherFile> OtherFileList;

    public OtherFileUploadForm(int projectID) {
        this.projectID = projectID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public List<OtherFile> getOtherFileList() {
        return OtherFileList;
    }

    public void setOtherFileList(List<OtherFile> otherFileList) {
        OtherFileList = otherFileList;
    }
}
