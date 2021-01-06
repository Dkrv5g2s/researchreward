package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.MOSTPlan;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.MOSTPlanDAO;

import java.sql.*;

public class MOSTPlanDAOImpl implements MOSTPlanDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_SQL = "INSERT INTO mostplan (planName, planNumber, startTime, lastTime, userNumber) values (?,?,?,?,?)";

    @Override
    public void save(MOSTPlan object) {

        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL))
        {
            preparedStatement.setString(1,object.getPlanName());
            preparedStatement.setString(2,object.getUserNumber());
            preparedStatement.setDate(3, (Date) object.getStartTime());
            preparedStatement.setDate(4, (Date) object.getLastTime());
            preparedStatement.setString(5,object.getUserNumber());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MOSTPlan get(String userNumber) {

        Connection connection = dbConnection.getConnection();
        MOSTPlan mostPlan = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mostplan WHERE userNumber = ?"))
        {
            preparedStatement.setString(1,userNumber);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();

                mostPlan = new MOSTPlan(resultSet.getString("planName"),
                        resultSet.getString("planNumber"),
                        resultSet.getDate("startTime"),
                        resultSet.getDate("lastName"),
                        resultSet.getString("number"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mostPlan;
    }
}
