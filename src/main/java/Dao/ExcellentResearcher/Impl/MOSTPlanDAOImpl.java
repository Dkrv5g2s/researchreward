package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.PersonalInformation.MOSTPlan;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.MOSTPlanDAO;

import java.sql.*;

public class MOSTPlanDAOImpl implements MOSTPlanDAO {

    private static final String DELETE_OBJECT = "DELETE FROM mostplan WHERE projectId=?";
    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_SQL = "INSERT INTO mostplan (planName, planNumber, startTime, lastTime, projectId) values (?,?,?,?,?) ON DUPLICATE KEY UPDATE " +
            "planName=?, planNumber=?, startTime=?, lastTime=?";

    @Override
    public void save(MOSTPlan object) {
        delete(object.getProjectId());
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL))
        {
            preparedStatement.setString(1,object.getPlanName());
            preparedStatement.setString(2,object.getPlanNumber());
            preparedStatement.setDate(3, object.getStartTime() == null ? null : new Date(object.getStartTime().getTime()));
            preparedStatement.setDate(4, object.getLastTime() == null ? null : new Date(object.getLastTime().getTime()));
            preparedStatement.setInt(5,object.getProjectId());
            preparedStatement.setString(6,object.getPlanName());
            preparedStatement.setInt(7,object.getProjectId());
            preparedStatement.setDate(8, object.getStartTime() == null ? null : new Date(object.getStartTime().getTime()));
            preparedStatement.setDate(9, object.getLastTime() == null ? null : new Date(object.getLastTime().getTime()));

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MOSTPlan get(int projectId) {

        Connection connection = dbConnection.getConnection();
        MOSTPlan mostPlan = new MOSTPlan();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mostplan WHERE projectId = ?"))
        {
            preparedStatement.setInt(1,projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    mostPlan.setPlanName(resultSet.getString("planName"));
                    mostPlan.setPlanNumber(resultSet.getString("planNumber"));
                    mostPlan.setStartTime(resultSet.getDate("startTime"));
                    mostPlan.setLastTime(resultSet.getDate("lastTime"));
                    mostPlan.setProjectId(resultSet.getInt("projectId"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mostPlan;
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
