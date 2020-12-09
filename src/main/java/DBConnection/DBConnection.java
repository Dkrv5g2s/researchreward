package DBConnection;

import java.sql.Connection;

public interface DBConnection {

    public void buildConnection();
    public Connection getConnection();
}
