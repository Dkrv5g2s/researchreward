package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TeacherEvaluationDBConnectionImpl implements DBConnection{

    private static final String URL = "jdbc:informix-sqli://dbs-pp.cc.ntut.edu.tw:8800/db:ifx_use_strenc=true";
    private static final String user = "schreop";
    private static final String password = "re@schbas!";

    @Override
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.informix.jdbc.IfxDriver");
            conn = DriverManager.getConnection(URL,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex){
            System.out.println("connect fail");
            ex.printStackTrace();
        }
        return conn;
    }

}
