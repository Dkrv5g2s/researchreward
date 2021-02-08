package Dao.OutstandingResearchAward.OutstandingResearchAwardTableA.Impl;

import Bean.OutstandingResearchAward.OutstandingResearchAwardTableA.CoopProject;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.OutstandingResearchAward.OutstandingResearchAwardTableA.CoopProjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoopProjectDAOImpl implements CoopProjectDAO {

    private DBConnection dbConnection = new DBConnectionImpl();//TODO change database table
    private static final String SELECT = "SELECT * FROM coopproject WHERE projectID = ?";
    private static final String INSERT =
            "INSERT INTO coopproject (projectID,coop_project_count1,coop_project_count2,coop_project_count3,coop_project_count_total," +
                    "coop_project_management1,coop_project_management2,coop_project_management3,coop_project_management_total," +
                    "coop_project_money1,coop_project_money2,coop_project_money3,coop_project_money_total," +
                    "coop_project_point1,coop_project_point2,coop_project_point3,coop_project_point_total)"+
                    " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE =
            "UPDATE coopproject "+
                    "SET coop_project_count1 = ?,coop_project_count2 = ?,coop_project_count3 = ?,coop_project_count_total = ?," +
                    "coop_project_management1 = ?,coop_project_management2 = ?,coop_project_management3 = ?,coop_project_management_total = ?," +
                    "coop_project_money1 = ?,coop_project_money2 = ?,coop_project_money3 = ?,coop_project_money_total = ?," +
                    "coop_project_point1 = ?,coop_project_point2 = ?,coop_project_point3 = ?,coop_project_point_total = ?  "+
                    " WHERE projectID = ?";
    @Override
    public void save(CoopProject object, String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                insert(connection,object,projectID);
            }
            else {
                update(connection,object,projectID);
            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CoopProject get(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                CoopProject cp = null;
                cp = new CoopProject(
                        resultSet.getString("coop_project_count1"),
                        resultSet.getString("coop_project_count2"),
                        resultSet.getString("coop_project_count3"),
                        resultSet.getString("coop_project_count_total"),
                        resultSet.getString("coop_project_management1"),
                        resultSet.getString("coop_project_management2"),
                        resultSet.getString("coop_project_management3"),
                        resultSet.getString("coop_project_management_total"),
                        resultSet.getString("coop_project_money1"),
                        resultSet.getString("coop_project_money2"),
                        resultSet.getString("coop_project_money3"),
                        resultSet.getString("coop_project_money_total"),
                        resultSet.getString("coop_project_point1"),
                        resultSet.getString("coop_project_point2"),
                        resultSet.getString("coop_project_point3"),
                        resultSet.getString("coop_project_point_total"));
                return cp;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public void insert(Connection connection,CoopProject object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,projectID);
            preparedStatement.setString(2,object.getCoop_project_count1());
            preparedStatement.setString(3,object.getCoop_project_count2());
            preparedStatement.setString(4,object.getCoop_project_count3());
            preparedStatement.setString(5,object.getCoop_project_count_total());
            preparedStatement.setString(6,object.getCoop_project_management1());
            preparedStatement.setString(7,object.getCoop_project_management2());
            preparedStatement.setString(8,object.getCoop_project_management3());
            preparedStatement.setString(9,object.getCoop_project_management_total());
            preparedStatement.setString(10,object.getCoop_project_money1());
            preparedStatement.setString(11,object.getCoop_project_money2());
            preparedStatement.setString(12,object.getCoop_project_money3());
            preparedStatement.setString(13,object.getCoop_project_money_total());
            preparedStatement.setString(14,object.getCoop_project_point1());
            preparedStatement.setString(15,object.getCoop_project_point2());
            preparedStatement.setString(16,object.getCoop_project_point3());
            preparedStatement.setString(17,object.getCoop_project_point_total());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Connection connection,CoopProject object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,object.getCoop_project_count1());
            preparedStatement.setString(2,object.getCoop_project_count2());
            preparedStatement.setString(3,object.getCoop_project_count3());
            preparedStatement.setString(4,object.getCoop_project_count_total());
            preparedStatement.setString(5,object.getCoop_project_management1());
            preparedStatement.setString(6,object.getCoop_project_management2());
            preparedStatement.setString(7,object.getCoop_project_management3());
            preparedStatement.setString(8,object.getCoop_project_management_total());
            preparedStatement.setString(9,object.getCoop_project_money1());
            preparedStatement.setString(10,object.getCoop_project_money2());
            preparedStatement.setString(11,object.getCoop_project_money3());
            preparedStatement.setString(12,object.getCoop_project_money_total());
            preparedStatement.setString(13,object.getCoop_project_point1());
            preparedStatement.setString(14,object.getCoop_project_point2());
            preparedStatement.setString(15,object.getCoop_project_point3());
            preparedStatement.setString(16,object.getCoop_project_point_total());
            preparedStatement.setString(17,projectID);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
