package Dao.Common.Impl;

import Bean.Common.OtherFile;
import Bean.Common.OtherFileUploadForm;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.Common.OtherFileUploadDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OtherFileUploadDAOImpl implements OtherFileUploadDAO {
    private DBConnection dbConnection = new DBConnectionImpl();

    private static final String SELECT_DOCS_WITH_SPECIFIED_PROJECT_ID = "SELECT * FROM common_other_file WHERE project_id = ?";
    private static final String UPDATE_SPECIFIED_FILE_DATA =
            "UPDATE common_other_file SET project_id=?, description=?, doc_file_path = ? WHERE document_id = ?";
    private static final String INSERT =
            "INSERT INTO common_other_file (project_id, description, doc_file_path, document_id)"+
                    " values(?,?,?,?)";
    private static final String UPDATE_SPECIFIED_FILE_DATA_WITHOUT_FILE_PATH =
            "UPDATE common_other_file SET project_id=?, description=? WHERE document_id = ?";
    private static final String INSERT_WITHOUT_FILE_PATH =
            "INSERT INTO common_other_file (project_id, description, document_id)"+
                    " values(?,?,?)";
    private static final String DELETE = "DELETE FROM common_other_file WHERE document_id = ?";
    private static final String SELECT = "SELECT * FROM common_other_file WHERE document_id=? and project_id = ?";
    private static final String SELECT_SPECIFIED_DOC = "SELECT * FROM common_other_file WHERE document_id=? ";

    @Override
    public OtherFileUploadForm query(int projectId) {
        Connection connection = dbConnection.getConnection();

        OtherFileUploadForm otherFileUploadForm = new OtherFileUploadForm(projectId);
        List<OtherFile> OtherFileUploadFormList = new ArrayList<>() ;

        ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOCS_WITH_SPECIFIED_PROJECT_ID))
        {
            preparedStatement.setInt(1, projectId);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                OtherFile otherFile = new OtherFile();
                otherFile.setDocumentId( UUID.fromString(resultSet.getString("document_id")));
                otherFile.setProjectId( resultSet.getInt("project_id"));
                otherFile.setDescription( resultSet.getString("description"));
                otherFile.setDocFilePath(resultSet.getString("doc_file_path"));

                OtherFileUploadFormList.add(otherFile);
            }
            otherFileUploadForm.setOtherFileList(OtherFileUploadFormList);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return otherFileUploadForm;
    }

    @Override
    public void save(OtherFile object) {
        if (dataIsExist(object)) {
            update(object);
        }
        else {
            insert(object);
        }
    }

    @Override
    public void saveWithoutFilePath(OtherFile object) {
        if (dataIsExist(object)) {
            updateWithoutFilePath(object);
        }
        else {
            insertWithoutFilePath(object);
        }
    }

    @Override
    public void delete(OtherFile object) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE))
        {
            preparedStatement.setString(1, object.getDocumentId().toString());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OtherFile querySpecifiedDocument(String docId) {
        Connection connection = dbConnection.getConnection();
        OtherFile otherFile = new OtherFile();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SPECIFIED_DOC))
        {
            preparedStatement.setString(1, docId);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            if ( resultSet.next() ) {
                otherFile.setProjectId( resultSet.getInt("project_id"));
                otherFile.setDescription( resultSet.getString("description"));
                otherFile.setDocFilePath( resultSet.getString("doc_file_path"));
                otherFile.setDocumentId(UUID.fromString(resultSet.getString("document_id")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otherFile;
    }

    private boolean dataIsExist(OtherFile object){
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        int size = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,object.getDocumentId().toString());
            preparedStatement.setInt(2,object.getProjectId());
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                size++;
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (size != 0) {
            return true;
        }
        return false;
    }

    private void update(OtherFile object) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SPECIFIED_FILE_DATA))
        {
            preparedStatement.setInt(1,object.getProjectId());
            preparedStatement.setString(2,object.getDescription());
            preparedStatement.setString(3,object.getDocFilePath());
            preparedStatement.setString(4,object.getDocumentId().toString());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert(OtherFile object) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setInt(1,object.getProjectId());
            preparedStatement.setString(2,object.getDescription());
            preparedStatement.setString(3,object.getDocFilePath());
            preparedStatement.setString(4,object.getDocumentId().toString());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateWithoutFilePath(OtherFile object) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SPECIFIED_FILE_DATA_WITHOUT_FILE_PATH))
        {
            preparedStatement.setInt(1, object.getProjectId());
            preparedStatement.setString(2, object.getDescription());
            preparedStatement.setString(3, object.getDocumentId().toString());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertWithoutFilePath(OtherFile object) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WITHOUT_FILE_PATH))
        {
            preparedStatement.setInt(1, object.getProjectId());
            preparedStatement.setString(2, object.getDescription());
            preparedStatement.setString(3, object.getDocumentId().toString());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
