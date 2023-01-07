package com.tasks.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.bdd.TaskModel;
import com.models.beans.TaskBean;


@WebServlet("/taches/utilisateurs")
public class TasksUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TasksUsers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if( session.getAttribute("profil") != null) {
			TaskModel tasks = new TaskModel();
			List<TaskBean> result = tasks.getUserTasks((int) session.getAttribute("userid"));
			
			request.setAttribute("profil", session.getAttribute("profil"));
			request.setAttribute("tasks", result);
			request.getRequestDispatcher("/WEB-INF/tasks-user.jsp").forward(request, response);
			
		}else {
			response.sendRedirect("/TasksManagement/connexion");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
