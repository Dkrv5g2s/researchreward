package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.CatalogOfWork;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.CatalogOfWorkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CatalogOfWorkDAOImpl implements CatalogOfWorkDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO catalogofwork (userNumber, work) values (?,?) ON DUPLICATE KEY UPDATE " +
            "work = ?";
    private static final String GET_OBJECT = "SELECT * FROM catalogofwork WHERE userNumber=?";

    @Override
    public void save(CatalogOfWork object) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setString(1,object.getUserNumber());
            preparedStatement.setString(2,object.getWork());
            preparedStatement.setString(3,object.getWork());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CatalogOfWork get(String userNumber) {
        Connection connection = dbConnection.getConnection();
        CatalogOfWork catalogOfWork = new CatalogOfWork();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_OBJECT))
        {
            preparedStatement.setString(1,userNumber);

            try (ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()) {
                    catalogOfWork.setWork(rs.getString("work"));
                    catalogOfWork.setUserNumber(rs.getString("userNumber"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return catalogOfWork;
    }
}
