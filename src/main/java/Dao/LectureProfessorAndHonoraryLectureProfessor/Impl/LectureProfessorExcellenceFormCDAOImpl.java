package Dao.LectureProfessorAndHonoraryLectureProfessor.Impl;
import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormC;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormCDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LectureProfessorExcellenceFormCDAOImpl implements LectureProfessorExcellenceFormCDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM lectureprofessorexcellenceformc WHERE projectID = ?";
    private static final String INSERT =
            "INSERT INTO lectureprofessorexcellenceformc (projectID,usernum,recommendationReason)"+
                    " values(?,?,?)";
    private static final String UPDATE =
            "UPDATE lectureprofessorexcellenceformc "
                    + "SET usernum = ?, recommendationReason = ?" +
                    " WHERE projectID = ?";
    @Override
    public void save(LectureProfessorExcellenceFormC object,String projectID) {
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
    public LectureProfessorExcellenceFormC show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                LectureProfessorExcellenceFormC lpefc = null;
                lpefc = new LectureProfessorExcellenceFormC(
                        resultSet.getString("usernum"),
                        resultSet.getString("recommendationReason"));

                return lpefc;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public void insert(Connection connection,LectureProfessorExcellenceFormC object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,projectID);
            preparedStatement.setString(2,object.getUsernum());
            preparedStatement.setString(3,object.getRecommendationReason());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Connection connection,LectureProfessorExcellenceFormC object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,object.getUsernum());
            preparedStatement.setString(2,object.getRecommendationReason());
            preparedStatement.setString(3,projectID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
