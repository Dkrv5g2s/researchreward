package Dao.SpecialOutstandingResearcherApplication;

import Bean.JournalPaper.JournalPaper;
import Bean.SpecialOutstandingResearcher.PaperPerformance;
import Bean.SpecialOutstandingResearcher.PaperPerformanceDescriptionForm;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaperPerformanceDescriptionDAOImpl implements PaperPerformanceDescriptionDAO {

    private DBConnection dbConnection = new DBConnectionImpl();


    private static final String SELECT_SPECIFIED_Paper_Performance_with_project_id = "SELECT * FROM paper_performance WHERE project_id = ? " ;
    private static final String SELECT_SPECIFIED_Paper_Performance_Description = "SELECT * FROM paper_performance_description WHERE project_id = ? " ;
    private static final String INSERT_INTO_SPECIFIED_Paper_Performance_Description = "INSERT INTO paper_performance_description(project_id,commit_date) VALUES (?,?) " +
            "ON DUPLICATE KEY UPDATE commit_date = ?;";

    private static final String DELETE_SPECIFIED_Paper_Performance = "DELETE FROM paper_performance WHERE paper_id = ?" ;

    private static final String INSERT_INTO_SINGLE_DUPLICATED_Paper_Performance = "INSERT INTO paper_performance(paper_id, project_id, author, book_name, scholarly_journals_name, total_roll ,total_page , publish_time, rank_of_scholarly_journals , author_order , communication_author_count , additional_weight , cal_point) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) " +
            "ON DUPLICATE KEY UPDATE project_id =? , author =?, book_name=?, scholarly_journals_name=?, total_roll=? ,total_page=? , publish_time=?, rank_of_scholarly_journals=? , author_order=? , communication_author_count=? , additional_weight=? , cal_point=? ;";

    private static final String INSERT_INTO_SINGLE_NON_DUPLICATED_Paper_Performance = "INSERT INTO paper_performance(project_id, author, book_name, scholarly_journals_name, total_roll ,total_page , publish_time, rank_of_scholarly_journals , author_order , communication_author_count , additional_weight , cal_point) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) " ;

    private static final String SELECT_SPECIFIED_PAPER_PERFORMANCE_ALL_PAPER_ID = "SELECT paper_id FROM paper_performance where project_id = ?" ;

    private static final String SELECT_SPECIFIED_Paper_Performance_with_paper_id = "SELECT * FROM paper_performance WHERE paper_id = ? " ;

    private static final String UPDATE_SPECIFIED_Paper_Performance_File_Path = "UPDATE paper_performance SET joint_authoriztion_agreement_file_path = ?, paper_home_file_path=? WHERE paper_id = ?" ;

    private static final String SELECT_TOTAL_PAPER_SENTENCE = "SELECT book_name,scholarly_journals_name FROM paper_performance ";

    private static final String SELECT_TOTAL_PAPER_SENTENCE_IN_SPECIFIED_REWARD =
            "SELECT book_name,scholarly_journals_name FROM paper_performance where project_id in (" +
            "SELECT project_id FROM reward_project where reward_type =  ?)";

    private static final String SELECT_SPECIFIED_PAPER_TITLE = "SELECT * FROM paper_performance WHERE paper_id = ? AND book_name = ? AND scholarly_journals_name = ?";

    private static final String SELECT_USER_NAME_VIA_PAPER_TITLE =
            "SELECT name FROM user where number in (" +
            "SELECT staff_code FROM reward_project where project_id in (" +
            "SELECT project_id FROM paper_performance where book_name = ?))";

    private static final String INSERT_JOURNAL_PAPER_TO_PAPER_PERFORMANCE = "INSERT INTO paper_performance(project_id, author, book_name, scholarly_journals_name, total_roll ,total_page , publish_time, author_order, communication_author_count) VALUES (?,?,?,?,?,?,?,?,?)";

    @Override // Dfone, added for auto fill in.
    public void insert_journal_papers(int project_id, List<JournalPaper> journals) {
        Connection connection = dbConnection.getConnection();
        int FillInPapers = 0;
        for (JournalPaper journalPaper : journals) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_JOURNAL_PAPER_TO_PAPER_PERFORMANCE))
            {
                preparedStatement.setInt(1,project_id);
                preparedStatement.setString(2, journalPaper.getStaff_cname());
                preparedStatement.setString(3, journalPaper.getThesis_name());
                preparedStatement.setString(4, journalPaper.getJournal_name());
                preparedStatement.setString(5, journalPaper.getVolume());
                preparedStatement.setString(6, journalPaper.getPages());
                preparedStatement.setString(7, journalPaper.getPublic_year());
                int author_order = journalPaper.getW2_author_order();
                getAuthorDescription(author_order);
                preparedStatement.setString(8, getAuthorDescription(author_order));
                String communication_author_count = journalPaper.getW3_corresponding();
                if (communication_author_count.equals("1")) {
                    communication_author_count = "1位通訊作者";
                } else {
                    communication_author_count = "2位(含)以上";
                }
                preparedStatement.setString(9, communication_author_count);
                preparedStatement.executeUpdate();
                FillInPapers++;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("filled in "+FillInPapers+" papers to project No."+project_id);
    }

    // Dfone, added for auto fill in.
    private String getAuthorDescription(int author_order) {
        if (author_order==1) {
            return "第一作者或通訊作者";
        }
        else if (author_order==2) {
            return "第二作者";
        }
        else if (author_order==3) {
            return "第三作者";
        }
        else if (author_order==4) {
            return "第四作者";
        }
        else if (author_order>=5) {
            return "第五作者以上";
        }
        else{
            return null;
        }
    }

    private PaperPerformanceDescriptionForm query_specified_paper_performance_description( int project_id ) {
        Connection connection = dbConnection.getConnection();
        PaperPerformanceDescriptionForm paperPerformanceDescriptionForm = new PaperPerformanceDescriptionForm( project_id ) ;

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SPECIFIED_Paper_Performance_Description))
        {
            preparedStatement.setInt(1,project_id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            if ( resultSet.next() ) {

                paperPerformanceDescriptionForm.setCommitDate( resultSet.getString("commit_date") );
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return paperPerformanceDescriptionForm ;
    }

    private List<PaperPerformance> query_specified_paper_performance_without_file_path(int project_id ) {
        Connection connection = dbConnection.getConnection();
        List<PaperPerformance> paperPerformanceList = new ArrayList<>() ;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SPECIFIED_Paper_Performance_with_project_id))
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
                paperPerformance.setPaper_id( resultSet.getInt("paper_id") );

                paperPerformance.setJoint_authorization_agreement_file_path( resultSet.getString( "joint_authoriztion_agreement_file_path" ) );
                paperPerformance.setPaper_home_file_path( resultSet.getString("paper_home_file_path") );

                paperPerformanceList.add( paperPerformance );
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return paperPerformanceList ;
    }

    @Override
    public PaperPerformanceDescriptionForm query_specified_paper_performance_description_form(int project_id) {

        PaperPerformanceDescriptionForm paperPerformanceDescriptionForm = query_specified_paper_performance_description(project_id) ;
        paperPerformanceDescriptionForm.setPaper_performance_list( query_specified_paper_performance_without_file_path(project_id) );

        return paperPerformanceDescriptionForm;
    }

    private void update_paper_performance_description_form( PaperPerformanceDescriptionForm paperPerformanceDescriptionForm ) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_SPECIFIED_Paper_Performance_Description))
        {
            preparedStatement.setInt(1,paperPerformanceDescriptionForm.getProject_id());
            preparedStatement.setString(2, paperPerformanceDescriptionForm.getCommitDate());
            preparedStatement.setString(3, paperPerformanceDescriptionForm.getCommitDate());

            preparedStatement.executeUpdate() ;
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void delete_specified_paper_performance( int paper_id ) {

        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SPECIFIED_Paper_Performance))
        {
            preparedStatement.setInt(1,paper_id);
            preparedStatement.executeUpdate() ;
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insert_into_single_duplicated_paper_performance( PaperPerformance paperPerformance, int project_id ) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_SINGLE_DUPLICATED_Paper_Performance))
        {
            preparedStatement.setInt(1,paperPerformance.getPaper_id());
            preparedStatement.setInt(2,project_id);
            preparedStatement.setString(3, paperPerformance.getAuthor_name());
            preparedStatement.setString(4, paperPerformance.getBook_name());
            preparedStatement.setString(5, paperPerformance.getScholarly_journals_name());
            preparedStatement.setString(6,paperPerformance.getTotal_roll());
            preparedStatement.setString(7,paperPerformance.getTotal_page());
            preparedStatement.setString(8,paperPerformance.getPublish_time());
            preparedStatement.setString(9,paperPerformance.getRank_of_scholarly_journals());
            preparedStatement.setString(10,paperPerformance.getAuthor_order());
            preparedStatement.setString(11,paperPerformance.getCommunication_author_count());
            preparedStatement.setString(12,paperPerformance.getAdditional_weight());
            preparedStatement.setString(13,paperPerformance.getCal_point());

            preparedStatement.setInt(14,project_id);
            preparedStatement.setString(15, paperPerformance.getAuthor_name());
            preparedStatement.setString(16, paperPerformance.getBook_name());
            preparedStatement.setString(17, paperPerformance.getScholarly_journals_name());
            preparedStatement.setString(18,paperPerformance.getTotal_roll());
            preparedStatement.setString(19,paperPerformance.getTotal_page());
            preparedStatement.setString(20,paperPerformance.getPublish_time());
            preparedStatement.setString(21,paperPerformance.getRank_of_scholarly_journals());
            preparedStatement.setString(22,paperPerformance.getAuthor_order());
            preparedStatement.setString(23,paperPerformance.getCommunication_author_count());
            preparedStatement.setString(24,paperPerformance.getAdditional_weight());
            preparedStatement.setString(25,paperPerformance.getCal_point());


            preparedStatement.executeUpdate() ;
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void insert_into_single_non_duplicated_paper_performance( PaperPerformance paperPerformance, int project_id ) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_SINGLE_NON_DUPLICATED_Paper_Performance))
        {
            preparedStatement.setInt(1,project_id);
            preparedStatement.setString(2, paperPerformance.getAuthor_name());
            preparedStatement.setString(3, paperPerformance.getBook_name());
            preparedStatement.setString(4, paperPerformance.getScholarly_journals_name());
            preparedStatement.setString(5,paperPerformance.getTotal_roll());
            preparedStatement.setString(6,paperPerformance.getTotal_page());
            preparedStatement.setString(7,paperPerformance.getPublish_time());
            preparedStatement.setString(8,paperPerformance.getRank_of_scholarly_journals());
            preparedStatement.setString(9,paperPerformance.getAuthor_order());
            preparedStatement.setString(10,paperPerformance.getCommunication_author_count());
            preparedStatement.setString(11,paperPerformance.getAdditional_weight());
            preparedStatement.setString(12,paperPerformance.getCal_point());

            preparedStatement.executeUpdate() ;
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insert_all_paper_performance( List<PaperPerformance> paperPerformancesList , int project_id ) {

        for ( PaperPerformance paperPerformance :paperPerformancesList ) {
            if ( paperPerformance.getPaper_id() == 0 ) {
                insert_into_single_non_duplicated_paper_performance( paperPerformance, project_id );
            }
            else {
                insert_into_single_duplicated_paper_performance( paperPerformance, project_id );
            }
        }

    }

    private boolean isInNewestPaperPerformanceList( List<PaperPerformance> paperPerformanceList, int dataBase_paper_id ) {
        for ( PaperPerformance paperPerformance : paperPerformanceList ) {
            if ( dataBase_paper_id == paperPerformance.getPaper_id() )
                return true ;
        }

        return false ;
    }

    private List<Integer> query_specified_paper_id_list( int project_id ) {

        List<Integer> paper_id_list = new ArrayList<>() ;

        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SPECIFIED_PAPER_PERFORMANCE_ALL_PAPER_ID))
        {
            preparedStatement.setInt(1,project_id);
            ResultSet resultSet = preparedStatement.executeQuery() ;

            while ( resultSet.next() ) {
                paper_id_list.add( resultSet.getInt( "paper_id" ) );
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  paper_id_list ;
    }

    private void delete_specified_paper_performance_list( List<PaperPerformance> paperPerformanceList, int project_id ) {
        List<Integer> paper_id_list = query_specified_paper_id_list( project_id ) ;



        for ( int dataBase_paper_id : paper_id_list ) {
            if ( !isInNewestPaperPerformanceList(paperPerformanceList , dataBase_paper_id) )
                delete_specified_paper_performance( dataBase_paper_id );
        }

    }

    private void update_paper_performance( PaperPerformanceDescriptionForm paperPerformanceDescriptionForm ) {
        List<PaperPerformance> paperPerformanceList = paperPerformanceDescriptionForm.getPaper_performance_list() ;

        delete_specified_paper_performance_list( paperPerformanceList, paperPerformanceDescriptionForm.getProject_id() ) ;

        insert_all_paper_performance(paperPerformanceDescriptionForm.getPaper_performance_list(), paperPerformanceDescriptionForm.getProject_id() ) ;
    }

    @Override
    public void update(PaperPerformanceDescriptionForm paperPerformanceDescriptionForm) {
        update_paper_performance_description_form(  paperPerformanceDescriptionForm) ;
        update_paper_performance( paperPerformanceDescriptionForm ) ;
    }

    @Override
    public PaperPerformance query_specified_paper_performance(int paper_id) {
        Connection connection = dbConnection.getConnection();
        PaperPerformance paperPerformance = new PaperPerformance() ;

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SPECIFIED_Paper_Performance_with_paper_id))
        {
            preparedStatement.setInt(1,paper_id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            if ( resultSet.next() ) {
                paperPerformance.setPaper_id( paper_id );
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
                paperPerformance.setPaper_id( resultSet.getInt("paper_id") );

                paperPerformance.setJoint_authorization_agreement_file_path( resultSet.getString( "joint_authoriztion_agreement_file_path" ) );
                paperPerformance.setPaper_home_file_path( resultSet.getString("paper_home_file_path") );
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperPerformance;
    }

    @Override
    public void update_specified_paper_performance(PaperPerformance paperPerformance) {
        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SPECIFIED_Paper_Performance_File_Path))
        {
            preparedStatement.setString(1,paperPerformance.getJoint_authorization_agreement_file_path());
            preparedStatement.setString(2,paperPerformance.getPaper_home_file_path());
            preparedStatement.setInt(3, paperPerformance.getPaper_id());

            preparedStatement.executeUpdate() ;
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<String> query_total_paper_sentence() {

        List<String> paper_title_list = new ArrayList<>() ;

        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TOTAL_PAPER_SENTENCE))
        {
            ResultSet resultSet = preparedStatement.executeQuery() ;

            while ( resultSet.next() ) {
                String paperSentence = resultSet.getString( "book_name" ) + resultSet.getString( "scholarly_journals_name" );
                paper_title_list.add( paperSentence );
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  paper_title_list ;
    }
    @Override
    public List<String> query_total_paper_sentence_in_specified_reward(String reward_type) {

        List<String> paper_title_list = new ArrayList<>() ;

        Connection connection = dbConnection.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TOTAL_PAPER_SENTENCE_IN_SPECIFIED_REWARD))
        {
            preparedStatement.setString(1, reward_type);

            ResultSet resultSet = preparedStatement.executeQuery() ;

            while ( resultSet.next() ) {
                String paperSentence = resultSet.getString( "book_name" ) + resultSet.getString( "scholarly_journals_name" );
                paper_title_list.add( paperSentence );
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  paper_title_list ;
    }

    @Override
    public boolean query_whether_specified_paper_sentence_existed_already(PaperPerformance paperPerformance){
        boolean query_result = true;
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SPECIFIED_PAPER_TITLE))
        {
            preparedStatement.setInt(1,paperPerformance.getPaper_id());
            preparedStatement.setString(2, paperPerformance.getBook_name());
            preparedStatement.setString(3, paperPerformance.getScholarly_journals_name());
            ResultSet resultSet = preparedStatement.executeQuery() ;
            if(!resultSet.next()){
                query_result = false;
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return   query_result;
    }
    @Override
    public String queryUserNameByPaperTitle(String PaperTitle){
        String queryResult = "";
        Connection connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_NAME_VIA_PAPER_TITLE))
        {
            preparedStatement.setString(1, PaperTitle);
//            System.out.println(preparedStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery() ;
            while ( resultSet.next() ) {
                queryResult = resultSet.getString("name");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return   queryResult;
    }


}
