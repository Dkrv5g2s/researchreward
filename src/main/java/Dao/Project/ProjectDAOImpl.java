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
    private static final String INSERT_PROJECT = "INSERT INTO reward_project (staff_code, status_id, reward_type) values(?,?,?)";
    private static final String GET_PERSONAL_PROJECTS = "SELECT * FROM reward_project LEFT JOIN reward_project_status on reward_project.status_id=reward_project_status.status_id WHERE staff_code=? AND reward_project.status_id BETWEEN ? AND ? ";
    private static final String GET_STATUS_ID_BY_PROJECT_ID = "SELECT status_id FROM reward_project WHERE project_id =?";
    private static final String GET_PROJECTS_FOR_ADMINS = "SELECT * FROM reward_project LEFT JOIN reward_project_status on reward_project.status_id=reward_project_status.status_id WHERE reward_project.status_id BETWEEN ? AND ?";
    private static final String UPDATE_PROJECT_STATUS = "UPDATE reward_project SET status_id=? WHERE project_id =?";
    private static final String DELETE_PROJECT = "DELETE FROM reward_project WHERE project_id = ? AND staff_code=?";
    private static final String GET_REWARD_TYPE = "SELECT reward_type FROM reward_project WHERE project_id=?";
    private static final String GET_MAX_STATUS_ID = "SELECT status_id FROM reward_project_status ORDER BY status_id DESC LIMIT 1";
    private static final String UPDATE_REASON_FOR_RETURN = "UPDATE reward_project SET reason_for_return=? WHERE project_id =?";
    private static final String UPDATE_DEPARTMENT_REVIEW_INFO = "UPDATE reward_project SET department_reviewer=?, department_review_time=NOW() WHERE project_id =?";
    private static final String UPDATE_COLLEGE_REVIEW_INFO = "UPDATE reward_project SET college_reviewer=?, college_review_time=NOW() WHERE project_id =?";
    private static final String UPDATE_INDUSTRY_LIAISON_OFFICE_REVIEW_INFO = "UPDATE reward_project SET industry_liaison_office_reviewer=?, industry_liaison_office_review_time=NOW() WHERE project_id =?";
    private static final String UPDATE_RESEARCH_AND_DEVELOPMENT_OFFICE_REVIEW_INFO = "UPDATE reward_project SET research_and_development_office_reviewer=?, research_and_development_office_review_time=NOW() WHERE project_id =?";

    @Override
    public void insertNewProject( String staff_code, int status_id, String reward_type ) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROJECT))
        {
            preparedStatement.setString(1,staff_code);
            preparedStatement.setInt(2,status_id);
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
    public void updateProjectStatus(int project_id, int status_id) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROJECT_STATUS))
        {
            preparedStatement.setInt(1, status_id);
            preparedStatement.setInt(2, project_id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RewardProject> getPersonalProjects(String staffCode, int begin_status_id, int end_status_id) {
        Connection connection = dbConnection.getConnection();
        List<RewardProject> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_PERSONAL_PROJECTS))
        {
            preparedStatement.setString(1,staffCode);
            preparedStatement.setInt(2,begin_status_id);
            preparedStatement.setInt(3,end_status_id);

            transformResultSetToList(result, preparedStatement);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int getStatusIdByProjectId(int project_id) {
        Connection connection = dbConnection.getConnection();
        int result = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_STATUS_ID_BY_PROJECT_ID))
        {
            preparedStatement.setInt(1,project_id);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    result = resultSet.getInt("status_id");
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<RewardProject> getProjectsForAdmins(int begin_status_id, int end_status_id) {
        Connection connection = dbConnection.getConnection();
        List<RewardProject> result = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_PROJECTS_FOR_ADMINS))
        {
            preparedStatement.setInt(1,begin_status_id);
            preparedStatement.setInt(2,end_status_id);

            transformResultSetToList(result, preparedStatement);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String getRewardType(int project_id) {
        Connection connection = dbConnection.getConnection();
        String result = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_REWARD_TYPE))
        {
            preparedStatement.setInt(1,project_id);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    result = resultSet.getString("reward_type");
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int getMaxStatusId() {
        Connection connection = dbConnection.getConnection();
        int result = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_MAX_STATUS_ID))
        {
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    result = resultSet.getInt("status_id");
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void updateReasonForReturn(int project_id, String reason_for_return) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_REASON_FOR_RETURN))
        {
            preparedStatement.setString(1, reason_for_return);
            preparedStatement.setInt(2, project_id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateReviewInfo(int project_id, String userRole, String userName) {
        String statement = getUpdateReviewInfoStatement(userRole);
        if (statement != null){
            Connection connection = dbConnection.getConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(statement))
            {
                preparedStatement.setString(1, userName);
                preparedStatement.setInt(2, project_id);
                preparedStatement.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void transformResultSetToList(List<RewardProject> result, PreparedStatement preparedStatement){
        try (ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()){
                result.add(new RewardProject(resultSet.getInt("project_id"),
                        resultSet.getString("staff_code"),
                        resultSet.getString("reward_type"),
                        resultSet.getInt("status_id"),
                        resultSet.getString("status"),
                        resultSet.getString("reason_for_return"),
                        resultSet.getString("department_reviewer"),
                        resultSet.getString("college_reviewer"),
                        resultSet.getString("industry_liaison_office_reviewer"),
                        resultSet.getString("research_and_development_office_reviewer"),
                        resultSet.getString("department_review_time"),
                        resultSet.getString("college_review_time"),
                        resultSet.getString("industry_liaison_office_review_time"),
                        resultSet.getString("research_and_development_office_review_time")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getUpdateReviewInfoStatement(String userRole) {
        switch (userRole) {
            case "department":
                return UPDATE_DEPARTMENT_REVIEW_INFO;
            case "college":
                return UPDATE_COLLEGE_REVIEW_INFO;
            case "industryLiaisonOffice":
                return UPDATE_INDUSTRY_LIAISON_OFFICE_REVIEW_INFO;
            case "researchAndDevelopmentOffice":
                return UPDATE_RESEARCH_AND_DEVELOPMENT_OFFICE_REVIEW_INFO;
        }
        return null;
    }
}
