package Dao.Admin.Impl;

import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.Admin.AwardYearDAO;
import com.alibaba.fastjson.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AwardYearDAOImpl implements AwardYearDAO {
    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT = "INSERT INTO award_year (award_name, year1, year2, year3, year4, year5) " +
            "VALUES(?,?,?,?,?,?) ";
    private static final String SELECT = "SELECT * FROM award_year";
    private static final String SELECT_AWARD_YEARS = "SELECT * FROM award_year WHERE award_name=?";
    private static final String DELETE = "DELETE FROM award_year";


    @Override
    public JSONObject getAwardsYears() {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        JSONObject awardsYears = new JSONObject();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                JSONObject jsonObject = new JSONObject();
                for(int i=1; i<=5; i++){
                    jsonObject.put("year"+i, resultSet.getInt("year"+i));
                }
                awardsYears.put( resultSet.getString("award_name"), jsonObject );
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return awardsYears;
    }

    @Override
    public fr.opensagres.xdocreport.document.json.JSONObject getSpecificAwardYears(String awardName) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        fr.opensagres.xdocreport.document.json.JSONObject awardYears = new fr.opensagres.xdocreport.document.json.JSONObject();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_AWARD_YEARS))
        {
            preparedStatement.setString(1, awardName);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                for(int i=1; i<=5; i++){
                    awardYears.put("year"+i, resultSet.getInt("year"+i));
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return awardYears;
    }

    @Override
    public void saveAwardsYears(JSONObject jsonObject) {
        delete();
        jsonObject.forEach((key, value) -> {
            String awardName = key;
            JSONObject years = (JSONObject) value;
            if(years.size()>0){
                insert(awardName, years);
            }
        });
    }

    private void delete(){
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE))
        {
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void insert(String awardName, JSONObject jsonObject){
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setString(1, awardName);
            for(int i=2; i<=6; i++){
                preparedStatement.setInt(i,jsonObject.getIntValue("year" + (i - 1)));
            }
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
