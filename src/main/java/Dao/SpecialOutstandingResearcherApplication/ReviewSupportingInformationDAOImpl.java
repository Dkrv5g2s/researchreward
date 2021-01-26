package Dao.SpecialOutstandingResearcherApplication;

import Bean.SpecialOutstandingResearcher.PaperPerformanceDescriptionForm;
import Bean.SpecialOutstandingResearcher.ReviewSupportingInformation;
import Bean.SpecialOutstandingResearcher.ReviewSupportingInformationForm;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReviewSupportingInformationDAOImpl implements  ReviewSupportingInformationDAO {

    private DBConnection dbConnection = new DBConnectionImpl();


    private static final String SELECT_review_review_supporting_information = "SELECT * FROM review_supporting_information WHERE project_id = ? " ;
    private static final String DELETE_review_review_supporting_information = "DELETE FROM review_supporting_information WHERE project_id = ? " ;
    private static final String INSERT_review_review_supporting_information = "INSERT INTO review_supporting_information(project_id,contract_name,technology_transfer_unit,contract_date,actually_received_technology_transfer_funds,technical_transfer_funds_include_date ) VALUES(?,?,?,?,?,?); " ;

    @Override
    public ReviewSupportingInformationForm query(int project_id) {
        Connection connection = dbConnection.getConnection();

        ReviewSupportingInformationForm reviewSupportingInformationForm = new ReviewSupportingInformationForm( project_id ) ;
        List<ReviewSupportingInformation> reviewSupportingInformationList = new ArrayList<>() ;

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_review_review_supporting_information))
        {
            preparedStatement.setInt(1,project_id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            while ( resultSet.next() ) {
                ReviewSupportingInformation reviewSupportingInformation = new ReviewSupportingInformation() ;
                reviewSupportingInformation.setContract_name( resultSet.getString( "contract_name" ) );
                reviewSupportingInformation.setTechnology_transfer_unit( resultSet.getString( "technology_transfer_unit" ) );
                reviewSupportingInformation.setContract_date( resultSet.getDate("contract_date") );
                reviewSupportingInformation.setActually_received_technology_transfer_funds( resultSet.getString("actually_received_technology_transfer_funds" ) );
                reviewSupportingInformation.setTechnical_transfer_funds_include_date( resultSet.getDate("technical_transfer_funds_include_date") );

                reviewSupportingInformationList.add( reviewSupportingInformation );
            }

            reviewSupportingInformationForm.setReview_supporting_information_list( reviewSupportingInformationList );
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reviewSupportingInformationForm ;
    }

    private void delete_specified_review_supporting_information( int project_id ) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_review_review_supporting_information))
        {
            preparedStatement.setInt(1,project_id);
            preparedStatement.executeUpdate() ;
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void insert_specified_review_supporting_information(List<ReviewSupportingInformation> reviewSupportingInformationList, int project_id) {
        Connection connection = dbConnection.getConnection();
        for ( ReviewSupportingInformation reviewSupportingInformation : reviewSupportingInformationList ) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_review_review_supporting_information))
            {
                preparedStatement.setInt(1,project_id);
                preparedStatement.setString(2, reviewSupportingInformation.getContract_name());
                preparedStatement.setString(3, reviewSupportingInformation.getTechnology_transfer_unit());
                try {
                    preparedStatement.setDate(4, new java.sql.Date(reviewSupportingInformation.getContract_date().getTime()));
                }catch ( Exception e ) {
                    preparedStatement.setDate(4, null) ;
                }

                preparedStatement.setString(5, reviewSupportingInformation.getActually_received_technology_transfer_funds());

                try {
                    preparedStatement.setDate(6, new java.sql.Date( reviewSupportingInformation.getTechnical_transfer_funds_include_date().getTime() ) );
                }catch (Exception e) {
                    preparedStatement.setDate(6, null);
                }


                preparedStatement.executeUpdate() ;
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void update(ReviewSupportingInformationForm reviewSupportingInformationForm) {
        delete_specified_review_supporting_information( reviewSupportingInformationForm.getProject_id() ) ;
        insert_specified_review_supporting_information( reviewSupportingInformationForm.getReview_supporting_information_list(), reviewSupportingInformationForm.getProject_id() ) ;
    }
}
