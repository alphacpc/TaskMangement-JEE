package com.tasks.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.bdd.TaskModel;
import com.models.bdd.UsersModel;
import com.models.beans.TaskBean;
import com.models.beans.User;


@WebServlet("/tache")
public class Task extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Task() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String taskid = request.getParameter("taskid");
		TaskModel taskModel = new TaskModel();
		TaskBean task = taskModel.getTaskById(taskid);
		
		request.setAttribute("task", task);
		request.getRequestDispatcher("/WEB-INF/Details/tache.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
