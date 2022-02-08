package Service.Common;

import Bean.Common.OtherFile;
import Bean.Common.OtherFileUploadForm;
import Dao.Common.Impl.OtherFileUploadDAOImpl;
import Dao.Common.OtherFileUploadDAO;
import Utils.SystemUtil;
import Utils.json_transformer_util;
import fr.opensagres.xdocreport.document.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OtherFileUploadService {
    public String query(int projectId) {
        OtherFileUploadDAO otherFileUploadDAO = new OtherFileUploadDAOImpl();
        OtherFileUploadForm otherFileUploadForm = otherFileUploadDAO.query(projectId);
        return new json_transformer_util().other_file_upload_form_to_json(otherFileUploadForm);
    }

    public void save(int projectId, JSONObject jsonObject){
        List<OtherFile> OtherFileList = new ArrayList<>();

        for (Object object : jsonObject.getJSONArray("OtherFileList")) {
            JSONObject otherFileJson = (JSONObject) object;
            OtherFile otherFile = new OtherFile();
            String documentId = otherFileJson.getString("documentId");

            if (SystemUtil.isValidUUID(documentId)) {
                otherFile.setDocumentId(UUID.fromString(documentId));
            }
            otherFile.setProjectId(projectId);
            otherFile.setDescription(otherFileJson.getString("description"));

            OtherFileList.add(otherFile);
        }

//        OtherFileUploadForm otherFileUploadForm = new json_transformer_util().json_to_other_file_upload_form(jsonObject) ;

        OtherFileUploadDAO otherFileUploadDAO = new OtherFileUploadDAOImpl();

        for(OtherFile otherFile : OtherFileList){
            otherFile.setProjectId(projectId);
            otherFileUploadDAO.saveWithoutFilePath(otherFile);
        }
    }
}
