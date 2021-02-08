package Dao.Admin.Impl;

import Bean.Admin.BFormFormula;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.Admin.BFormFormulaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BFormFormulaDAOImpl implements BFormFormulaDAO {

    private static final String INSERT_OBJECT = "INSERT INTO weight (w1_1,w1_2,w1_3,w1_4,w1_5,w1_6,w1_7,w2_1,w2_2,w2_3,w2_4,w2_5,w2_6,w3_1,w3_2,w4_1,w4_2,w4_3,w4_4,w4_5,w4_6,w4_7,w4_8,w4_9,w4_10,w4_11,w4_12) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_OBJECT = "SELECT * FROM weight";
    private static final String DELETE_OBJECT = "DELETE FROM weight";
    private DBConnection dbConnection = new DBConnectionImpl();

    @Override
    public void save(BFormFormula object) {
        delete();
        insert(object);
    }



    @Override
    public BFormFormula get() {
        Connection connection = dbConnection.getConnection();
        BFormFormula result = new BFormFormula();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_OBJECT))
        {
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    result.setW1_1(resultSet.getDouble("w1_1"));
                    result.setW1_2(resultSet.getDouble("w1_2"));
                    result.setW1_3(resultSet.getDouble("w1_3"));
                    result.setW1_4(resultSet.getDouble("w1_4"));
                    result.setW1_5(resultSet.getDouble("w1_5"));
                    result.setW1_6(resultSet.getDouble("w1_6"));
                    result.setW1_7(resultSet.getDouble("w1_7"));
                    result.setW2_1(resultSet.getDouble("w2_1"));
                    result.setW2_2(resultSet.getDouble("w2_2"));
                    result.setW2_3(resultSet.getDouble("w2_3"));
                    result.setW2_4(resultSet.getDouble("w2_4"));
                    result.setW2_5(resultSet.getDouble("w2_5"));
                    result.setW2_6(resultSet.getDouble("w2_6"));
                    result.setW3_1(resultSet.getDouble("w3_1"));
                    result.setW3_2(resultSet.getDouble("w3_2"));
                    result.setW4_1(resultSet.getDouble("w4_1"));
                    result.setW4_2(resultSet.getDouble("w4_2"));
                    result.setW4_3(resultSet.getDouble("w4_3"));
                    result.setW4_4(resultSet.getDouble("w4_4"));
                    result.setW4_5(resultSet.getDouble("w4_5"));
                    result.setW4_6(resultSet.getDouble("w4_6"));
                    result.setW4_7(resultSet.getDouble("w4_7"));
                    result.setW4_8(resultSet.getDouble("w4_8"));
                    result.setW4_9(resultSet.getDouble("w4_9"));
                    result.setW4_10(resultSet.getDouble("w4_10"));
                    result.setW4_11(resultSet.getDouble("w4_11"));
                    result.setW4_12(resultSet.getDouble("w4_12"));
                }
            }


            preparedStatement.executeQuery();
            connection.close();
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

    private void insert(BFormFormula object){
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setDouble(1,object.getW1_1());
            preparedStatement.setDouble(2,object.getW1_2());
            preparedStatement.setDouble(3,object.getW1_3());
            preparedStatement.setDouble(4,object.getW1_4());
            preparedStatement.setDouble(5,object.getW1_5());
            preparedStatement.setDouble(6,object.getW1_6());
            preparedStatement.setDouble(7,object.getW1_7());
            preparedStatement.setDouble(8,object.getW2_1());
            preparedStatement.setDouble(9,object.getW2_2());
            preparedStatement.setDouble(10,object.getW2_3());
            preparedStatement.setDouble(11,object.getW2_4());
            preparedStatement.setDouble(12,object.getW2_5());
            preparedStatement.setDouble(13,object.getW2_6());
            preparedStatement.setDouble(14,object.getW3_1());
            preparedStatement.setDouble(15,object.getW3_2());
            preparedStatement.setDouble(16,object.getW4_1());
            preparedStatement.setDouble(17,object.getW4_2());
            preparedStatement.setDouble(18,object.getW4_3());
            preparedStatement.setDouble(19,object.getW4_4());
            preparedStatement.setDouble(20,object.getW4_5());
            preparedStatement.setDouble(21,object.getW4_6());
            preparedStatement.setDouble(22,object.getW4_7());
            preparedStatement.setDouble(23,object.getW4_8());
            preparedStatement.setDouble(24,object.getW4_9());
            preparedStatement.setDouble(25,object.getW4_10());
            preparedStatement.setDouble(26,object.getW4_11());
            preparedStatement.setDouble(27,object.getW4_12());




            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
