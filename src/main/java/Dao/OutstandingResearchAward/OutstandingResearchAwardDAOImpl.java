package Dao.OutstandingResearchAward;

import Bean.OutstandingResearchAward.OutstandingResearchAward;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OutstandingResearchAwardDAOImpl implements OutstandingResearchAwardDAO {
	private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT_ALL = "SELECT * FROM outstanding_research_award WHERE project_id = ?";
    private static final String INSERT_USER_DATA =
    		"INSERT INTO outstanding_research_award (user_number, user_name, applicant_title, department, birth_date," +
                    " identity_number, employment_date, extension_number, cellphone_number, recommended_reason, project_id)"+
    		" values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_USER_DATA =
            "UPDATE outstanding_research_award "+
                    "SET user_number = ?,user_name = ?,applicant_title = ?,department = ?,birth_date = ?,identity_number = ?,employment_date = ?," +
                    "extension_number = ?,cellphone_number = ?,recommended_reason = ?"+
                    " WHERE project_id = ?";

    private static final String UPDATE_DEPARTMENT_DATA =
            "UPDATE outstanding_research_award "+
                    "SET department_academic_year = ?,department_semester = ?,department_conference_times = ?, department_sign_date = ? " +
                    "WHERE project_id = ?";
    private static final String UPDATE_COLLEGE_DATA =
            "UPDATE outstanding_research_award "+
                    "SET college_academic_year = ?,college_semester = ?,college_conference_times = ?, college_sign_date = ? " +
                    "WHERE project_id = ?";
    private static final String UPDATE_RADO_DATA =
            "UPDATE outstanding_research_award "+
                    "SET research_and_development_office_sign_year = ?,research_and_development_office_sign_month = ?,research_and_development_office_sign_date = ?" +
                    "WHERE project_id = ?";



    @Override
    public void save(OutstandingResearchAward object, int project_id) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL))
        {
            preparedStatement.setInt(1, project_id);

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                update(connection, object);
            }
            else {
                insert(connection, object);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OutstandingResearchAward get(int project_id) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        OutstandingResearchAward outstandingResearchAward = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL))
        {
            preparedStatement.setInt(1, project_id);
        	resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                outstandingResearchAward = new OutstandingResearchAward(
                        resultSet.getInt("project_id"),
                        resultSet.getInt("user_number"),
                        resultSet.getString("user_name"),
                        resultSet.getString("applicant_title"),
                        resultSet.getString("department"),
                        resultSet.getDate("birth_date"),
                        resultSet.getDate("employment_date"),
                        resultSet.getString("identity_number"),
                        resultSet.getString("extension_number"),
                        resultSet.getString("cellphone_number"),
                        resultSet.getString("recommended_reason"),
                        // for emission date
                        resultSet.getString("department_academic_year"),
                        resultSet.getString("department_semester"),
                        resultSet.getString("department_conference_times"),
                        resultSet.getDate("department_sign_date"),
                        resultSet.getString("college_academic_year"),
                        resultSet.getString("college_semester"),
                        resultSet.getString("college_conference_times"),
                        resultSet.getDate("college_sign_date"),
                        resultSet.getString("research_and_development_office_sign_year"),
                        resultSet.getString("research_and_development_office_sign_month"),
                        resultSet.getString("research_and_development_office_sign_date")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outstandingResearchAward;
    }
    @Override
    public void updateDepartmentData(OutstandingResearchAward outstandingResearchAward) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DEPARTMENT_DATA))
        {
            preparedStatement.setString(1,outstandingResearchAward.getDepartmentAcademicYear());
            preparedStatement.setString(2,outstandingResearchAward.getDepartmentSemester());
            preparedStatement.setString(3,outstandingResearchAward.getDepartmentConferenceTimes());
            preparedStatement.setDate(4,outstandingResearchAward.getDepartmentSignDate());
            preparedStatement.setInt(5,outstandingResearchAward.getProjectId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCollegeData(OutstandingResearchAward outstandingResearchAward) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COLLEGE_DATA))
        {
            preparedStatement.setString(1,outstandingResearchAward.getCollegeAcademicYear());
            preparedStatement.setString(2,outstandingResearchAward.getCollegeSemester());
            preparedStatement.setString(3,outstandingResearchAward.getCollegeConferenceTimes());
            preparedStatement.setDate(4,outstandingResearchAward.getCollegeSignDate());
            preparedStatement.setInt(5,outstandingResearchAward.getProjectId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRADOData(OutstandingResearchAward outstandingResearchAward) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RADO_DATA))
        {
            preparedStatement.setString(1,outstandingResearchAward.getResearchAndDevelopmentOfficeSignYear());
            preparedStatement.setString(2,outstandingResearchAward.getResearchAndDevelopmentOfficeSignMonth());
            preparedStatement.setString(3,outstandingResearchAward.getResearchAndDevelopmentOfficeSignDate());
            preparedStatement.setInt(4,outstandingResearchAward.getProjectId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insert(Connection connection, OutstandingResearchAward object) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_DATA))
        {
            setStatement(preparedStatement, object);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Connection connection, OutstandingResearchAward object) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_DATA))
        {
            setStatement(preparedStatement, object);
    		preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setStatement(PreparedStatement preparedStatement, OutstandingResearchAward object){
        try {
            preparedStatement.setInt(1,object.getUserNumber());
            preparedStatement.setString(2,object.getUserName());
            preparedStatement.setString(3,object.getApplicantTitle());
            preparedStatement.setString(4,object.getDepartment());
            preparedStatement.setDate(5,object.getBirthDate());
            preparedStatement.setString(6,object.getIdentityNumber());
            preparedStatement.setDate(7,object.getEmploymentDate());
            preparedStatement.setString(8,object.getExtensionNumber());
            preparedStatement.setString(9,object.getCellphoneNumber());
            preparedStatement.setString(10,object.getRecommendedReason());
            preparedStatement.setInt(11,object.getProjectId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
