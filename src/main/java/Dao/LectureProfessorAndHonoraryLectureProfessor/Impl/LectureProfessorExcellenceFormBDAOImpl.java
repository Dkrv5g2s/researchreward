package Dao.LectureProfessorAndHonoraryLectureProfessor.Impl;

import Bean.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormB;
import Dao.LectureProfessorAndHonoraryLectureProfessor.LectureProfessorExcellenceFormBDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DBConnection.DBConnection;
import DBConnection.DBConnectionImpl;

public class LectureProfessorExcellenceFormBDAOImpl implements LectureProfessorExcellenceFormBDAO{
    private DBConnection dbConnection = new DBConnectionImpl();
    private static final String SELECT = "SELECT * FROM lectureprofessorexcellenceformb WHERE projectID = ?";
    private static final String INSERT =
            "INSERT INTO lectureprofessorexcellenceformb (projectID, userNumber, name, workName, journalName, volumn, page, publishYear, w1_150p, w1_40p, w1_20p, w1_10p, w1_5p, w1_2p, w1_1p, w2_m100p, w2_m80p, w2_m60p, w2_m40p, w2_m20p, w2_m90p, w3_m100p, w3_m80p, w4_m110p, w4_m110p2, w4_m120p, w4_m150p, w4_m165p, w4_m165p2, w4_m180p, total)"+
                    " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE =
            "DELETE FROM lectureprofessorexcellenceformb "+
                    " WHERE projectID = ?";
    @Override
    public void save(List<LectureProfessorExcellenceFormB> object, String userNumber, String projectID) {
        Connection connection = dbConnection.getConnection();

        delete(connection,projectID);
        if(!object.isEmpty()) {
            insert(connection,object,projectID);
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public List<LectureProfessorExcellenceFormB> show(String projectID) {
        Connection connection = dbConnection.getConnection();
        ResultSet resultSet = null;
        List<LectureProfessorExcellenceFormB> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT))
        {
            preparedStatement.setString(1,projectID);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                LectureProfessorExcellenceFormB lpefb = null;
                lpefb = new LectureProfessorExcellenceFormB(
                        resultSet.getString("userNumber"),
                        resultSet.getString("author"),
                        resultSet.getString("book_name"),
                        resultSet.getString("article_name"),
                        resultSet.getString("total_roll"),
                        resultSet.getString("total_page"),
                        resultSet.getString("publish_time"),
                        resultSet.getBoolean("rank_condition_one"),
                        resultSet.getBoolean("rank_condition_two"),
                        resultSet.getBoolean("rank_condition_three"),
                        resultSet.getBoolean("rank_condition_four"),
                        resultSet.getBoolean("rank_condition_five"),
                        resultSet.getBoolean("rank_condition_six"),
                        resultSet.getBoolean("rank_condition_seven"),
                        resultSet.getBoolean("author_order_one"),
                        resultSet.getBoolean("author_order_two"),
                        resultSet.getBoolean("author_order_three"),
                        resultSet.getBoolean("author_order_four"),
                        resultSet.getBoolean("author_order_five"),
                        resultSet.getBoolean("author_order_six"),
                        resultSet.getBoolean("communication_author_count_one"),
                        resultSet.getBoolean("communication_author_count_two"),
                        resultSet.getBoolean("additional_weight_one"),
                        resultSet.getBoolean("additional_weight_two"),
                        resultSet.getBoolean("additional_weight_three"),
                        resultSet.getBoolean("additional_weight_four"),
                        resultSet.getBoolean("additional_weight_five"),
                        resultSet.getBoolean("additional_weight_six"),
                        resultSet.getBoolean("additional_weight_seven"),
                        resultSet.getString("total"));
                list.add(lpefb);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return list;
    }


    public void insert(Connection connection,List<LectureProfessorExcellenceFormB> object,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT))
        {
            for(int i = 0;i<object.size();i++) {
                preparedStatement.setString(1,projectID);
                preparedStatement.setString(2,object.get(i).getUserNumber());
                preparedStatement.setString(3,object.get(i).getAuthor());
                preparedStatement.setString(4,object.get(i).getBook_name());
                preparedStatement.setString(5,object.get(i).getArticle_name());
                preparedStatement.setString(6,object.get(i).getTotal_roll());
                preparedStatement.setString(7,object.get(i).getTotal_page());
                preparedStatement.setString(8,object.get(i).getPublish_time());
                preparedStatement.setBoolean(9,object.get(i).isRank_condition_one());
                preparedStatement.setBoolean(10,object.get(i).isRank_condition_two());
                preparedStatement.setBoolean(11,object.get(i).isRank_condition_three());
                preparedStatement.setBoolean(12,object.get(i).isRank_condition_four());
                preparedStatement.setBoolean(13,object.get(i).isRank_condition_five());
                preparedStatement.setBoolean(14,object.get(i).isRank_condition_six());
                preparedStatement.setBoolean(15,object.get(i).isRank_condition_seven());
                preparedStatement.setBoolean(16,object.get(i).isAuthor_order_one());
                preparedStatement.setBoolean(17,object.get(i).isAuthor_order_two());
                preparedStatement.setBoolean(18,object.get(i).isAuthor_order_three());
                preparedStatement.setBoolean(19,object.get(i).isAuthor_order_four());
                preparedStatement.setBoolean(20,object.get(i).isAuthor_order_five());
                preparedStatement.setBoolean(21,object.get(i).isAuthor_order_six());
                preparedStatement.setBoolean(22,object.get(i).isCommunication_author_count_one());
                preparedStatement.setBoolean(23,object.get(i).isCommunication_author_count_two());
                preparedStatement.setBoolean(24,object.get(i).isAdditional_weight_one());
                preparedStatement.setBoolean(25,object.get(i).isAdditional_weight_two());
                preparedStatement.setBoolean(26,object.get(i).isAdditional_weight_three());
                preparedStatement.setBoolean(27,object.get(i).isAdditional_weight_four());
                preparedStatement.setBoolean(28,object.get(i).isAdditional_weight_five());
                preparedStatement.setBoolean(29,object.get(i).isAdditional_weight_six());
                preparedStatement.setBoolean(30,object.get(i).isAdditional_weight_seven());
                preparedStatement.setString(31,object.get(i).getTotal());

                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Connection connection,String projectID) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE))
        {

            preparedStatement.setString(1,projectID);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
