package Dao.ExcellentResearcher.Impl;

import Bean.User.User;
import DBConnection.DBConnection;
import Dao.ExcellentResearcher.UserDAO;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;


public class UserDAOImpl implements UserDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
//    private Logger logger = Logger.getLogger(UserDAO.class.getName());

    @Override
    public User get(String account, String password) {

        Connection connection = dbConnection.getConnection();
        User user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER WHERE account = ? AND password = ?");
             ResultSet resultSet = preparedStatement.executeQuery())
        {
            resultSet.next();

            user = new User();
            user.setRole(resultSet.getString("role"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
