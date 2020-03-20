package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccessObject {
    protected Connection connection;
    protected PreparedStatement preparedStatament;
    protected ResultSet resultSet;
    
    protected void executeQuery(String sql_query) {
        try {
            connection = DataBaseConnection.getConnection();
            preparedStatament = connection.prepareStatement(sql_query);
            resultSet = preparedStatament.executeQuery();
        }catch(SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }
    
    protected void executeUpdate(String sql_query) {
        try {
            connection = DataBaseConnection.getConnection();
            preparedStatament = connection.prepareStatement(sql_query);
            preparedStatament.executeUpdate();
        }catch(SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }
}
