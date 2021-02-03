package Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.Impl;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.TechProject;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.TechProjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TechProjectDAOImpl implements TechProjectDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM jri_techproject WHERE projectID = ?";
    private static final String INSERT =
            "INSERT INTO jri_techproject (projectID,tech_project_count1,tech_project_count2,tech_project_count3,tech_project_count_total," +
                    "tech_project_money1,tech_project_money2,tech_project_money3,tech_project_money_total," +
                    "tech_project_point1,tech_project_point2,tech_project_point3,tech_project_point_total)"+
                    " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE =
            "UPDATE jri_techproject "
                    + "SET tech_project_count1 = ?,tech_project_count2 = ?,tech_project_count3 = ?,tech_project_count_total = ?," +
                    "tech_project_money1 = ?,tech_project_money2 = ?,tech_project_money3 = ?,tech_project_money_total = ?," +
                    "tech_project_point1 = ?,tech_project_point2 = ?,tech_project_point3 = ?,tech_project_point_total = ?  "+
                    " WHERE projectID = ?";
    @Override
    public void save(TechProject object, String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                update(connection,object,projectID);
            }
            else {
                insert(connection,object,projectID);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TechProject show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                TechProject tp = null;
                tp = new TechProject(
                        resultSet.getString("tech_project_count1"),
                        resultSet.getString("tech_project_count2"),
                        resultSet.getString("tech_project_count3"),
                        resultSet.getString("tech_project_count_total"),
                        resultSet.getString("tech_project_money1"),
                        resultSet.getString("tech_project_money2"),
                        resultSet.getString("tech_project_money3"),
                        resultSet.getString("tech_project_money_total"),
                        resultSet.getString("tech_project_point1"),
                        resultSet.getString("tech_project_point2"),
                        resultSet.getString("tech_project_point3"),
                        resultSet.getString("tech_project_point_total"));
                return tp;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(Connection connection,TechProject object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,projectID);
            preparedStatement.setString(2,object.getTech_project_count1());
            preparedStatement.setString(3,object.getTech_project_count2());
            preparedStatement.setString(4,object.getTech_project_count3());
            preparedStatement.setString(5,object.getTech_project_count_total());
            preparedStatement.setString(6,object.getTech_project_money1());
            preparedStatement.setString(7,object.getTech_project_money2());
            preparedStatement.setString(8,object.getTech_project_money3());
            preparedStatement.setString(9,object.getTech_project_money_total());
            preparedStatement.setString(10,object.getTech_project_point1());
            preparedStatement.setString(11,object.getTech_project_point2());
            preparedStatement.setString(12,object.getTech_project_point3());
            preparedStatement.setString(13,object.getTech_project_point_total());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Connection connection,TechProject object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,object.getTech_project_count1());
            preparedStatement.setString(2,object.getTech_project_count2());
            preparedStatement.setString(3,object.getTech_project_count3());
            preparedStatement.setString(4,object.getTech_project_count_total());
            preparedStatement.setString(5,object.getTech_project_money1());
            preparedStatement.setString(6,object.getTech_project_money2());
            preparedStatement.setString(7,object.getTech_project_money3());
            preparedStatement.setString(8,object.getTech_project_money_total());
            preparedStatement.setString(9,object.getTech_project_point1());
            preparedStatement.setString(10,object.getTech_project_point2());
            preparedStatement.setString(11,object.getTech_project_point3());
            preparedStatement.setString(12,object.getTech_project_point_total());
            preparedStatement.setString(13,projectID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
