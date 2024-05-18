package dh.backend.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class H2Connection {

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clinica","sa","sa");
    }

}
