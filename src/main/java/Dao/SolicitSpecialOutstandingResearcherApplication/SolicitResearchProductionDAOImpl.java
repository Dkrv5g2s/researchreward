package Dao.SolicitSpecialOutstandingResearcherApplication;


import Bean.SolicitSpecialOutstandingResearcher.SolicitResearchProduction;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SolicitResearchProductionDAOImpl implements SolicitResearchProductionDAO{

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_SOLICIT_RECRUIT_DESCRIPTION = "INSERT INTO research_production_declaration (project_id, applicant_declaration) VALUES (?, ?)" +
            "ON DUPLICATE KEY UPDATE applicant_declaration = ?";
    private static final String DELETE_SOLICIT_RECRUIT_DESCRIPTION = "DELETE FROM research_production_declaration WHERE project_id = ? ";
    private static final String SELECT_SOLICIT_RECRUIT_DESCRIPTION = "SELECT * FROM research_production_declaration WHERE project_id = ?";
    @Override
    public SolicitResearchProduction query(int project_id) {
        Connection connection = dbConnection.getConnection();
        SolicitResearchProduction solicitResearchProduction = new SolicitResearchProduction(project_id);

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SOLICIT_RECRUIT_DESCRIPTION);
            preparedStatement.setInt(1, project_id);
            preparedStatement.executeQuery();
            solicitResearchProduction.setApplicant_declaration(preparedStatement.getResultSet().getBoolean("applicant_declaration"));
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return solicitResearchProduction;
    }

    @Override
    public void update(SolicitResearchProduction solicitResearchProduction) {
        deleteSolicitRecruitDescription( solicitResearchProduction.getProject_id() ) ;
        insertSolicitRecruitDescription( solicitResearchProduction ) ;
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

    private void insertSolicitRecruitDescription(SolicitResearchProduction solicitResearchProduction) {
        Connection connection = dbConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SOLICIT_RECRUIT_DESCRIPTION);
            preparedStatement.setInt(1, solicitResearchProduction.getProject_id());
            preparedStatement.setBoolean(2, solicitResearchProduction.getApplicant_declaration());
            preparedStatement.executeUpdate();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
