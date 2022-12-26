package com.tasks.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.bdd.TaskModel;
import com.models.beans.TaskBean;


@WebServlet("/taches/utilisateurs")
public class TasksUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TasksUsers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		TaskModel tasks = new TaskModel();
		List<TaskBean> result = tasks.getUserTasks(userid);
		
		request.setAttribute("tasks", result);
		
		request.getRequestDispatcher("/WEB-INF/tasks-user.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
