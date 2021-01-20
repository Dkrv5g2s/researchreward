package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.PersonalInformation.Seniority;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.SeniorityDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SeniorityDAOImpl implements SeniorityDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO seniority (year,month,projectId) values (?,?,?) ON DUPLICATE KEY UPDATE " +
            "year=?,month=?";

    @Override
    public void save(Seniority object) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setString(1,object.getYear());
            preparedStatement.setString(2,object.getMonth());
            preparedStatement.setInt(3,object.getProjectId());
            preparedStatement.setString(4,object.getYear());
            preparedStatement.setString(5,object.getMonth());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Seniority get(int projectId) {
        Connection connection = dbConnection.getConnection();
        Seniority seniority = new Seniority();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM seniority WHERE projectId = ?"))
        {
            preparedStatement.setInt(1,projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();

                seniority.setYear(resultSet.getString("year"));
                seniority.setMonth(resultSet.getString("month"));
                seniority.setProjectId(resultSet.getInt("projectId"));
            }catch (SQLException ex){
                ex.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seniority;
    }
}
