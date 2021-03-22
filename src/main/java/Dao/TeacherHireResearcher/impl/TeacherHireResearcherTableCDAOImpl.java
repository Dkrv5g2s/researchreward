package Dao.TeacherHireResearcher.impl;

import Bean.TeacherHireResearcher.TeacherHireResearcherTableC;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.TeacherHireResearcher.TeacherHireResearcherTableCDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherHireResearcherTableCDAOImpl implements TeacherHireResearcherTableCDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM teacher_hire_researcher_table_c WHERE reward_project_id = ?";
    private static final String INSERT = "INSERT INTO teacher_hire_researcher_table_c (reward_project_id, num_of_performance_period) values(?,?)";
    private static final String UPDATE = "UPDATE teacher_hire_researcher_table_c SET num_of_performance_period = ? WHERE reward_project_id = ?";

    @Override
    public void save(TeacherHireResearcherTableC teacherHireResearcherTableC) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setInt(1, teacherHireResearcherTableC.getRewardProjectId());
            resultSet = preparedStatement.executeQuery();

            int size = 0;

            while(resultSet.next()) {
                size++;
            }

            if(size == 0) {
                insert(connection,teacherHireResearcherTableC);
            }
            else {
                update(connection,teacherHireResearcherTableC);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TeacherHireResearcherTableC get(int rewardProjectId) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        TeacherHireResearcherTableC teacherHireResearcherTableC = new TeacherHireResearcherTableC();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setInt(1, rewardProjectId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                teacherHireResearcherTableC.setRewardProjectId(resultSet.getInt("reward_project_id"));
                teacherHireResearcherTableC.setNumOfPerformancePeriod(resultSet.getString("num_of_performance_period"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacherHireResearcherTableC;
    }

    private void insert(Connection connection, TeacherHireResearcherTableC teacherHireResearcherTableC) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setInt(1,teacherHireResearcherTableC.getRewardProjectId());
            preparedStatement.setString(2,teacherHireResearcherTableC.getNumOfPerformancePeriod());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void update(Connection connection,TeacherHireResearcherTableC teacherHireResearcherTableC) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,teacherHireResearcherTableC.getNumOfPerformancePeriod());
            preparedStatement.setInt(2,teacherHireResearcherTableC.getRewardProjectId());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
