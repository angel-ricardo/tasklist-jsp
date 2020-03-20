<%@page import="model.Task"%>
<%@page import="model.TaskDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="views/css/style.css" type="text/css" rel="stylesheet"/>
        <title>CRUD edit a task</title>
    </head>
    <body>
         <%-- Edit task --%>
         <% 
            TaskDAO task_dao = new TaskDAO();
            int id = Integer.parseInt( (String) request.getAttribute("task_id") );
            Task task = task_dao.readTask(id);
         %>
         
        <div class="edit-task">
            <h1>Edit task</h1>
            <form action="controller">
                <input id="id" name="id" type="text" value="<%= task.getId() %>" readonly />
                <input class="bold" type="text" value="<%= task.getTitle() %>"  name="task-title" placeholder="Task Title" required />
                <textarea  rows="10" name="task-description" placeholder="add here your task description..." required><%= task.getDescription() %></textarea>
                <input class="btn btn-green" type="submit" name="action" value="Update Task" />
                <a class="btn btn-red" href="controller?action=Cancel+Update">Cancel</a>
            </form>
        </div>
    </body>
</html>
