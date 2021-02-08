package Dao.LectureProfessorAndHonoraryLectureProfessor.Impl;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorHonoraryApplicationForm;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorHonoraryApplicationFormDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LectureProfessorHonoraryApplicationFormDAOImpl implements LectureProfessorHonoraryApplicationFormDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM lectureProfessorHonoraryApplicationForm WHERE projectID = ?";
    private static final String INSERT =
            "INSERT INTO lectureProfessorHonoraryApplicationForm (projectID,usernum, name, jobAndDept, email, researchroomext, cellphone, indivisualEducation, recommendationReason)"+
                    " values(?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE =
            "UPDATE lectureProfessorHonoraryApplicationForm "
                    + "SET usernum = ?,name = ?,jobAndDept = ?,email = ?,researchroomext = ?,cellphone = ?,indivisualEducation = ?, recommendationReason = ?"+
                    " WHERE projectID = ?";
    @Override
    public void save(LectureProfessorHonoraryApplicationForm object,String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);
            resultSet = preparedStatement.executeQuery();

            int size = 0;

            while(resultSet.next()) {
                size++;
            }

            if(size == 0) {
                insert(connection,object,projectID);
            }
            else {
                update(connection,object,projectID);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public LectureProfessorHonoraryApplicationForm show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                LectureProfessorHonoraryApplicationForm lpaf = null;
                lpaf = new LectureProfessorHonoraryApplicationForm(
                        resultSet.getString("usernum"),
                        resultSet.getString("name"),
                        resultSet.getString("jobAndDept"),
                        resultSet.getString("email"),
                        resultSet.getString("researchroomext"),
                        resultSet.getString("cellphone"),
                        resultSet.getString("indivisualEducation"),
                        resultSet.getString("recommendationReason"));

                return lpaf;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public void insert(Connection connection,LectureProfessorHonoraryApplicationForm object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,projectID);
            preparedStatement.setString(2,object.getUsernum());
            preparedStatement.setString(3,object.getName());
            preparedStatement.setString(4,object.getJobAndDept());
            preparedStatement.setString(5,object.getEmail());
            preparedStatement.setString(6,object.getResearchroomext());
            preparedStatement.setString(7,object.getCellphone());
            preparedStatement.setString(8,object.getIndivisualEducation());
            preparedStatement.setString(9,object.getRecommendationReason());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Connection connection,LectureProfessorHonoraryApplicationForm object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,object.getUsernum());
            preparedStatement.setString(2,object.getName());
            preparedStatement.setString(3,object.getJobAndDept());
            preparedStatement.setString(4,object.getEmail());
            preparedStatement.setString(5,object.getResearchroomext());
            preparedStatement.setString(6,object.getCellphone());
            preparedStatement.setString(7,object.getIndivisualEducation());
            preparedStatement.setString(8,object.getRecommendationReason());
            preparedStatement.setString(9,projectID);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
