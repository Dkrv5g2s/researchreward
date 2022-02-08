package Service.LectureProfessorAndHonoraryLectureProfessor;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorUpload;
import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorUploadForm;
import Dao.LectureProfessorAndHonoraryLectureProfessor.Impl.LectureProfessorExcellenceUploadDAOImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceUploadDAO;
import Utils.json_transformer_util;
import fr.opensagres.xdocreport.document.json.JSONObject;

public class LectureProfessorExcellenceUploadService {

    public void save(JSONObject jsonObject,int projectID){
        LectureProfessorUploadForm lectureProfessorUploadForm = new json_transformer_util().json_to_lecture_professor_upload_form(jsonObject) ;

        LectureProfessorExcellenceUploadDAO dao = new LectureProfessorExcellenceUploadDAOImpl();

        for(LectureProfessorUpload item :lectureProfessorUploadForm.getLectureProfessorUploadList()){
            dao.save(item);
        }

    }

    public String query(int project_id) {
        LectureProfessorExcellenceUploadDAO dao = new LectureProfessorExcellenceUploadDAOImpl();
        LectureProfessorUploadForm lectureProfessorUploadForm = dao.query(project_id);
        String json_form = new json_transformer_util().lecture_professor_upload_form_to_json(lectureProfessorUploadForm);
        return json_form ;
    }
}
