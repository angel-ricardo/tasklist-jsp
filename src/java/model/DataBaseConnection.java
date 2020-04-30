package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static Connection connection;
    
    private DataBaseConnection() {
        String db_url = "jdbc:mysql://localhost:3306/tasklist";
        String db_driver = "com.mysql.jdbc.Driver";
        String db_user = "root";
        String db_password = "";
        try {
            Class.forName( db_driver );
            connection = DriverManager.getConnection( db_url, db_user, db_password );
        } catch( ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }   
    }
    
    public static Connection getConnection() {
        if(  connection == null )
            new DataBaseConnection();
        return connection;
    }
}
