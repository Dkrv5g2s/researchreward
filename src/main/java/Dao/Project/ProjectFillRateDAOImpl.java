package Dao.Project;

import Bean.Project.ProjectFillRate;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProjectFillRateDAOImpl implements ProjectFillRateDAO {
    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT_ALL = "SELECT * FROM project_fill_rate WHERE project_id = ?";
    private static final String SELECT = "SELECT * FROM project_fill_rate WHERE project_id = ? and column_name = ?";
    private static final String INSERT =
            "INSERT INTO project_fill_rate (project_id, column_name, fill_rate)"+
                    " values(?,?,?)";
    private static final String UPDATE =
            "UPDATE project_fill_rate "+
                    "SET fill_rate = ?"+
                    "WHERE project_id = ? and column_name = ?";


    @Override
    public List<ProjectFillRate> query(int projectId) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        List<ProjectFillRate> projectFillRateList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL))
        {
            preparedStatement.setInt(1, projectId);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                projectFillRateList.add(
                        new ProjectFillRate(
                                resultSet.getInt("project_id"),
                                resultSet.getString("column_name"),
                                resultSet.getDouble("fill_rate")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectFillRateList;
    }

    @Override
    public void save(ProjectFillRate projectFillRate) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setInt(1, projectFillRate.getProjectId());
            preparedStatement.setString(2, projectFillRate.getColumnName());

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                update(connection, projectFillRate);
            }
            else {
                insert(connection, projectFillRate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert(Connection connection, ProjectFillRate projectFillRate) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setInt(1,projectFillRate.getProjectId());
            preparedStatement.setString(2,projectFillRate.getColumnName());
            preparedStatement.setDouble(3,projectFillRate.getFillRate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void update(Connection connection, ProjectFillRate projectFillRate) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setDouble(1,projectFillRate.getFillRate());
            preparedStatement.setInt(2,projectFillRate.getProjectId());
            preparedStatement.setString(3,projectFillRate.getColumnName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
