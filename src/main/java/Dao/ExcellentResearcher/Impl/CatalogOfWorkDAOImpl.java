package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.CatalogOfWork;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.CatalogOfWorkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CatalogOfWorkDAOImpl implements CatalogOfWorkDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO catalogofwork (userNumber, work) values (?,?)";


    @Override
    public void save(CatalogOfWork object) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setString(1,object.getUserNumber());
            preparedStatement.setString(2,object.getWork());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CatalogOfWork get(String userNumber) {
        return null;
    }
}
