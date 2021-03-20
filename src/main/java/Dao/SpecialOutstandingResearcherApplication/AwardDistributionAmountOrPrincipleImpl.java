package Dao.SpecialOutstandingResearcherApplication;

import Bean.SpecialOutstandingResearcher.AwardDistributionAmountOrPrinciple;
import Bean.SpecialOutstandingResearcher.AwardDistributionAmountOrPrincipleForm;
import DBConnection.DBConnection;

import java.sql.Connection;
import DBConnection.DBConnectionImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AwardDistributionAmountOrPrincipleImpl implements AwardDistributionAmountOrPrincipleDAO {

    private DBConnection dbConnection = new DBConnectionImpl();


    private static final String SELECT_Award_Distribution_Amount_Or_Principle = "SELECT * FROM award_distribution_amount_or_principle WHERE project_id = ? " ;
    private static final String DELETE_Award_Distribution_Amount_OrPrinciple = "DELETE FROM award_distribution_amount_or_principle WHERE project_id = ? " ;
    private static final String INSERT_Award_Distribution_Amount_OrPrinciple = "INSERT INTO award_distribution_amount_or_principle(project_id,applicant_type,name,college_and_department, job ,year,month,principle ) VALUES(?,?,?,?,?,?,?,?); " ;


    @Override
    public AwardDistributionAmountOrPrincipleForm query(int project_id) {
        Connection connection = dbConnection.getConnection();

        AwardDistributionAmountOrPrincipleForm awardDistributionAmountOrPrincipleForm = new AwardDistributionAmountOrPrincipleForm( project_id ) ;
        List<AwardDistributionAmountOrPrinciple> awardDistributionAmountOrPrincipleFormList = new ArrayList<>() ;

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Award_Distribution_Amount_Or_Principle))
        {
            preparedStatement.setInt(1,project_id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            while ( resultSet.next() ) {
                AwardDistributionAmountOrPrinciple awardDistributionAmountOrPrinciple = new AwardDistributionAmountOrPrinciple() ;
                awardDistributionAmountOrPrinciple.setApplicant_type( resultSet.getString( "applicant_type" ) );
                awardDistributionAmountOrPrinciple.setName( resultSet.getString( "name" ) );
                awardDistributionAmountOrPrinciple.setCollege_and_department( resultSet.getString("college_and_department" ) );
                awardDistributionAmountOrPrinciple.setJob( resultSet.getString("job") );
                awardDistributionAmountOrPrinciple.setYear( resultSet.getString( "year" ) );
                awardDistributionAmountOrPrinciple.setMonth( resultSet.getString("month") );
                awardDistributionAmountOrPrinciple.setPrinciple( resultSet.getString( "principle" ) );

                awardDistributionAmountOrPrincipleFormList.add( awardDistributionAmountOrPrinciple );
            }

            awardDistributionAmountOrPrincipleForm.setAward_distribution_amount_or_principle_list( awardDistributionAmountOrPrincipleFormList );
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return awardDistributionAmountOrPrincipleForm ;
    }

    @Override
    public void update(AwardDistributionAmountOrPrincipleForm awardDistributionAmountOrPrincipleForm) {
        delete_specified_review_supporting_information( awardDistributionAmountOrPrincipleForm.getProject_id() ) ;
        insert_specified_review_supporting_information( awardDistributionAmountOrPrincipleForm.getAward_distribution_amount_or_principle_list(),awardDistributionAmountOrPrincipleForm.getProject_id() ) ;

    }


    private void delete_specified_review_supporting_information( int project_id ) {
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_Award_Distribution_Amount_OrPrinciple))
        {
            preparedStatement.setInt(1,project_id);
            preparedStatement.executeUpdate() ;
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void insert_specified_review_supporting_information(List<AwardDistributionAmountOrPrinciple> awardDistributionAmountOrPrincipleFormList, int project_id) {
        Connection connection = dbConnection.getConnection();
        for ( AwardDistributionAmountOrPrinciple awardDistributionAmountOrPrinciple : awardDistributionAmountOrPrincipleFormList ) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Award_Distribution_Amount_OrPrinciple))
            {
                preparedStatement.setInt(1,project_id);
                preparedStatement.setString(2, awardDistributionAmountOrPrinciple.getApplicant_type());
                preparedStatement.setString(3, awardDistributionAmountOrPrinciple.getName());
                preparedStatement.setString(4, awardDistributionAmountOrPrinciple.getCollege_and_department() );
                preparedStatement.setString(5, awardDistributionAmountOrPrinciple.getJob());
                preparedStatement.setString(6,awardDistributionAmountOrPrinciple.getYear());
                preparedStatement.setString(7, awardDistributionAmountOrPrinciple.getMonth());
                preparedStatement.setString(8,awardDistributionAmountOrPrinciple.getPrinciple());


                preparedStatement.executeUpdate() ;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
