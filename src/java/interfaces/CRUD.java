package interfaces;

import java.util.List;
import model.Task;

public interface CRUD {
    public List readAll();
    public Task readTask( int id );
    public void createTask( Task task );
    public void updateTask( Task task );
    public void deleteTask( int id );
}
