package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.MOSTPlan;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.MOSTPlanDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MOSTPlanDAOImpl implements MOSTPlanDAO {

    private DBConnection dbConnection = new DBConnectionImpl();

    @Override
    public void save(MOSTPlan object) {

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
