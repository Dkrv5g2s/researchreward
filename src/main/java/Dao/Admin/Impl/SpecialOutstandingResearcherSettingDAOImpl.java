package Dao.Admin.Impl;


import Bean.Admin.SpecialOutstandingResearcherSetting;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.Admin.SpecialOutstandingResearcherSettingDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecialOutstandingResearcherSettingDAOImpl implements SpecialOutstandingResearcherSettingDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO special_researcher_date_setting (seniority,mostStart,mostEnd,year) VALUES (?,?,?,?)";
    private static final String GET_OBJECT = "SELECT * FROM special_researcher_date_setting";
    private static final String DELETE_OBJECT = "DELETE FROM special_researcher_date_setting";

    @Override
    public void save(SpecialOutstandingResearcherSetting object) {
        delete();
        insert(object);
    }

    @Override
    public SpecialOutstandingResearcherSetting get() {

        Connection connection = dbConnection.getConnection();
        SpecialOutstandingResearcherSetting result = new SpecialOutstandingResearcherSetting();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_OBJECT)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    result.setSeniority(resultSet.getDate("seniority"));
                    result.setMostStart(resultSet.getDate("mostStart"));
                    result.setMostEnd(resultSet.getDate("mostEnd"));
                    result.setYear(resultSet.getInt("year"));
                }else{
                    return result;
                }
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private void delete(){
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_OBJECT))
        {
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert(SpecialOutstandingResearcherSetting object){
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setDate(1,object.getSeniority());
            preparedStatement.setDate(2,object.getMostStart());
            preparedStatement.setDate(3,object.getMostEnd());
            preparedStatement.setInt(4,object.getYear());


            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
