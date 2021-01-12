package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.PersonalInformation.Education;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.EducationDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EducationDAOImpl implements EducationDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO education (schoolName,major,degree,graduateYear,graduateMonth,userNumber) values (?,?,?,?,?,?)";

    @Override
    public void save(Education object) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setString(1,object.getSchoolName());
            preparedStatement.setString(2,object.getMajor());
            preparedStatement.setString(3,object.getDegree());
            preparedStatement.setString(4,object.getGraduateYear());
            preparedStatement.setString(5,object.getGraduateMonth());
            preparedStatement.setString(6,object.getUserNumber());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Education get(String userNumber) {
        Connection connection = dbConnection.getConnection();
        Education education = new Education();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM education WHERE userNumber = ?"))
        {
            preparedStatement.setString(1,userNumber);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();

                education.setSchoolName(resultSet.getString("schoolName"));
                education.setMajor(resultSet.getString("major"));
                education.setDegree(resultSet.getString("degree"));
                education.setGraduateYear(resultSet.getString("graduateYear"));
                education.setGraduateMonth(resultSet.getString("graduateMonth"));
                education.setUserNumber(resultSet.getString("userNumber"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return education;
    }
}
