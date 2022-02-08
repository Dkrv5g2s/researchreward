package Dao.Common;

import Bean.Common.OtherFile;
import Bean.Common.OtherFileUploadForm;

public interface OtherFileUploadDAO {
    OtherFileUploadForm query(int projectId);
    void save(OtherFile object);
    void saveWithoutFilePath(OtherFile object);
    OtherFile querySpecifiedDocument(String docId);
}
