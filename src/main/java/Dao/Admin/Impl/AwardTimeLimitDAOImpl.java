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
    private static final String INSERT_OBJECT = "INSERT INTO awardtimelimit (s1,s2,s3,s4,s5,s6,s7,s8,s9,l1,l2,l3,l4,l5,l6,l7,l8,l9,fwciOfFiveYear,fwciOfThreeYear,h5Index) " +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
    private static final String GET_OBJECT = "SELECT * FROM awardtimelimit";
    private static final String DELETE_OBJECT = "DELETE FROM awardtimelimit";

    @Override
    public void save(AwardTimeLimit object) {
        delete();
        insert(object);

    }

    public AwardTimeLimit get(){
        Connection connection = dbConnection.getConnection();
        AwardTimeLimit result = new AwardTimeLimit();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_OBJECT)) {
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
                    result.setL9(resultSet.getDate("l9"));
                    result.setS1(resultSet.getDate("s1"));
                    result.setS2(resultSet.getDate("s2"));
                    result.setS3(resultSet.getDate("s3"));
                    result.setS4(resultSet.getDate("s4"));
                    result.setS5(resultSet.getDate("s5"));
                    result.setS6(resultSet.getDate("s6"));
                    result.setS7(resultSet.getDate("s7"));
                    result.setS8(resultSet.getDate("s8"));
                    result.setS9(resultSet.getDate("s9"));
                    result.setFwciOfFiveYear(resultSet.getDouble("fwciOfFiveYear"));
                    result.setFwciOfThreeYear(resultSet.getDouble("fwciOfThreeYear"));
                    result.setH5Index(resultSet.getDouble("h5Index"));
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

    private void insert(AwardTimeLimit object){
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
            preparedStatement.setDate(9,object.getS9());
            preparedStatement.setDate(10,object.getL1());
            preparedStatement.setDate(11,object.getL2());
            preparedStatement.setDate(12,object.getL3());
            preparedStatement.setDate(13,object.getL4());
            preparedStatement.setDate(14,object.getL5());
            preparedStatement.setDate(15,object.getL6());
            preparedStatement.setDate(16,object.getL7());
            preparedStatement.setDate(17,object.getL8());
            preparedStatement.setDate(18,object.getL9());
            preparedStatement.setDouble(19,object.getFwciOfFiveYear());
            preparedStatement.setDouble(20,object.getFwciOfThreeYear());
            preparedStatement.setDouble(21,object.getH5Index());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
