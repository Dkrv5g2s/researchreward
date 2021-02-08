package Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.Impl;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.OtherData;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.JuniorResearchInvestigator.JuniorResearchInvestigatorTableA.OtherDataDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OtherDataDAOImpl implements OtherDataDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM jri_otherdata WHERE projectID = ?";
    private static final String INSERT =
            "INSERT INTO jri_otherdata (projectID,year1,year2,year3,other_data,declaration,commit_date)" +
                    " values(?,?,?,?,?,?,?)";
    private static final String UPDATE =
            "UPDATE jri_otherdata "
                    + "SET year1 = ?,year2 = ?,year3 = ?,other_data = ?,declaration = ?,commit_date = ?"+
                    " WHERE projectID = ?";
    @Override
    public void save(OtherData object, String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                update(connection,object);
            }
            else {
                insert(connection,object);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OtherData show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                OtherData od = null;
                od = new OtherData(
                        resultSet.getString("year1"),
                        resultSet.getString("year2"),
                        resultSet.getString("year3"),
                        resultSet.getString("projectID"),
                        resultSet.getString("other_data"),
                        resultSet.getBoolean("declaration"),
                        resultSet.getString("commit_date"));
                return od;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insert(Connection connection,OtherData object) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1,object.getProjectID());
            preparedStatement.setString(2,object.getYear1());
            preparedStatement.setString(3,object.getYear2());
            preparedStatement.setString(4,object.getYear3());
            preparedStatement.setString(5,object.getOther_data());
            preparedStatement.setBoolean(6,object.getDeclaration());
            preparedStatement.setString(7,object.getCommit_date());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Connection connection,OtherData object) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,object.getYear1());
            preparedStatement.setString(2,object.getYear2());
            preparedStatement.setString(3,object.getYear3());
            preparedStatement.setString(4,object.getOther_data());
            preparedStatement.setBoolean(5,object.getDeclaration());
            preparedStatement.setString(6,object.getCommit_date());
            preparedStatement.setString(7,object.getProjectID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}