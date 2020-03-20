package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Task;
import model.TaskDAO;

@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
    private String list_path = "views/list.jsp";
    private String edith_path = "views/edit-task.jsp";
    private TaskDAO task_dao = new TaskDAO();
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String route = "";
        String action = request.getParameter("action");
        
        if( action.equals("list") )
            route = list_path;
        
        else if( action.equals("Save Task") ) {
            String task_title = request.getParameter("task-title");
            String task_description = request.getParameter("task-description");
            Task task = new Task();
            task.setTitle(task_title);
            task.setDescription(task_description);
            task_dao.createTask(task);
            request.setAttribute("alert", "insert");
            route = list_path;
        }
        
        else if( action.equals("edit") ) {
            request.setAttribute("task_id", request.getParameter("id"));
            route = edith_path;
        }
        
        else if( action.equals("Update Task") ) {
            int id = Integer.parseInt( request.getParameter("id") );
            String task_title = request.getParameter("task-title");
            String task_description = request.getParameter("task-description");
            Task task = new Task();
            task.setId(id);
            task.setTitle(task_title);
            task.setDescription(task_description);
            task_dao.updateTask(task);
            request.setAttribute("alert", "update");
            route = list_path;
        }
        
        else if( action.equals("Cancel Update") )
            route = list_path;
        
        else if( action.equals("delete") ) {
            int id = Integer.parseInt( request.getParameter("id") );
            task_dao.deleteTask(id);
            request.setAttribute("alert", "delete");
            route = list_path;
        }
        
        RequestDispatcher view = request.getRequestDispatcher(route);
        view.forward(request, response);  
    }
}
