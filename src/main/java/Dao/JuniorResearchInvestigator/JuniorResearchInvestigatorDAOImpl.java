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
    private static final String SELECT = "SELECT * FROM junior_research_investigator WHERE project_id = ?";
    private static final String INSERT =
    		"INSERT INTO junior_research_investigator (user_number, user_name, applicant_title, department, birth_date," +
                    " identity_number, employment_date, extension_number, cellphone_number, recommended_reason, project_id)"+
    		" values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE =
            "UPDATE junior_research_investigator "+
                    "SET user_number = ?,user_name = ?,applicant_title = ?,department = ?,birth_date = ?,identity_number = ?,employment_date = ?," +
                    "extension_number = ?,cellphone_number = ?,recommended_reason = ?"+
                    " WHERE project_id = ?";

    @Override
    public void save(JuniorResearchInvestigator object, int project_id) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
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
    public JuniorResearchInvestigator show(int project_id) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet;
        JuniorResearchInvestigator juniorResearchInvestigator = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setInt(1, project_id);
        	resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                juniorResearchInvestigator = new JuniorResearchInvestigator(
                        resultSet.getInt("project_id"),
                        resultSet.getInt("user_number"),
                        resultSet.getString("user_name"),
                        resultSet.getString("applicant_title"),
                        resultSet.getString("department"),
                        resultSet.getDate("birth_date"),
                        resultSet.getString("identity_number"),
                        resultSet.getDate("employment_date"),
                        resultSet.getString("extension_number"),
                        resultSet.getString("cellphone_number"),
                        resultSet.getString("recommended_reason"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return juniorResearchInvestigator;
    }
    
    public void insert(Connection connection, JuniorResearchInvestigator object) {
    	try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            setStatement(preparedStatement, object);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(Connection connection, JuniorResearchInvestigator object) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE))
        {
            setStatement(preparedStatement, object);
    		preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setStatement(PreparedStatement preparedStatement, JuniorResearchInvestigator object){
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
