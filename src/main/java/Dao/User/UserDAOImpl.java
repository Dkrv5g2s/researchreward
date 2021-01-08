package Dao.User;

import Bean.User.User;
import DBConnection.DBConnection;
import Dao.User.UserDAO;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
//    private Logger logger = Logger.getLogger(UserDAO.class.getName());

    @Override
    public User get(String account, String password) {

        Connection connection = dbConnection.getConnection();
        User user = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM USER WHERE account = ? AND password = ?"))
        {
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();

                user = new User();
                user.setRole(resultSet.getString("role"));
                user.setNumber(resultSet.getString("number"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
