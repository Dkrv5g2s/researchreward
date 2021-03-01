

import DBConnection.DBConnectionImpl;
import DBConnection.TeacherEvaluationDBConnectionImpl;
import org.junit.Test;
import org.junit.Assert;
import java.sql.Connection;


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

}
