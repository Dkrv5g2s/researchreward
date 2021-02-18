package Dao.LectureProfessorAndHonoraryLectureProfessor.Impl;
import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormD;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormDDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LectureProfessorExcellenceFormDDAOImpl implements LectureProfessorExcellenceFormDDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM lectureprofessorExcellenceFormD WHERE projectID = ?";
    private static final String INSERT =
            "INSERT INTO lectureprofessorExcellenceFormD (projectID, usernum, depart, name, speechTime, payment, performance)"+
                    " values(?,?,?,?,?,?,?)";
    private static final String UPDATE =
            "UPDATE lectureprofessorExcellenceFormD "
                    + "SET usernum = ?, depart = ?, name = ?, speechTime = ?, payment = ?, performance = ?" +
                    " WHERE projectID = ?";
    @Override
    public void save(LectureProfessorExcellenceFormD object,String projectID) {
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
    public LectureProfessorExcellenceFormD show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                LectureProfessorExcellenceFormD lpefd = null;
                lpefd = new LectureProfessorExcellenceFormD(
                        resultSet.getString("usernum"),
                        resultSet.getString("depart"),
                        resultSet.getString("name"),
                        resultSet.getString("speechTime"),
                        resultSet.getString("payment"),
                        resultSet.getString("performance"));
                return lpefd;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public void insert(Connection connection,LectureProfessorExcellenceFormD object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,projectID);
            preparedStatement.setString(2,object.getUsernum());
            preparedStatement.setString(3,object.getDepart());
            preparedStatement.setString(4,object.getName());
            preparedStatement.setString(5,object.getSpeechTime());
            preparedStatement.setString(6,object.getPayment());
            preparedStatement.setString(7,object.getPerformance());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Connection connection,LectureProfessorExcellenceFormD object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,object.getUsernum());
            preparedStatement.setString(2,object.getDepart());
            preparedStatement.setString(3,object.getName());
            preparedStatement.setString(4,object.getSpeechTime());
            preparedStatement.setString(5,object.getPayment());
            preparedStatement.setString(6,object.getPerformance());
            preparedStatement.setString(7,projectID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
