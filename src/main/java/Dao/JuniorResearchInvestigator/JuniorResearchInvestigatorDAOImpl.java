package Dao.JuniorResearchInvestigator;

import Bean.JuniorResearchInvestigator.JuniorResearchInvestigator;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JuniorResearchInvestigatorDAOImpl implements JuniorResearchInvestigatorDAO{
	private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT_ALL = "SELECT * FROM junior_research_investigator WHERE projectId = ?";
    private static final String INSERT_USER_DATA =
    		"INSERT INTO junior_research_investigator (user_number, user_name, applicant_title, department, birth_date," +
                    " identity_number, employment_date, extension_number, cellphone_number, recommended_reason, projectId)"+
    		" values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_USER_DATA =
            "UPDATE junior_research_investigator "+
                    "SET user_number = ?,user_name = ?,applicant_title = ?,department = ?,birth_date = ?,identity_number = ?,employment_date = ?," +
                    "extension_number = ?,cellphone_number = ?,recommended_reason = ?"+
                    " WHERE projectId = ?";
    private static final String UPDATE_DEPARTMENT_DATA =
            "UPDATE junior_research_investigator "+
                    "SET department_academic_year = ?,department_semester = ?,department_conference_times = ?, department_sign_date = ? " +
                    "WHERE projectId = ?";
    private static final String UPDATE_COLLEGE_DATA =
            "UPDATE junior_research_investigator "+
                    "SET college_academic_year = ?,college_semester = ?,college_conference_times = ?, college_sign_date = ? " +
                    "WHERE projectId = ?";
    private static final String UPDATE_RADO_DATA =
            "UPDATE junior_research_investigator "+
                    "SET research_and_development_office_sign_year = ?,research_and_development_office_sign_month = ?,research_and_development_office_sign_date = ?" +
                    "WHERE projectId = ?";
    
    @Override
    public void save(JuniorResearchInvestigator juniorResearchInvestigator) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL))
        {
            preparedStatement.setInt(1, juniorResearchInvestigator.getProjectId());

            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                update(connection, juniorResearchInvestigator);
            }
            else {
                insert(connection, juniorResearchInvestigator);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public JuniorResearchInvestigator show(int projectId) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        JuniorResearchInvestigator juniorResearchInvestigator = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL))
        {
            preparedStatement.setInt(1, projectId);
        	resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                juniorResearchInvestigator = new JuniorResearchInvestigator(
                    resultSet.getInt("projectId"),
                    resultSet.getString("user_number"),
                    resultSet.getString("user_name"),
                    resultSet.getString("applicant_title"),
                    resultSet.getString("department"),
                    resultSet.getDate("birth_date"),
                    resultSet.getDate("employment_date"),
                    resultSet.getString("identity_number"),
                    resultSet.getString("extension_number"),
                    resultSet.getString("cellphone_number"),
                    resultSet.getString("recommended_reason"),
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
        return juniorResearchInvestigator;
    }

    @Override
    public void updateDepartmentData(JuniorResearchInvestigator juniorResearchInvestigator) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DEPARTMENT_DATA))
        {
            preparedStatement.setString(1,juniorResearchInvestigator.getDepartmentAcademicYear());
            preparedStatement.setString(2,juniorResearchInvestigator.getDepartmentSemester());
            preparedStatement.setString(3,juniorResearchInvestigator.getDepartmentConferenceTimes());
            preparedStatement.setDate(4,juniorResearchInvestigator.getDepartmentSignDate());
            preparedStatement.setInt(5,juniorResearchInvestigator.getProjectId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCollegeData(JuniorResearchInvestigator juniorResearchInvestigator) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COLLEGE_DATA))
        {
            preparedStatement.setString(1,juniorResearchInvestigator.getCollegeAcademicYear());
            preparedStatement.setString(2,juniorResearchInvestigator.getCollegeSemester());
            preparedStatement.setString(3,juniorResearchInvestigator.getCollegeConferenceTimes());
            preparedStatement.setDate(4,juniorResearchInvestigator.getCollegeSignDate());
            preparedStatement.setInt(5,juniorResearchInvestigator.getProjectId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRADOData(JuniorResearchInvestigator juniorResearchInvestigator) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RADO_DATA))
        {
            preparedStatement.setString(1,juniorResearchInvestigator.getResearchAndDevelopmentOfficeSignYear());
            preparedStatement.setString(2,juniorResearchInvestigator.getResearchAndDevelopmentOfficeSignMonth());
            preparedStatement.setString(3,juniorResearchInvestigator.getResearchAndDevelopmentOfficeSignDate());
            preparedStatement.setInt(4,juniorResearchInvestigator.getProjectId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Connection connection, JuniorResearchInvestigator object) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_DATA))
        {
            setStatement(preparedStatement, object);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Connection connection, JuniorResearchInvestigator object) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_DATA))
        {
            setStatement(preparedStatement, object);
    		preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setStatement(PreparedStatement preparedStatement, JuniorResearchInvestigator object){
        try {
            preparedStatement.setString(1,object.getUserNumber());
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
