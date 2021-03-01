

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
        System.out.println(connection);
        Assert.assertNotNull(connection);

    }
    @Test
    public void TeacherEvaluationDBConnectionTest(){
        TeacherEvaluationDBConnectionImpl TEdb = new TeacherEvaluationDBConnectionImpl();
        Connection connection = TEdb.getConnection();
        System.out.println(connection);
        Assert.assertNotNull(connection);

    }

}
