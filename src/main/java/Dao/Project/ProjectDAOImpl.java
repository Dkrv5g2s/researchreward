package Dao.Project;

import Bean.Project.RewardProject;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {
    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_PROJECT = "INSERT INTO reward_project (staff_code,status,reward_type) values(?,?,?)";
    private static final String GET_PROJECT = "SELECT * FROM reward_project WHERE staff_code=? AND status=?";
    private static final String UPDATE_PROJECT_STATUS = "UPDATE reward_project SET status=? WHERE project_id =? AND staff_code=? ";
    private static final String DELETE_PROJECT = "DELETE FROM reward_project WHERE project_id = ? AND staff_code=?";
    @Override
    public void insertNewProject( String staff_code, String status, String reward_type ) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT))
        {
            preparedStatement.setString(1,staff_code);
            preparedStatement.setString(2,status);
            preparedStatement.setString(3,reward_type);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProject(int project_id,String staff_code) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PROJECT))
        {
            preparedStatement.setInt(1,project_id);
            preparedStatement.setString(2,staff_code);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateProjectStatus(RewardProject rewardProject) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROJECT_STATUS))
        {
            preparedStatement.setString(1,rewardProject.getStatus());
            preparedStatement.setInt(2,rewardProject.getProject_id());
            preparedStatement.setString(3,rewardProject.getStaff_code());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RewardProject> getProjects(String staffCode, String status) {
        Connection connection = dbConnection.getConnection();
        List<RewardProject> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_PROJECT))
        {
            preparedStatement.setString(1,staffCode);
            preparedStatement.setString(2,status);

            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    result.add(new RewardProject(resultSet.getInt("project_id"),
                            resultSet.getString("staff_code"),
                            resultSet.getString("status"),
                            resultSet.getString("reward_type")));
                }
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


}
