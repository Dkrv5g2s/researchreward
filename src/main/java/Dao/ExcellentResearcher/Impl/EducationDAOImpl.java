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

    private static final String DELETE_OBJECT = "DELETE FROM education WHERE projectId=?";
    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO education (schoolName,major,degree,graduateYear,graduateMonth,projectId) values (?,?,?,?,?,?) ON DUPLICATE KEY UPDATE " +
            "schoolName=?,major=?,degree=?,graduateYear=?,graduateMonth=?";

    @Override
    public void save(Education object) {
        delete(object.getProjectId());
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setString(1,object.getSchoolName());
            preparedStatement.setString(2,object.getMajor());
            preparedStatement.setString(3,object.getDegree());
            preparedStatement.setString(4,object.getGraduateYear());
            preparedStatement.setString(5,object.getGraduateMonth());
            preparedStatement.setInt(6,object.getProjectId());
            preparedStatement.setString(7,object.getSchoolName());
            preparedStatement.setString(8,object.getMajor());
            preparedStatement.setString(9,object.getDegree());
            preparedStatement.setString(10,object.getGraduateYear());
            preparedStatement.setString(11,object.getGraduateMonth());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Education get(int projectId) {
        Connection connection = dbConnection.getConnection();
        Education education = new Education();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM education WHERE projectId = ?"))
        {
            preparedStatement.setInt(1,projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    education.setSchoolName(resultSet.getString("schoolName"));
                    education.setMajor(resultSet.getString("major"));
                    education.setDegree(resultSet.getString("degree"));
                    education.setGraduateYear(resultSet.getString("graduateYear"));
                    education.setGraduateMonth(resultSet.getString("graduateMonth"));
                    education.setProjectId(resultSet.getInt("projectId"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return education;
    }

    private void delete(int projectId){

        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_OBJECT))
        {
            preparedStatement.setInt(1,projectId);

            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
