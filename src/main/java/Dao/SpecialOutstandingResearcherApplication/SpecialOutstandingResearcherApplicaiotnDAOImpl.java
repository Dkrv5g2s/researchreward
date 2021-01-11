package Dao.SpecialOutstandingResearcherApplication;


import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherForm;
import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherStandard;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SpecialOutstandingResearcherApplicaiotnDAOImpl implements SpecialOutstandingResearcherApplicaiotnDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String UPDATE_SPECIFED_Special_Outstanding_Researcher_Applicaiotn = "INSERT INTO special_researcher_application (project_id,applicant_name,job,college,department,seniority,executed_tech_proj,tech_proj_id,tech_proj_start_time,tech_proj_end_time) VALUES (?,?,?,?,?,?,?,?,?,?) " +
            "ON DUPLICATE KEY UPDATE applicant_name = ?,job = ?,college=?, department=?, seniority=?, executed_tech_proj=?, tech_proj_id= ?, tech_proj_start_time=?, tech_proj_end_time=? ;";


    private static final String DELETE_SPECIFED_Special_Outstanding_Researcher_Applicaiotn_Standard = "DELETE FROM special_researcher_application_standard WHERE project_id = ? ";

    private static final String  INSERT_SPECIFED_Special_Outstanding_Researcher_Applicaiotn_Standard = "INSERT INTO special_researcher_application_standard (project_id,level_num,standard,sub_standard) VALUES (?,?,?,?) " ;

    private void delete_specified_standard( int project_id ) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SPECIFED_Special_Outstanding_Researcher_Applicaiotn_Standard))
        {
            preparedStatement.setInt(1, project_id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insert_all_standard_of_specified_project(List<SpecialOutstandingResearcherStandard> specialOutstandingResearcherStandardList, int project_id){
        Connection connection = dbConnection.getConnection();

        for ( SpecialOutstandingResearcherStandard specialOutstandingResearcherStandard : specialOutstandingResearcherStandardList ) {

            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SPECIFED_Special_Outstanding_Researcher_Applicaiotn_Standard))
            {
                preparedStatement.setInt(1,project_id);
                preparedStatement.setString(2,specialOutstandingResearcherStandard.getLevel_num());
                preparedStatement.setString(3,specialOutstandingResearcherStandard.getStandard());
                preparedStatement.setString(4,specialOutstandingResearcherStandard.getSub_standard());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void update_specified_standard_of_form(List<SpecialOutstandingResearcherStandard> specialOutstandingResearcherStandardList, int project_id) {
        delete_specified_standard( project_id ) ;
        insert_all_standard_of_specified_project( specialOutstandingResearcherStandardList, project_id ) ;
    }

    @Override
    public void update(SpecialOutstandingResearcherForm specialOutstandingResearcherForm) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SPECIFED_Special_Outstanding_Researcher_Applicaiotn))
        {
            preparedStatement.setInt(1,specialOutstandingResearcherForm.getProject_id());
            preparedStatement.setString(2,specialOutstandingResearcherForm.getApplicant_name());
            preparedStatement.setString(3,specialOutstandingResearcherForm.getJob());
            preparedStatement.setString(4,specialOutstandingResearcherForm.getCollege());
            preparedStatement.setString(5,specialOutstandingResearcherForm.getDepartment());
            preparedStatement.setString(6,specialOutstandingResearcherForm.getSeniority());
            preparedStatement.setBoolean(7,specialOutstandingResearcherForm.isExecuted_tech_proj());
            preparedStatement.setString(8,specialOutstandingResearcherForm.getTech_proj_id());
            preparedStatement.setDate(9,specialOutstandingResearcherForm.getTech_proj_start_time());
            preparedStatement.setDate(10,specialOutstandingResearcherForm.getTech_proj_end_time());

            preparedStatement.setString(11,specialOutstandingResearcherForm.getApplicant_name());
            preparedStatement.setString(12,specialOutstandingResearcherForm.getJob());
            preparedStatement.setString(13,specialOutstandingResearcherForm.getCollege());
            preparedStatement.setString(14,specialOutstandingResearcherForm.getDepartment());
            preparedStatement.setString(15,specialOutstandingResearcherForm.getSeniority());
            preparedStatement.setBoolean(16,specialOutstandingResearcherForm.isExecuted_tech_proj());
            preparedStatement.setString(17,specialOutstandingResearcherForm.getTech_proj_id());
            preparedStatement.setDate(18,specialOutstandingResearcherForm.getTech_proj_start_time());
            preparedStatement.setDate(19,specialOutstandingResearcherForm.getTech_proj_end_time());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        update_specified_standard_of_form(specialOutstandingResearcherForm.getStandard_list(),specialOutstandingResearcherForm.getProject_id());
    }

    @Override
    public void query(int project_id) {
        try {
            throw new Exception() ;
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
