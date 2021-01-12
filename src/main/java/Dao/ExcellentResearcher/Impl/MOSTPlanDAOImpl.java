package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.PersonalInformation.MOSTPlan;
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
            preparedStatement.setDate(3, object.getStartTime() == null ? null : new Date(object.getStartTime().getTime()));
            preparedStatement.setDate(4, object.getLastTime() == null ? null : new Date(object.getLastTime().getTime()));
            preparedStatement.setString(5,object.getUserNumber());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MOSTPlan get(String userNumber) {

        Connection connection = dbConnection.getConnection();
        MOSTPlan mostPlan = new MOSTPlan();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mostplan WHERE userNumber = ?"))
        {
            preparedStatement.setString(1,userNumber);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();

                mostPlan.setPlanName(resultSet.getString("planName"));
                mostPlan.setPlanNumber(resultSet.getString("planNumber"));
                mostPlan.setStartTime(resultSet.getDate("startTime"));
                mostPlan.setLastTime(resultSet.getDate("lastTime"));
                mostPlan.setUserNumber(resultSet.getString("userNumber"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mostPlan;
    }
}
