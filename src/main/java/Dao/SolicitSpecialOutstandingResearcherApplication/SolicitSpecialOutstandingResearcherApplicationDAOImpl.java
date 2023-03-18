package Dao.SolicitSpecialOutstandingResearcherApplication;

import Bean.SolicitSpecialOutstandingResearcher.SolicitSpecialOutstandingResearcherForm;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SolicitSpecialOutstandingResearcherApplicationDAOImpl implements SolicitSpecialOutstandingResearcherApplicationDAO{
    private  DBConnection dbConnection = new DBConnectionImpl();
    private static final String INSERT_SOLICIT_SPECIAL_OUTSTANDING_RESEARCHER_APPLICATION = "INSERT INTO solicit_special_researcher_application (project_id, suitable_type, level_standard, recommend_seq, " +
            "max_pay_year, current_pay_year, upgrade_date, department_review_date, academy_review_date, department_approve_date, academy_approve_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" +
            " ON DUPLICATE KEY UPDATE suitable_type = ?, level_standard = ?, recommend_seq = ?, max_pay_year = ?, current_pay_year = ?, upgrade_date = ?, department_review_date = ?, academy_review_date = ?, department_approve_date = ?, academy_approve_date = ?";
    private static final String DELETE_SOLICIT_SPECIAL_OUTSTANDING_RESEARCHER_APPLICATION = "DELETE FROM solicit_special_outstanding_researcher_application WHERE project_id = ? ";
    private static final String SELECT_SOLICIT_SPECIAL_OUTSTANDING_RESEARCHER_APPLICATION = "SELECT * FROM solicit_special_outstanding_researcher_application WHERE project_id = ?";
    @Override
    public SolicitSpecialOutstandingResearcherForm query(int project_id) {
        Connection connection = dbConnection.getConnection();
        SolicitSpecialOutstandingResearcherForm solicitSpecialOutstandingResearcherForm = new SolicitSpecialOutstandingResearcherForm(project_id);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SOLICIT_SPECIAL_OUTSTANDING_RESEARCHER_APPLICATION);
            preparedStatement.setInt(1, project_id);
            preparedStatement.executeQuery();
            solicitSpecialOutstandingResearcherForm.setSuitable_type(preparedStatement.getResultSet().getShort("suitable_type"));
            solicitSpecialOutstandingResearcherForm.setLevel_standard(preparedStatement.getResultSet().getShort("level_standard"));
            solicitSpecialOutstandingResearcherForm.setRecommend_seq(preparedStatement.getResultSet().getString("recommend_seq"));
            solicitSpecialOutstandingResearcherForm.setMax_pay_year(preparedStatement.getResultSet().getShort("max_pay_year"));
            solicitSpecialOutstandingResearcherForm.setCurrent_pay_year(preparedStatement.getResultSet().getShort("current_pay_year"));
            solicitSpecialOutstandingResearcherForm.setUpgrade_date(preparedStatement.getResultSet().getDate("upgrade_date"));
            solicitSpecialOutstandingResearcherForm.setDepartment_review_date(preparedStatement.getResultSet().getDate("department_review_date"));
            solicitSpecialOutstandingResearcherForm.setAcademy_review_date(preparedStatement.getResultSet().getDate("academy_review_date"));
            solicitSpecialOutstandingResearcherForm.setDepartment_approve_date(preparedStatement.getResultSet().getDate("department_approve_date"));
            solicitSpecialOutstandingResearcherForm.setAcademy_approve_date(preparedStatement.getResultSet().getDate("academy_approve_date"));
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return solicitSpecialOutstandingResearcherForm;
    }

    @Override
    public void update(SolicitSpecialOutstandingResearcherForm solicitSpecialOutstandingResearcherForm) {
        deleteSolicitSpecialOutstandingResearcherForm(solicitSpecialOutstandingResearcherForm);
        insertSolicitSpecialOutstandingResearcherForm(solicitSpecialOutstandingResearcherForm);
    }

    private void deleteSolicitSpecialOutstandingResearcherForm(SolicitSpecialOutstandingResearcherForm solicitSpecialOutstandingResearcherForm) {
        Connection connection = dbConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SOLICIT_SPECIAL_OUTSTANDING_RESEARCHER_APPLICATION);
            preparedStatement.setInt(1, solicitSpecialOutstandingResearcherForm.getProject_id());
            preparedStatement.executeUpdate();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertSolicitSpecialOutstandingResearcherForm(SolicitSpecialOutstandingResearcherForm solicitSpecialOutstandingResearcherForm){
        Connection connection = dbConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SOLICIT_SPECIAL_OUTSTANDING_RESEARCHER_APPLICATION);
            preparedStatement.setInt(1, solicitSpecialOutstandingResearcherForm.getProject_id());
            preparedStatement.setShort(2, solicitSpecialOutstandingResearcherForm.getSuitable_type());
            preparedStatement.setShort(3, solicitSpecialOutstandingResearcherForm.getLevel_standard());
            preparedStatement.setString(4, solicitSpecialOutstandingResearcherForm.getRecommend_seq());
            preparedStatement.setShort(5, solicitSpecialOutstandingResearcherForm.getMax_pay_year());
            preparedStatement.setShort(6, solicitSpecialOutstandingResearcherForm.getCurrent_pay_year());
            try {
                preparedStatement.setDate(7, (Date) solicitSpecialOutstandingResearcherForm.getUpgrade_date());
            }
            catch (NullPointerException e){
                preparedStatement.setDate(7, null);
            }
            try {
                preparedStatement.setDate(8, (Date) solicitSpecialOutstandingResearcherForm.getDepartment_review_date());
            }
            catch (NullPointerException e){
                preparedStatement.setDate(8, null);
            }
            try {
                preparedStatement.setDate(9, (Date) solicitSpecialOutstandingResearcherForm.getAcademy_review_date());
            }
            catch (NullPointerException e){
                preparedStatement.setDate(9, null);
            }
            try {
                preparedStatement.setDate(10, (Date) solicitSpecialOutstandingResearcherForm.getDepartment_approve_date());
            }
            catch (NullPointerException e){
                preparedStatement.setDate(10, null);
            }
            try {
                preparedStatement.setDate(11, (Date) solicitSpecialOutstandingResearcherForm.getAcademy_approve_date());
            }
            catch (NullPointerException e){
                preparedStatement.setDate(11, null);
            }
            preparedStatement.executeUpdate();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
