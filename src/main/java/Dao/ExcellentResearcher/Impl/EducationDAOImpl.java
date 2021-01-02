package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.Education;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.EducationDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EducationDAOImpl implements EducationDAO {

    private DBConnection dbConnection = new DBConnectionImpl();

    @Override
    public void save(Education object) {

    }

    @Override
    public Education get(String userNumber) {
        Connection connection = dbConnection.getConnection();
        Education education = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM education WHERE userNumber = ?"))
        {
            preparedStatement.setString(1,userNumber);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();

                education = new Education(resultSet.getString("schoolName"),
                        resultSet.getString("major"),
                        resultSet.getString("degree"),
                        resultSet.getString("graduateYear"),
                        resultSet.getString("graduateMonth"),
                        resultSet.getString("userNumber"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return education;
    }
}
