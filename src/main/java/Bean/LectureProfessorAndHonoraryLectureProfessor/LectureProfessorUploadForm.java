package Bean.LectureProfessorAndHonoraryLectureProfessor;

import java.util.List;

public class LectureProfessorUploadForm {
    private int projectID;
    List<LectureProfessorUpload> LectureProfessorUploadList;

    public LectureProfessorUploadForm(){

    }
    public LectureProfessorUploadForm(int projectID){
        this.projectID = projectID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public List<LectureProfessorUpload> getLectureProfessorUploadList() {
        return LectureProfessorUploadList;
    }

    public void setLectureProfessorUploadList(List<LectureProfessorUpload> lectureProfessorUploadList) {
        LectureProfessorUploadList = lectureProfessorUploadList;
    }
}
