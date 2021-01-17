package Dao.Admin.Impl;

import Bean.Admin.AwardTimeLimit;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.Admin.AwardTimeLimitDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AwardTimeLimitDAOImpl implements AwardTimeLimitDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO awardtimelimit (s1,s2,s3,s4,s5,s6,s7,s8,l1,l2,l3,l4,l5,l6,l7,l8,userNumber,fwci) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE " +
            "s1=?,s2=?,s3=?,s4=?,s5=?,s6=?,s7=?,s8=?,l1=?,l2=?,l3=?,l4=?,l5=?,l6=?,l7=?,l8=?,fwci=?";
    private static final String GET_OBJECT = "SELECT * FROM awardtimelimit WHERE userNumber = ?";
    @Override
    public void save(AwardTimeLimit object) {

        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setDate(1,object.getS1());
            preparedStatement.setDate(2,object.getS2());
            preparedStatement.setDate(3,object.getS3());
            preparedStatement.setDate(4,object.getS4());
            preparedStatement.setDate(5,object.getS5());
            preparedStatement.setDate(6,object.getS6());
            preparedStatement.setDate(7,object.getS7());
            preparedStatement.setDate(8,object.getS8());
            preparedStatement.setDate(9,object.getL1());
            preparedStatement.setDate(10,object.getL2());
            preparedStatement.setDate(11,object.getL3());
            preparedStatement.setDate(12,object.getL4());
            preparedStatement.setDate(13,object.getL5());
            preparedStatement.setDate(14,object.getL6());
            preparedStatement.setDate(15,object.getL7());
            preparedStatement.setDate(16,object.getL8());
            preparedStatement.setString(17,object.getUserNumber());
            preparedStatement.setDouble(18,object.getFwci());
            preparedStatement.setDate(19,object.getS1());
            preparedStatement.setDate(20,object.getS2());
            preparedStatement.setDate(21,object.getS3());
            preparedStatement.setDate(22,object.getS4());
            preparedStatement.setDate(23,object.getS5());
            preparedStatement.setDate(24,object.getS6());
            preparedStatement.setDate(25,object.getS7());
            preparedStatement.setDate(26,object.getS8());
            preparedStatement.setDate(27,object.getL1());
            preparedStatement.setDate(28,object.getL2());
            preparedStatement.setDate(29,object.getL3());
            preparedStatement.setDate(30,object.getL4());
            preparedStatement.setDate(31,object.getL5());
            preparedStatement.setDate(32,object.getL6());
            preparedStatement.setDate(33,object.getL7());
            preparedStatement.setDate(34,object.getL8());
            preparedStatement.setDouble(35,object.getFwci());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AwardTimeLimit get(String userNumber){
        Connection connection = dbConnection.getConnection();
        AwardTimeLimit result = new AwardTimeLimit();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_OBJECT)) {
            preparedStatement.setString(1, userNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    result.setL1(resultSet.getDate("l1"));
                    result.setL2(resultSet.getDate("l2"));
                    result.setL3(resultSet.getDate("l3"));
                    result.setL4(resultSet.getDate("l4"));
                    result.setL5(resultSet.getDate("l5"));
                    result.setL6(resultSet.getDate("l6"));
                    result.setL7(resultSet.getDate("l7"));
                    result.setL8(resultSet.getDate("l8"));
                    result.setS1(resultSet.getDate("s1"));
                    result.setS2(resultSet.getDate("s2"));
                    result.setS3(resultSet.getDate("s3"));
                    result.setS4(resultSet.getDate("s4"));
                    result.setS5(resultSet.getDate("s5"));
                    result.setS6(resultSet.getDate("s6"));
                    result.setS7(resultSet.getDate("s7"));
                    result.setS8(resultSet.getDate("s8"));
                    result.setFwci(resultSet.getDouble("fwci"));
                    result.setUserNumber(resultSet.getString("userNumber"));
                }else{
                    return result;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
