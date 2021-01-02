package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.Experiment;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.ExperimentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExperimentDAOImpl implements ExperimentDAO {

    private DBConnection dbConnection = new DBConnectionImpl();

    @Override
    public void save(Experiment object) {

    }

    @Override
    public Experiment get(String userNumber) {
        Connection connection = dbConnection.getConnection();
        Experiment experiment = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM experiment WHERE userNumber = ?"))
        {
            preparedStatement.setString(1,userNumber);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();

                experiment = new Experiment(resultSet.getString("serviceOrganization"),
                        resultSet.getString("serviceDepartment"),
                        resultSet.getString("title"),
                        resultSet.getString("year"),
                        resultSet.getString("month"),
                        resultSet.getString("userNumber"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return experiment;
    }
}
