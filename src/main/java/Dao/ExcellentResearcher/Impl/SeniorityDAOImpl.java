package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.Seniority;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.SeniorityDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeniorityDAOImpl implements SeniorityDAO {

    private DBConnection dbConnection = new DBConnectionImpl();

    @Override
    public void save(Seniority object) {

    }

    @Override
    public Seniority get(String userNumber) {
        Connection connection = dbConnection.getConnection();
        Seniority seniority = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM seniority WHERE userNumber = ?"))
        {
            preparedStatement.setString(1,userNumber);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();

                seniority = new Seniority(resultSet.getString("year"),
                        resultSet.getString("month"),
                        resultSet.getString("userNumber"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seniority;
    }
}
