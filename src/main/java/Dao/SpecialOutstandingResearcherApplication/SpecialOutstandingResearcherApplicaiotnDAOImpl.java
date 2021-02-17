package Dao.SpecialOutstandingResearcherApplication;


import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherForm;
import Bean.SpecialOutstandingResearcher.SpecialOutstandingResearcherStandard;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialOutstandingResearcherApplicaiotnDAOImpl implements SpecialOutstandingResearcherApplicaiotnDAO {

    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String UPDATE_SPECIFED_Special_Outstanding_Researcher_Applicaiotn = "INSERT INTO special_researcher_application (project_id,applicant_name,job,college,department,seniority,executed_tech_proj,tech_proj_id,tech_proj_start_time,tech_proj_end_time) VALUES (?,?,?,?,?,?,?,?,?,?) " +
            "ON DUPLICATE KEY UPDATE applicant_name = ?,job = ?,college=?, department=?, seniority=?, executed_tech_proj=?, tech_proj_id= ?, tech_proj_start_time=?, tech_proj_end_time=? ;";


    private static final String DELETE_SPECIFED_Special_Outstanding_Researcher_Applicaiotn_Standard = "DELETE FROM special_researcher_application_standard WHERE project_id = ? ";

    private static final String INSERT_SPECIFED_Special_Outstanding_Researcher_Applicaiotn_Standard = "INSERT INTO special_researcher_application_standard (project_id,level_num,standard,sub_standard) VALUES (?,?,?,?) " ;

    private static final String SELECT_SPECIFIED_Special_Outstanding_Researcher_Applicaiotn = "SELECT * FROM special_researcher_application WHERE project_id = ? " ;
    private static final String SELECT_SPECIFIED_Special_Outstanding_Researcher_Applicaiotn_Standard = "SELECT * FROM special_researcher_application_standard WHERE project_id = ? " ;

    private void delete_specified_standard( int project_id ) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SPECIFED_Special_Outstanding_Researcher_Applicaiotn_Standard))
        {
            preparedStatement.setInt(1, project_id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insert_all_standard_of_specified_project(List<SpecialOutstandingResearcherStandard> specialOutstandingResearcherStandardList, int project_id){
        Connection connection = dbConnection.getConnection();

        for ( SpecialOutstandingResearcherStandard specialOutstandingResearcherStandard : specialOutstandingResearcherStandardList ) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SPECIFED_Special_Outstanding_Researcher_Applicaiotn_Standard))
            {
                preparedStatement.setInt(1,project_id);
                System.out.println( project_id );
                System.out.println( specialOutstandingResearcherStandard.getLevel_num() );
                System.out.println( specialOutstandingResearcherStandard.getStandard());
                System.out.println( specialOutstandingResearcherStandard.getSub_standard());
                preparedStatement.setString(2,specialOutstandingResearcherStandard.getLevel_num());
                preparedStatement.setString(3,specialOutstandingResearcherStandard.getStandard());
                preparedStatement.setString(4,specialOutstandingResearcherStandard.getSub_standard());
                preparedStatement.executeUpdate();

            } catch (Exception e) {
//                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
            try{
                preparedStatement.setDate(9,new java.sql.Date(specialOutstandingResearcherForm.getTech_proj_start_time().getTime()));
            }catch ( Exception e ) {
                preparedStatement.setDate(9,null);
            }

            try{
                preparedStatement.setDate(10,new java.sql.Date(specialOutstandingResearcherForm.getTech_proj_end_time().getTime()));
            }catch ( Exception e ) {
                preparedStatement.setDate(10,null);
            }

            preparedStatement.setString(11,specialOutstandingResearcherForm.getApplicant_name());
            preparedStatement.setString(12,specialOutstandingResearcherForm.getJob());
            preparedStatement.setString(13,specialOutstandingResearcherForm.getCollege());
            preparedStatement.setString(14,specialOutstandingResearcherForm.getDepartment());
            preparedStatement.setString(15,specialOutstandingResearcherForm.getSeniority());
            preparedStatement.setBoolean(16,specialOutstandingResearcherForm.isExecuted_tech_proj());
            preparedStatement.setString(17,specialOutstandingResearcherForm.getTech_proj_id());
            try{
                preparedStatement.setDate(18,new java.sql.Date(specialOutstandingResearcherForm.getTech_proj_start_time().getTime()));
            }catch ( Exception e ) {
                preparedStatement.setDate(18,null);
            }

            try{
                preparedStatement.setDate(19,new java.sql.Date(specialOutstandingResearcherForm.getTech_proj_end_time().getTime()));
            }catch ( Exception e ) {
                preparedStatement.setDate(19,null);
            }

            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        update_specified_standard_of_form(specialOutstandingResearcherForm.getStandard_list(),specialOutstandingResearcherForm.getProject_id());
    }

    private SpecialOutstandingResearcherForm query_specified_special_researcher_application( int project_id ) {
        Connection connection = dbConnection.getConnection();
        SpecialOutstandingResearcherForm specialOutstandingResearcherForm = new SpecialOutstandingResearcherForm( project_id ) ;

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SPECIFIED_Special_Outstanding_Researcher_Applicaiotn))
        {
            preparedStatement.setInt(1,project_id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            if ( resultSet.next() ) {
                specialOutstandingResearcherForm.setApplicant_name( resultSet.getString("applicant_name") ) ;
                specialOutstandingResearcherForm.setJob( resultSet.getString("job") );
                specialOutstandingResearcherForm.setCollege(resultSet.getString("college"));
                specialOutstandingResearcherForm.setDepartment(resultSet.getString("department"));
                specialOutstandingResearcherForm.setSeniority(resultSet.getString("seniority"));
                specialOutstandingResearcherForm.setExecuted_tech_proj(resultSet.getBoolean("executed_tech_proj"));
                specialOutstandingResearcherForm.setTech_proj_id(resultSet.getString("tech_proj_id"));
                specialOutstandingResearcherForm.setTech_proj_start_time(resultSet.getDate("tech_proj_start_time"));
                specialOutstandingResearcherForm.setTech_proj_end_time(resultSet.getDate("tech_proj_end_time"));
            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return specialOutstandingResearcherForm ;
    }

    private List<SpecialOutstandingResearcherStandard> query_specified_special_researcher_application_standard(int project_id) {
        Connection connection = dbConnection.getConnection();
        List<SpecialOutstandingResearcherStandard> specialOutstandingResearcherStandardList = new ArrayList<>() ;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SPECIFIED_Special_Outstanding_Researcher_Applicaiotn_Standard))
        {
            preparedStatement.setInt(1,project_id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            while ( resultSet.next() ) {
                SpecialOutstandingResearcherStandard specialOutstandingResearcherStandard = new SpecialOutstandingResearcherStandard() ;

                specialOutstandingResearcherStandard.setLevel_num( resultSet.getString("level_num") );
                specialOutstandingResearcherStandard.setStandard(resultSet.getString("standard"));
                specialOutstandingResearcherStandard.setSub_standard(resultSet.getString("sub_standard"));

                specialOutstandingResearcherStandardList.add( specialOutstandingResearcherStandard );
            }
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return specialOutstandingResearcherStandardList ;
    }

    @Override
    public SpecialOutstandingResearcherForm query(int project_id) {
        SpecialOutstandingResearcherForm specialOutstandingResearcherForm = query_specified_special_researcher_application(project_id) ;
        specialOutstandingResearcherForm.setStandard_list( query_specified_special_researcher_application_standard(project_id) );


        return specialOutstandingResearcherForm ;
    }
}
