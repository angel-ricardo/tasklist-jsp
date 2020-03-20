<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Task"%>
<%@page import="model.TaskDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="views/css/style.css" type="text/css" rel="stylesheet"/>
        <title>CRUD Tasklist with JSP</title>
    </head>
    <body>
        <%-- Tasklist --%>
        <div class="tasklist">
            <table>
                <% 
                    String alert = (String) request.getAttribute("alert");
                    if( alert == null ) alert = "none";
                    if( alert.equals("insert")) {
                %>
                <p class="alert green-alert">task saved succesfully!</p>
                <%
                    } else if( alert.equals("update") ) {
                %>
                <p class="alert blue-alert">task edited succesfully!</p>
                <%
                    } else if( alert.equals("delete") ) {
                %>
                <p class="alert red-alert">task deleted succesfully!</p>
                <%
                    }
                    request.setAttribute("alert", "none");
                %>
                <caption>My List</caption>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Created At</th>
                    </tr>
                </thead>
                
                <tbody>
                    <%
                        TaskDAO task_dao = new TaskDAO();
                        List<Task> task_list = task_dao.readAll();
                        Iterator<Task> iterator = task_list.iterator();
                        Task task;
                    
                        while( iterator.hasNext() ) {
                            task = iterator.next();
                    %>
                    <tr>
                        <td><%= task.getId() %></td>
                        <td><%= task.getTitle() %></td>
                        <td><%= task.getDescription() %></td>
                        <td><%= task.getCreatedAt() %></td>
                        <td>
                            <a class="btn btn-blue" href="controller?action=edit&id=<%= task.getId() %>">Edit</a>
                            <a class="btn btn-red" href="controller?action=delete&id=<%= task.getId() %>">Remove</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        
        <%-- Create task --%>
        <div class="add-task">
            <form action="controller">
                <input class="bold" type="text" name="task-title" placeholder="Task Title" required />
                <textarea  rows="10" name="task-description" placeholder="add here your task description..." required></textarea>
                <input class="btn btn-green" type="submit" name="action" value="Save Task" />
            </form>
        </div>
    </body>
</html>
