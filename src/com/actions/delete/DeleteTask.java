package com.actions.delete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.bdd.LabelModel;
import com.models.bdd.TaskModel;

@WebServlet(urlPatterns = { "/delete/task" })
public class DeleteTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteTask() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doDelete(request, response);
		
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String taskid = request.getParameter("taskid");
		TaskModel task = new TaskModel();
	
		task.deleteTask(taskid);
		
		response.sendRedirect("/TasksManagement/taches");
		
	}

}
