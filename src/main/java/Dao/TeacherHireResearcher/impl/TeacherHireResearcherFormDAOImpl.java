package Dao.TeacherHireResearcher.impl;

import Bean.TeacherHireResearcher.TeacherHireResearcherForm;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;
import Dao.TeacherHireResearcher.TeacherHireResearcherFormDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherHireResearcherFormDAOImpl implements TeacherHireResearcherFormDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM teacher_hire_researcher_form WHERE reward_project_id = ?";
    private static final String INSERT =
            "INSERT INTO teacher_hire_researcher_form (reward_project_id, apply_type, apply_type_description, researcher_type, applicant_name, " +
                    "applicant_job_title, applicant_department, applicant_email, applicant_seniority, applicant_research_room_ext, applicant_phone, " +
                    "researcher_name, researcher_birth_date, researcher_id_num, researcher_phone, researcher_job_title, researcher_salary_scale, " +
                    "project_category, project_name, project_amount, expected_performance_near_five_years, expected_performance_per_years, " +
                    "expected_performance_others, apply_for_subsidies) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE =
            "UPDATE teacher_hire_researcher_form " +
                    "SET apply_type = ?, apply_type_description = ?, researcher_type = ?, applicant_name = ?, applicant_job_title = ?, " +
                    "applicant_department = ?, applicant_email = ?, applicant_seniority = ?,  applicant_research_room_ext = ?, applicant_phone = ?, " +
                    "researcher_name = ?, researcher_birth_date = ?, researcher_id_num = ?, researcher_phone = ?, researcher_job_title = ?, " +
                    "researcher_salary_scale = ?, project_category = ?, project_name = ?, project_amount = ?, expected_performance_near_five_years = ?," +
                    "expected_performance_per_years = ?, expected_performance_others = ?, apply_for_subsidies = ?" +
                    "WHERE reward_project_id = ?";

    @Override
    public void save(TeacherHireResearcherForm object) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            //project id source??
            preparedStatement.setInt(1, object.getRewardProjectId());
            resultSet = preparedStatement.executeQuery();

            int size = 0;

            while(resultSet.next()) {
                size++;
            }

            if(size == 0) {
                insert(connection,object);
            }
            else {
                update(connection,object);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TeacherHireResearcherForm get(int rewardProjectId) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        TeacherHireResearcherForm teacherHireResearcherForm;
        teacherHireResearcherForm = new TeacherHireResearcherForm();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setInt(1, rewardProjectId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                teacherHireResearcherForm.setRewardProjectId(resultSet.getInt("reward_project_id"));
                teacherHireResearcherForm.setApplyType(resultSet.getString("apply_type"));
                teacherHireResearcherForm.setApplyTypeDescription(resultSet.getString("apply_type_description"));
                teacherHireResearcherForm.setResearcherType(resultSet.getString("researcher_type"));
                teacherHireResearcherForm.setApplicantName(resultSet.getString("applicant_name"));
                teacherHireResearcherForm.setApplicantJobTitle(resultSet.getString("applicant_job_title"));
                teacherHireResearcherForm.setApplicantDepartment(resultSet.getString("applicant_department"));
                teacherHireResearcherForm.setApplicantEmail(resultSet.getString("applicant_email"));
                teacherHireResearcherForm.setApplicantSeniority(resultSet.getString("applicant_seniority"));
                teacherHireResearcherForm.setApplicantResearchRoomExt(resultSet.getString("applicant_research_room_ext"));
                teacherHireResearcherForm.setApplicantPhone(resultSet.getString("applicant_phone"));
                teacherHireResearcherForm.setResearcherName(resultSet.getString("researcher_name"));
                teacherHireResearcherForm.setResearcherBirthDate(resultSet.getString("researcher_birth_date"));
                teacherHireResearcherForm.setResearcherIdNum(resultSet.getString("researcher_id_num"));
                teacherHireResearcherForm.setResearcherPhone(resultSet.getString("researcher_phone"));
                teacherHireResearcherForm.setResearcherJobTitle(resultSet.getString("researcher_job_title"));
                teacherHireResearcherForm.setResearcherSalaryScale(resultSet.getString("researcher_salary_scale"));
                teacherHireResearcherForm.setProjectCategory(resultSet.getString("project_category"));
                teacherHireResearcherForm.setProjectName(resultSet.getString("project_name"));
                teacherHireResearcherForm.setProjectAmount(resultSet.getString("project_amount"));
                teacherHireResearcherForm.setExpectedPerformanceNearFiveYears(resultSet.getString("expected_performance_near_five_years"));
                teacherHireResearcherForm.setExpectedPerformancePerYears(resultSet.getString("expected_performance_per_years"));
                teacherHireResearcherForm.setExpectedPerformanceOthers(resultSet.getString("expected_performance_others"));
                teacherHireResearcherForm.setApplyForSubsidies(resultSet.getString("apply_for_subsidies"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacherHireResearcherForm;
    }

    private void insert(Connection connection, TeacherHireResearcherForm object) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setInt(1,object.getRewardProjectId());
            preparedStatement.setString(2,object.getApplyType());
            preparedStatement.setString(3,object.getApplyTypeDescription());
            preparedStatement.setString(4,object.getResearcherType());
            preparedStatement.setString(5,object.getApplicantName());
            preparedStatement.setString(6,object.getApplicantJobTitle());
            preparedStatement.setString(7,object.getApplicantDepartment());
            preparedStatement.setString(8,object.getApplicantEmail());
            preparedStatement.setString(9,object.getApplicantSeniority());
            preparedStatement.setString(10,object.getApplicantResearchRoomExt());
            preparedStatement.setString(11,object.getApplicantPhone());
            preparedStatement.setString(12,object.getResearcherName());
            preparedStatement.setString(13,object.getResearcherBirthDate());
            preparedStatement.setString(14,object.getResearcherIdNum());
            preparedStatement.setString(15,object.getResearcherPhone());
            preparedStatement.setString(16,object.getResearcherJobTitle());
            preparedStatement.setString(17,object.getResearcherSalaryScale());
            preparedStatement.setString(18,object.getProjectCategory());
            preparedStatement.setString(19,object.getProjectName());
            preparedStatement.setString(20,object.getProjectAmount());
            preparedStatement.setString(21,object.getExpectedPerformanceNearFiveYears());
            preparedStatement.setString(22,object.getExpectedPerformancePerYears());
            preparedStatement.setString(23,object.getExpectedPerformanceOthers());
            preparedStatement.setString(24,object.getApplyForSubsidies());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void update(Connection connection,TeacherHireResearcherForm object) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,object.getApplyType());
            preparedStatement.setString(2,object.getApplyTypeDescription());
            preparedStatement.setString(3,object.getResearcherType());
            preparedStatement.setString(4,object.getApplicantName());
            preparedStatement.setString(5,object.getApplicantJobTitle());
            preparedStatement.setString(6,object.getApplicantDepartment());
            preparedStatement.setString(7,object.getApplicantEmail());
            preparedStatement.setString(8,object.getApplicantSeniority());
            preparedStatement.setString(9,object.getApplicantResearchRoomExt());
            preparedStatement.setString(10,object.getApplicantPhone());
            preparedStatement.setString(11,object.getResearcherName());
            preparedStatement.setString(12,object.getResearcherBirthDate());
            preparedStatement.setString(13,object.getResearcherIdNum());
            preparedStatement.setString(14,object.getResearcherPhone());
            preparedStatement.setString(15,object.getResearcherJobTitle());
            preparedStatement.setString(16,object.getResearcherSalaryScale());
            preparedStatement.setString(17,object.getProjectCategory());
            preparedStatement.setString(18,object.getProjectName());
            preparedStatement.setString(19,object.getProjectAmount());
            preparedStatement.setString(20,object.getExpectedPerformanceNearFiveYears());
            preparedStatement.setString(21,object.getExpectedPerformancePerYears());
            preparedStatement.setString(22,object.getExpectedPerformanceOthers());
            preparedStatement.setString(23,object.getApplyForSubsidies());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
