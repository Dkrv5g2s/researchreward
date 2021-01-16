package Dao.Admin.Impl;

import Bean.Admin.AwardTimeLimit;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.Admin.AwardTimeLimitDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AwardTimeLimitDAOImpl implements AwardTimeLimitDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO awardtimelimit (s1,s2,s3,s4,s5,s6,s7,s8,l1,l2,l3,l4,l5,l6,l7,l8,userNumber,fwci) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
