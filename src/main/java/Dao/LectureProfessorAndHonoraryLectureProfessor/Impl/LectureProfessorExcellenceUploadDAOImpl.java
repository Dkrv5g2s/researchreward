package Dao.LectureProfessorAndHonoraryLectureProfessor.Impl;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorUpload;
import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorUploadForm;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceUploadDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LectureProfessorExcellenceUploadDAOImpl implements LectureProfessorExcellenceUploadDAO {

    private DBConnection dbConnection = new DBConnectionImpl();

    private static final String SELECT_DOCS_WITH_SPECIFIED_PROJECT_ID = "SELECT * FROM lectureprofessordocupload WHERE projectID = ?";
    private static final String INSERT =
            "INSERT INTO lectureprofessordocupload (projectID,doc_type,certified_doc_file_path,document_id)"+
                    " values(?,?,?,?)";
    private static final String UPDATE_SPECIFIED_CERTIFIED_FILE_DATA =
            "UPDATE lectureprofessordocupload SET projectID=?,doc_type=?,certified_doc_file_path = ? WHERE document_id = ?" ;
    private static final String SELECT = "SELECT * FROM lectureprofessordocupload WHERE document_id=? and projectID = ?";
    private static final String SELECT_SPECIFIED_DOC = "SELECT * FROM lectureprofessordocupload WHERE document_id=? ";

    @Override
    public LectureProfessorUploadForm query(int projectID) {
        Connection connection = dbConnection.getConnection();

        LectureProfessorUploadForm lectureProfessorUploadForm = new LectureProfessorUploadForm(projectID);
        List<LectureProfessorUpload> lectureProfessorUpload_list = new ArrayList<>() ;

        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DOCS_WITH_SPECIFIED_PROJECT_ID))
        {
            preparedStatement.setInt(1,projectID);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                LectureProfessorUpload lpefc = null;
                lpefc = new LectureProfessorUpload();
                lpefc.setDocument_id( UUID.fromString(resultSet.getString("document_id")));
                lpefc.setProjectID( resultSet.getInt("projectID"));
                lpefc.setDocType( resultSet.getString("doc_type"));
                lpefc.setCertifiedDocFilePath(resultSet.getString("certified_doc_file_path"));

                lectureProfessorUpload_list.add(lpefc);
            }
            lectureProfessorUploadForm.setLectureProfessorUploadList(lectureProfessorUpload_list);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return lectureProfessorUploadForm;
    }

    @Override
    public void update(LectureProfessorUpload object) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SPECIFIED_CERTIFIED_FILE_DATA))
        {
            preparedStatement.setInt(1,object.getProjectID());
            preparedStatement.setString(2,object.getDocType());
            preparedStatement.setString(3,object.getCertifiedDocFilePath());
            preparedStatement.setString(4,object.getDocument_id().toString());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(LectureProfessorUpload object) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setInt(1,object.getProjectID());
            preparedStatement.setString(2,object.getDocType());
            preparedStatement.setString(3,object.getCertifiedDocFilePath());
            preparedStatement.setString(4,object.getDocument_id().toString());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(LectureProfessorUpload object) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,object.getDocument_id().toString());
            preparedStatement.setInt(2,object.getProjectID());
            resultSet = preparedStatement.executeQuery();

            int size = 0;

            while(resultSet.next()) {
                size++;
            }

            if(size == 0) {
                insert(object);
            }
            else {
                update(object);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public LectureProfessorUpload query_specified_certified_document(String doc_id) {
        Connection connection = dbConnection.getConnection();
        LectureProfessorUpload item = new LectureProfessorUpload();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SPECIFIED_DOC))
        {
            preparedStatement.setString(1,doc_id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            if ( resultSet.next() ) {
                item.setProjectID( resultSet.getInt("projectID"));
                item.setDocType( resultSet.getString("doc_type"));
                item.setCertifiedDocFilePath( resultSet.getString("certified_doc_file_path"));
                item.setDocument_id(UUID.fromString(resultSet.getString("document_id")));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }





}
