package Dao.SolicitSpecialOutstandingResearcherApplication;

import Bean.SolicitSpecialOutstandingResearcher.SolicitRecruitDescription;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SolicitRecruitDescriptionDAOImpl implements SolicitRecruitDescriptionDAO{

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_SOLICIT_RECRUIT_DESCRIPTION = "INSERT INTO solicit_recruit_description (project_id, application_reason) VALUES (?, ?)" +
            "ON DUPLICATE KEY UPDATE application_reason = ?";
    private static final String DELETE_SOLICIT_RECRUIT_DESCRIPTION = "DELETE FROM solicit_recruit_description WHERE project_id = ? ";
    private static final String SELECT_SOLICIT_RECRUIT_DESCRIPTION = "SELECT * FROM solicit_recruit_description WHERE project_id = ?";

    @Override
    public SolicitRecruitDescription query(int project_id) {
        Connection connection = dbConnection.getConnection();
        SolicitRecruitDescription solicitRecruitDescription = new SolicitRecruitDescription(project_id);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SOLICIT_RECRUIT_DESCRIPTION);
            preparedStatement.setInt(1, project_id);
            preparedStatement.executeQuery();
            solicitRecruitDescription.setApplication_reason(preparedStatement.getResultSet().getString("application_reason"));
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return solicitRecruitDescription;
    }

    @Override
    public void update(SolicitRecruitDescription solicitRecruitDescription) {
        deleteSolicitRecruitDescription( solicitRecruitDescription.getProject_id() ) ;
        insertSolicitRecruitDescription( solicitRecruitDescription ) ;
    }

    private void deleteSolicitRecruitDescription(int project_id) {
        Connection connection = dbConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SOLICIT_RECRUIT_DESCRIPTION);
            preparedStatement.setInt(1, project_id);
            preparedStatement.executeUpdate();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertSolicitRecruitDescription(SolicitRecruitDescription solicitRecruitDescription) {
        Connection connection = dbConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SOLICIT_RECRUIT_DESCRIPTION);
            preparedStatement.setInt(1, solicitRecruitDescription.getProject_id());
            preparedStatement.setString(2, solicitRecruitDescription.getApplication_reason());
            preparedStatement.executeUpdate();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
