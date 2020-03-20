package model;

import interfaces.CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO extends DataAccessObject implements CRUD {
    
    private Task fillTaskValues( ResultSet resulSet, Task task ) throws SQLException {         
        task.setId( resultSet.getInt("id") );
        task.setTitle( resultSet.getString("title") );
        task.setDescription( resultSet.getString("description") );
        task.setCreatedAt( resultSet.getTimestamp("created_at") );
        return task;
    }
    
    @Override
    public List readAll() {
        ArrayList<Task> task_list = new ArrayList<Task>();
        String sql_query = "select * from tasks";
        
        try {
            executeQuery(sql_query);
            while( resultSet.next() ) {
                Task task = new Task();
                task = fillTaskValues(resultSet, task);
                task_list.add(task);
            }
        } catch( SQLException sqlex) {
            sqlex.printStackTrace();
        }
        
        return task_list;
    }

    @Override
    public Task readTask(int id) {
        String sql_query = "select * from tasks where id=" + id;
        Task task = new Task();
        
        try {
            executeQuery(sql_query);
            while( resultSet.next() ) {    
                task = fillTaskValues(resultSet, task);
            }
        } catch( SQLException sqlex) {
            sqlex.printStackTrace();
        }
        
        return task;
    }

    @Override
    public void createTask(Task task) {
        String sql_query = "insert into tasks( title, description ) values ( '" + 
                task.getTitle() + "', '" + task.getDescription() + "' )";
        executeUpdate(sql_query);
    }

    @Override
    public void updateTask(Task task) {
        String set_title = "title='" + task.getTitle() + "'";
        String set_description = "description='" + task.getDescription() + "'";
        String set_createdAt = "created_at=NOW()";
        String sql_query = "update tasks set " + set_title + ", " +
                set_description + ", " + set_createdAt + " where id=" +
                task.getId();
        executeUpdate(sql_query);
    }

    @Override
    public void deleteTask(int id) {
        String sql_query = "delete from tasks where id=" + id;
        executeUpdate(sql_query);
    }
}
