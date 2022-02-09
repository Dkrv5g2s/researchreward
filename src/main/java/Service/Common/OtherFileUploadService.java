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
        List<OtherFile> otherFileList = getOtherFileListFromJSONObject(projectId, jsonObject);
        List<OtherFile> deletedOtherFileList = getDeletedOtherFileListFromJSONObject(projectId, jsonObject);

        OtherFileUploadDAO otherFileUploadDAO = new OtherFileUploadDAOImpl();

        for(OtherFile otherFile : otherFileList){
            otherFileUploadDAO.saveWithoutFilePath(otherFile);
        }

        for(OtherFile deletedOtherFile : deletedOtherFileList){
            otherFileUploadDAO.delete(deletedOtherFile);
        }
    }

    private List<OtherFile> getOtherFileListFromJSONObject(int projectId, JSONObject jsonObject) {
        List<OtherFile> otherFileList = new ArrayList<>();

        for (Object object : jsonObject.getJSONArray("OtherFileList")) {
            JSONObject otherFileJson = (JSONObject) object;
            OtherFile otherFile = new OtherFile();
            String documentId = otherFileJson.getString("documentId");

            if (SystemUtil.isValidUUID(documentId)) {
                otherFile.setDocumentId(UUID.fromString(documentId));
            }
            otherFile.setProjectId(projectId);
            otherFile.setDescription(otherFileJson.getString("description"));

            otherFileList.add(otherFile);
        }

        return otherFileList;
    }

    private List<OtherFile> getDeletedOtherFileListFromJSONObject(int projectId, JSONObject jsonObject) {
        List<OtherFile> deletedOtherFileList = new ArrayList<>();

        for (Object object : jsonObject.getJSONArray("DeletedOtherFileList")) {
            JSONObject deletedOtherFileJson = (JSONObject) object;
            String documentId = deletedOtherFileJson.getString("documentId");

            if (SystemUtil.isValidUUID(documentId)) {
                OtherFile deletedOtherFile = new OtherFile();
                deletedOtherFile.setDocumentId(UUID.fromString(documentId));
                deletedOtherFile.setProjectId(projectId);
                deletedOtherFile.setDescription(deletedOtherFileJson.getString("description"));
                deletedOtherFileList.add(deletedOtherFile);
            }
        }

        return deletedOtherFileList;
    }
}
