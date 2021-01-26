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
    private static final String INSERT_OBJECT = "INSERT INTO experiment (serviceOrganization,serviceDepartment,title,year,month,projectId) values (?,?,?,?,?,?) ON DUPLICATE KEY UPDATE " +
            "serviceOrganization=?,serviceDepartment=?,title=?,year=?,month=?";

    @Override
    public void save(Experiment object) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OBJECT))
        {
            preparedStatement.setString(1,object.getServiceOrganization());
            preparedStatement.setString(2,object.getServiceDepartment());
            preparedStatement.setString(3,object.getPastTitle());
            preparedStatement.setString(4,object.getPastYear());
            preparedStatement.setString(5,object.getPastMonth());
            preparedStatement.setInt(6,object.getProjectId());
            preparedStatement.setString(7,object.getServiceOrganization());
            preparedStatement.setString(8,object.getServiceDepartment());
            preparedStatement.setString(9,object.getPastTitle());
            preparedStatement.setString(10,object.getPastYear());
            preparedStatement.setString(11,object.getPastMonth());


            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Experiment get(int projectId) {
        Connection connection = dbConnection.getConnection();
        Experiment experiment = new Experiment();

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM experiment WHERE projectId = ?"))
        {
            preparedStatement.setInt(1,projectId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    experiment.setServiceOrganization(resultSet.getString("serviceOrganization"));
                    experiment.setServiceDepartment(resultSet.getString("serviceDepartment"));
                    experiment.setPastTitle(resultSet.getString("title"));
                    experiment.setPastYear(resultSet.getString("year"));
                    experiment.setPastMonth(resultSet.getString("month"));
                    experiment.setProjectId(resultSet.getInt("projectId"));
                }
            }catch (SQLException ex){
                ex.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return experiment;
    }
}
