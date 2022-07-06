package DBConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionImpl implements DBConnection{

//    private static final String URL = "jdbc:mysql://127.0.0.1:3306/rss?user=dev&password=islab1221&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

//    private static final String URL = "jdbc:mysql://140.124.181.4:8787/rss?user=dev&password=islab1221&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
//    ^ It's The DB which Belongs To Tomcat Server, Fewer Data In This DB, Not Using This DB Now. ^

    private static final String URL = "jdbc:mysql://140.124.184.171:8787/researchreward?user=dev&password=Islab@1221&useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
//    ^ Use This When Developing ^

    @Override
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return conn;
    }
}
