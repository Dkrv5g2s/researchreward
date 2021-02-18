package Dao.SunshineScholarshipAward.Impl;


import Bean.SunshineScholarshipAward.FWCIPrizeInfomation;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.SunshineScholarshipAward.FWCIPrizeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FWCIPrizeDAOImpl implements FWCIPrizeDAO{
    final private DBConnection dbConnection = new DBConnectionImpl();
    private static final String GET_OBJECT = "SELECT * FROM sunshine_scholarship_award_fwci_prize WHERE id=?";

    private static final String INSERT_OBJECT = "INSERT INTO sunshine_scholarship_award_fwci_prize " +
            "(under_one_point_three_prize,under_one_point_five_prize,under_one_point_eight_prize,under_two_point_two_prize,over_two_point_two_prize,ntut_fwci_value) " +
            "values(?,?,?,?,?,?) ON DUPLICATE KEY UPDATE " +
            "under_one_point_three_prize=?,under_one_point_five_prize=?,under_one_point_eight_prize=?,under_two_point_two_prize=?,over_two_point_two_prize=?,ntut_fwci_value=?;";


    @Override
    public void save(FWCIPrizeInfomation object){
        //this can only use in when userRole is admin
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setString(1,object.getUnderOnePointThreePrize());
            preparedStatement.setString(2,object.getUnderOnePointFivePrize());
            preparedStatement.setString(3,object.getUnderOnePointEightPrize());
            preparedStatement.setString(4,object.getUnderTwoPointTwoPrize());
            preparedStatement.setString(5,object.getOverTwoPointTwoPrize());
            preparedStatement.setString(6,object.getFWCIValueOfNTUT());
            preparedStatement.setString(7,object.getUnderOnePointThreePrize());
            preparedStatement.setString(8,object.getUnderOnePointFivePrize());
            preparedStatement.setString(9,object.getUnderOnePointEightPrize());
            preparedStatement.setString(10,object.getUnderTwoPointTwoPrize());
            preparedStatement.setString(11,object.getOverTwoPointTwoPrize());
            preparedStatement.setString(12,object.getFWCIValueOfNTUT());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public FWCIPrizeInfomation get(){
        Connection connection = dbConnection.getConnection();
        FWCIPrizeInfomation result = new FWCIPrizeInfomation();
        int id = 1;
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_OBJECT))
        {
            preparedStatement.setInt(1,id); //fixed id

            try (ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()) {
                    result.setUnderOnePointThreePrize(rs.getString("under_one_point_three_prize"));
                    result.setUnderOnePointFivePrize(rs.getString("under_one_point_five_prize"));
                    result.setUnderOnePointEightPrize(rs.getString("under_one_point_eight_prize"));
                    result.setUnderTwoPointTwoPrize(rs.getString("under_two_point_two_prize"));
                    result.setOverTwoPointTwoPrize(rs.getString("over_two_point_two_prize"));
                    result.setFWCIValueOfNTUT(rs.getString("ntut_fwci_value"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
