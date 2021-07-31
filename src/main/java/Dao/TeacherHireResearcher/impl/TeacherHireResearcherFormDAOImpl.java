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
            "INSERT INTO teacher_hire_researcher_form (reward_project_id, applicant_name, " +
                    "applicant_job_title, applicant_department, applicant_email, applicant_seniority, applicant_research_room_ext, applicant_phone, " +
                    "researcher_type, researcher_name, researcher_job_title, researcher_salary_scale, " +
                    "project_category, project_name, project_amount, expected_performance_near_five_years, expected_performance_per_years, " +
                    "expected_performance_others, apply_for_subsidies) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE =
            "UPDATE teacher_hire_researcher_form " +
                    "SET applicant_name = ?, applicant_job_title = ?, " +
                    "applicant_department = ?, applicant_email = ?, applicant_seniority = ?, applicant_research_room_ext = ?, applicant_phone = ?, " +
                    "researcher_type = ?, researcher_name = ?, researcher_job_title = ?, " +
                    "researcher_salary_scale = ?, project_category = ?, project_name = ?, project_amount = ?, expected_performance_near_five_years = ?, " +
                    "expected_performance_per_years = ?, expected_performance_others = ?, apply_for_subsidies = ? " +
                    "WHERE reward_project_id = ?";
    private static final String UPDATE_DEPARTMENT_REVIEW_DATA =
            "UPDATE teacher_hire_researcher_form " +
                    "SET department_academic_year = ?, department_semester = ?, " +
                    "department_conference_times = ?, department_sign_date = ? " +
                    "WHERE reward_project_id = ?";
    private static final String UPDATE_COLLEGE_REVIEW_DATA =
            "UPDATE teacher_hire_researcher_form " +
                    "SET college_academic_year = ?, college_semester = ?, " +
                    "college_conference_times = ?, college_sign_date = ? " +
                    "WHERE reward_project_id = ?";
    private static final String UPDATE_RADO_REVIEW_DATA =
            "UPDATE teacher_hire_researcher_form " +
                    "SET research_and_development_office_sign_year = ?, research_and_development_office_sign_month = ?, " +
                    "research_and_development_office_sign_date = ? " +
                    "WHERE reward_project_id = ?";

    @Override
    public void save(TeacherHireResearcherForm object) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
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
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDepartmentReviewData(TeacherHireResearcherForm teacherHireResearcherForm){
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DEPARTMENT_REVIEW_DATA))
        {
            preparedStatement.setString(1, teacherHireResearcherForm.getDepartmentAcademicYear());
            preparedStatement.setString(2, teacherHireResearcherForm.getDepartmentSemester());
            preparedStatement.setString(3, teacherHireResearcherForm.getDepartmentConferenceTimes());
            preparedStatement.setDate(4, teacherHireResearcherForm.getDepartmentSignDate());
            preparedStatement.setInt(5,teacherHireResearcherForm.getRewardProjectId());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCollegeReviewData(TeacherHireResearcherForm teacherHireResearcherForm){
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COLLEGE_REVIEW_DATA))
        {
            preparedStatement.setString(1, teacherHireResearcherForm.getCollegeAcademicYear());
            preparedStatement.setString(2, teacherHireResearcherForm.getCollegeSemester());
            preparedStatement.setString(3, teacherHireResearcherForm.getCollegeConferenceTimes());
            preparedStatement.setDate(4, teacherHireResearcherForm.getCollegeSignDate());
            preparedStatement.setInt(5,teacherHireResearcherForm.getRewardProjectId());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRADOReviewData(TeacherHireResearcherForm teacherHireResearcherForm){
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RADO_REVIEW_DATA))
        {
            preparedStatement.setString(1, teacherHireResearcherForm.getResearchAndDevelopmentOfficeSignYear());
            preparedStatement.setString(2, teacherHireResearcherForm.getResearchAndDevelopmentOfficeSignMonth());
            preparedStatement.setString(3, teacherHireResearcherForm.getResearchAndDevelopmentOfficeSignDate());
            preparedStatement.setInt(4,teacherHireResearcherForm.getRewardProjectId());

            preparedStatement.executeUpdate();
            connection.close();
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
                teacherHireResearcherForm.setApplicantName(resultSet.getString("applicant_name"));
                teacherHireResearcherForm.setApplicantJobTitle(resultSet.getString("applicant_job_title"));
                teacherHireResearcherForm.setApplicantDepartment(resultSet.getString("applicant_department"));
                teacherHireResearcherForm.setApplicantEmail(resultSet.getString("applicant_email"));
                teacherHireResearcherForm.setApplicantSeniority(resultSet.getString("applicant_seniority"));
                teacherHireResearcherForm.setApplicantResearchRoomExt(resultSet.getString("applicant_research_room_ext"));
                teacherHireResearcherForm.setApplicantPhone(resultSet.getString("applicant_phone"));
                teacherHireResearcherForm.setResearcherType(resultSet.getString("researcher_type"));
                teacherHireResearcherForm.setResearcherName(resultSet.getString("researcher_name"));
                teacherHireResearcherForm.setResearcherJobTitle(resultSet.getString("researcher_job_title"));
                teacherHireResearcherForm.setResearcherSalaryScale(resultSet.getString("researcher_salary_scale"));
                teacherHireResearcherForm.setProjectCategory(resultSet.getString("project_category"));
                teacherHireResearcherForm.setProjectName(resultSet.getString("project_name"));
                teacherHireResearcherForm.setProjectAmount(resultSet.getString("project_amount"));
                teacherHireResearcherForm.setExpectedPerformanceNearFiveYears(resultSet.getString("expected_performance_near_five_years"));
                teacherHireResearcherForm.setExpectedPerformancePerYears(resultSet.getString("expected_performance_per_years"));
                teacherHireResearcherForm.setExpectedPerformanceOthers(resultSet.getString("expected_performance_others"));
                teacherHireResearcherForm.setApplyForSubsidies(resultSet.getString("apply_for_subsidies"));

                teacherHireResearcherForm.setDepartmentAcademicYear(resultSet.getString("department_academic_year"));
                teacherHireResearcherForm.setDepartmentSemester(resultSet.getString("department_semester"));
                teacherHireResearcherForm.setDepartmentConferenceTimes(resultSet.getString("department_conference_times"));
                teacherHireResearcherForm.setDepartmentSignDate(resultSet.getDate("department_sign_date"));
                teacherHireResearcherForm.setCollegeAcademicYear(resultSet.getString("college_academic_year"));
                teacherHireResearcherForm.setCollegeSemester(resultSet.getString("college_semester"));
                teacherHireResearcherForm.setCollegeConferenceTimes(resultSet.getString("college_conference_times"));
                teacherHireResearcherForm.setCollegeSignDate(resultSet.getDate("college_sign_date"));
                teacherHireResearcherForm.setResearchAndDevelopmentOfficeSignYear(resultSet.getString("research_and_development_office_sign_year"));
                teacherHireResearcherForm.setResearchAndDevelopmentOfficeSignMonth(resultSet.getString("research_and_development_office_sign_month"));
                teacherHireResearcherForm.setResearchAndDevelopmentOfficeSignDate(resultSet.getString("research_and_development_office_sign_date"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacherHireResearcherForm;
    }

    private void insert(Connection connection, TeacherHireResearcherForm object) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            preparedStatement.setInt(1,object.getRewardProjectId());
            preparedStatement.setString(2,object.getApplicantName());
            preparedStatement.setString(3,object.getApplicantJobTitle());
            preparedStatement.setString(4,object.getApplicantDepartment());
            preparedStatement.setString(5,object.getApplicantEmail());
            preparedStatement.setString(6,object.getApplicantSeniority());
            preparedStatement.setString(7,object.getApplicantResearchRoomExt());
            preparedStatement.setString(8,object.getApplicantPhone());
            preparedStatement.setString(9,object.getResearcherType());
            preparedStatement.setString(10,object.getResearcherName());
            preparedStatement.setString(11,object.getResearcherJobTitle());
            preparedStatement.setString(12,object.getResearcherSalaryScale());
            preparedStatement.setString(13,object.getProjectCategory());
            preparedStatement.setString(14,object.getProjectName());
            preparedStatement.setString(15,object.getProjectAmount());
            preparedStatement.setString(16,object.getExpectedPerformanceNearFiveYears());
            preparedStatement.setString(17,object.getExpectedPerformancePerYears());
            preparedStatement.setString(18,object.getExpectedPerformanceOthers());
            preparedStatement.setString(19,object.getApplyForSubsidies());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void update(Connection connection,TeacherHireResearcherForm object) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            preparedStatement.setString(1,object.getApplicantName());
            preparedStatement.setString(2,object.getApplicantJobTitle());
            preparedStatement.setString(3,object.getApplicantDepartment());
            preparedStatement.setString(4,object.getApplicantEmail());
            preparedStatement.setString(5,object.getApplicantSeniority());
            preparedStatement.setString(6,object.getApplicantResearchRoomExt());
            preparedStatement.setString(7,object.getApplicantPhone());
            preparedStatement.setString(8,object.getResearcherType());
            preparedStatement.setString(9,object.getResearcherName());
            preparedStatement.setString(10,object.getResearcherJobTitle());
            preparedStatement.setString(11,object.getResearcherSalaryScale());
            preparedStatement.setString(12,object.getProjectCategory());
            preparedStatement.setString(13,object.getProjectName());
            preparedStatement.setString(14,object.getProjectAmount());
            preparedStatement.setString(15,object.getExpectedPerformanceNearFiveYears());
            preparedStatement.setString(16,object.getExpectedPerformancePerYears());
            preparedStatement.setString(17,object.getExpectedPerformanceOthers());
            preparedStatement.setString(18,object.getApplyForSubsidies());
            preparedStatement.setInt(19,object.getRewardProjectId());

            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
