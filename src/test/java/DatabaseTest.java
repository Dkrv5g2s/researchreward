import DBConnection.DBConnectionImpl;
import DBConnection.TeacherEvaluationDBConnectionImpl;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DatabaseTest {
    @Test
    public void DatabaseConnectionTest(){
        DBConnectionImpl db = new DBConnectionImpl();
        Connection connection = db.getConnection();
//        System.out.println(connection);
        Assert.assertNotNull(connection);

    }
    @Test
    public void TeacherEvaluationDBConnectionTest(){

        // 專案目錄不可以有中文字 否則會失敗!
        // ref : https://blog.csdn.net/weixin_43584574/article/details/102657174
        TeacherEvaluationDBConnectionImpl TEdb = new TeacherEvaluationDBConnectionImpl();
        Connection connection = TEdb.getConnection();
//        System.out.println(connection);
        Assert.assertNotNull(connection);
    }

    @Test
    public void getInsertedIdWhenInsert() throws SQLException {
        DBConnectionImpl db = new DBConnectionImpl();
        Connection connection = db.getConnection();
        // get current max id in table
        int current_max_id = 0;
        String SELECT_MAX_ID = "SELECT MAX(paper_id) AS max_id FROM paper_performance";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MAX_ID)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                current_max_id = resultSet.getInt("max_id");
                System.out.println("current_max_id = "+current_max_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // insert a new row in table and check if inserted id is ${current_max_id}+1
        String INSERT_JOURNAL_PAPER_TO_PAPER_PERFORMANCE = "INSERT INTO paper_performance (project_id) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_JOURNAL_PAPER_TO_PAPER_PERFORMANCE, PreparedStatement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setInt(1,99);
            preparedStatement.executeUpdate();
            int inserted_id = 0;
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                inserted_id = resultSet.getInt(1);
            }
            System.out.println(inserted_id);
            Assert.assertEquals(current_max_id+1, inserted_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
