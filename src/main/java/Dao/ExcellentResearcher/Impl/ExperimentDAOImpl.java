package Dao.ExcellentResearcher.Impl;

import Bean.ExcellentResearcher.PersonalInformation.Experiment;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.ExcellentResearcher.ExperimentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExperimentDAOImpl implements ExperimentDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_OBJECT = "INSERT INTO experiment (serviceOrganization,serviceDepartment,title,year,month,userNumber) values (?,?,?,?,?,?)";
//            "INSERT INTO education (schoolName,major,degree,graduateYear,graduateMonth,userNumber) values (?,?,?,?,?,?)";
    @Override
    public void save(Experiment object) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setString(1,object.getServiceOrganization());
            preparedStatement.setString(2,object.getServiceDepartment());
            preparedStatement.setString(3,object.getTitle());
            preparedStatement.setString(4,object.getYear());
            preparedStatement.setString(5,object.getMonth());
            preparedStatement.setString(6,object.getUserNumber());



            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
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
