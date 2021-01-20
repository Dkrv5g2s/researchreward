package Dao.SpecialOutstandingResearcherApplication;

import Bean.SpecialOutstandingResearcher.PaperPerformance;
import Bean.SpecialOutstandingResearcher.PaperPerformanceDescriptionForm;

import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaperPerformanceDescriptionDAOImpl implements PaperPerformanceDescriptionDAO {

    private DBConnection dbConnection = new DBConnectionImpl();


    private static final String SELECT_SPECIFIED_Paper_Performance = "SELECT * FROM paper_performance WHERE project_id = ? " ;
    private static final String SELECT_SPECIFIED_Paper_Performance_Description = "SELECT * FROM paper_performance_description WHERE project_id = ? " ;

    private static final String INSERT_INTO_SPECIFIED_Paper_Performance_Description = "INSERT INTO paper_performance_description(project_id,fwci_value_past_five_year,total_point) VALUES (?,?,?) " +
            "ON DUPLICATE KEY UPDATE fwci_value_past_five_year = ?,total_point = ? ;";
    private static final String DELETE_SPECIFIED_Paper_Performance = "DELETE FROM paper_performance WHERE project_id = ?" ;
    private static final String INSERT_INTO_SPECIFIED_Paper_Performance = "INSERT INTO paper_performance(project_id, author, book_name, scholarly_journals_name, total_roll ,total_page , publish_time, rank_of_scholarly_journals , author_order , communication_author_count , additional_weight , cal_point ) "  +
            "VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ";

    private PaperPerformanceDescriptionForm query_specified_paper_performance_description( int project_id ) {
        Connection connection = dbConnection.getConnection();
        PaperPerformanceDescriptionForm paperPerformanceDescriptionForm = new PaperPerformanceDescriptionForm( project_id ) ;

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SPECIFIED_Paper_Performance_Description))
        {
            preparedStatement.setInt(1,project_id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            if ( resultSet.next() ) {

                paperPerformanceDescriptionForm.setFwci_value_past_five_year( resultSet.getString("fwci_value_past_five_year") );
                paperPerformanceDescriptionForm.setTotal_point( resultSet.getString( "total_point" ) );
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return paperPerformanceDescriptionForm ;
    }

    private List<PaperPerformance> query_specified_paper_performance(int project_id ) {
        Connection connection = dbConnection.getConnection();
        List<PaperPerformance> paperPerformanceList = new ArrayList<>() ;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SPECIFIED_Paper_Performance))
        {
            preparedStatement.setInt(1,project_id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            while ( resultSet.next() ) {
                PaperPerformance paperPerformance = new PaperPerformance() ;
                paperPerformance.setAuthor_name( resultSet.getString("author") ) ;
                paperPerformance.setBook_name( resultSet.getString("book_name") );
                paperPerformance.setScholarly_journals_name( resultSet.getString("scholarly_journals_name") );

                paperPerformance.setTotal_roll( resultSet.getString("total_roll") );
                paperPerformance.setTotal_page( resultSet.getString("total_page") );
                paperPerformance.setPublish_time( resultSet.getString("publish_time") );
                paperPerformance.setRank_of_scholarly_journals( resultSet.getString( "rank_of_scholarly_journals") );

                paperPerformance.setAuthor_order( resultSet.getString( "author_order" ) );
                paperPerformance.setCommunication_author_count( resultSet.getString("communication_author_count") );
                paperPerformance.setAdditional_weight( resultSet.getString("additional_weight") );
                paperPerformance.setCal_point( resultSet.getString("cal_point") );

                paperPerformanceList.add( paperPerformance );
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return paperPerformanceList ;
    }

    @Override
    public PaperPerformanceDescriptionForm query(int project_id) {

        PaperPerformanceDescriptionForm paperPerformanceDescriptionForm = query_specified_paper_performance_description(project_id) ;
        paperPerformanceDescriptionForm.setPaper_performance_list( query_specified_paper_performance(project_id) );

        return paperPerformanceDescriptionForm;
    }

    private void update_paper_performance_description_form( PaperPerformanceDescriptionForm paperPerformanceDescriptionForm ) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_SPECIFIED_Paper_Performance_Description))
        {
            preparedStatement.setInt(1,paperPerformanceDescriptionForm.getProject_id());
            preparedStatement.setString(2, paperPerformanceDescriptionForm.getFwci_value_past_five_year());
            preparedStatement.setString(3,paperPerformanceDescriptionForm.getTotal_point());

            preparedStatement.setString(4, paperPerformanceDescriptionForm.getFwci_value_past_five_year());
            preparedStatement.setString(5,paperPerformanceDescriptionForm.getTotal_point());

            preparedStatement.executeUpdate() ;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void delete_specified_paper_performance( int project_id ) {

        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SPECIFIED_Paper_Performance))
        {
            preparedStatement.setInt(1,project_id);
            preparedStatement.executeUpdate() ;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insert_all_paper_performance( List<PaperPerformance> paperPerformancesList , int project_id ) {
        Connection connection = dbConnection.getConnection();

        for ( PaperPerformance paperPerformance: paperPerformancesList ) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_SPECIFIED_Paper_Performance))
            {
                preparedStatement.setInt(1,project_id);
                preparedStatement.setString(2, paperPerformance.getAuthor_name());
                preparedStatement.setString(3, paperPerformance.getBook_name());
                preparedStatement.setString(4, paperPerformance.getScholarly_journals_name());
                preparedStatement.setString(5,paperPerformance.getTotal_roll());
                preparedStatement.setString(6,paperPerformance.getTotal_page()    );
                preparedStatement.setString(7,paperPerformance.getPublish_time());
                preparedStatement.setString(8,paperPerformance.getRank_of_scholarly_journals());
                preparedStatement.setString(9,paperPerformance.getAuthor_order());
                preparedStatement.setString(10,paperPerformance.getCommunication_author_count());
                preparedStatement.setString(11,paperPerformance.getAdditional_weight());
                preparedStatement.setString(12,paperPerformance.getCal_point());

                preparedStatement.executeUpdate() ;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    private void update_paper_performance( PaperPerformanceDescriptionForm paperPerformanceDescriptionForm ) {
        delete_specified_paper_performance( paperPerformanceDescriptionForm.getProject_id() ) ;
        insert_all_paper_performance(paperPerformanceDescriptionForm.getPaper_performance_list(), paperPerformanceDescriptionForm.getProject_id() ) ;
    }

    @Override
    public void update(PaperPerformanceDescriptionForm paperPerformanceDescriptionForm) {
        update_paper_performance_description_form(  paperPerformanceDescriptionForm) ;
        update_paper_performance( paperPerformanceDescriptionForm ) ;
    }
}
