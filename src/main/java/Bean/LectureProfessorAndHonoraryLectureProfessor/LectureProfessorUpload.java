package Bean.LectureProfessorAndHonoraryLectureProfessor;

import java.util.UUID;

public class LectureProfessorUpload {

    private UUID document_id;
    private int projectID;
    private String doc_type;
    private String certified_doc_file_path;

    public LectureProfessorUpload(){
        this.document_id = UUID.randomUUID();
    }
    public UUID getDocument_id() {
        return document_id;
    }
    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setDocument_id(UUID document_id) {
        this.document_id = document_id;
    }

    public String getDocType() {
        return doc_type;
    }

    public void setDocType(String doc_type) {
        this.doc_type = doc_type;
    }

    public String getCertifiedDocFilePath() {
        return certified_doc_file_path;
    }

    public void setCertifiedDocFilePath(String certified_doc_file_path) {
        this.certified_doc_file_path = certified_doc_file_path;
    }
}
