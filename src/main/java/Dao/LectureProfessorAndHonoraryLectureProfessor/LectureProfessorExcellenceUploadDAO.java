package Dao.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorUpload;
import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorUploadForm;

public interface LectureProfessorExcellenceUploadDAO {
    public LectureProfessorUploadForm query(int project_id);
    public void update(LectureProfessorUpload object);
    public void insert(LectureProfessorUpload object);
    void save(LectureProfessorUpload object);
    public LectureProfessorUpload query_specified_certified_document(String doc_id);
}
