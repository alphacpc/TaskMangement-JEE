package com.tasks.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.forms.TaskForm;
import com.models.bdd.LabelModel;
import com.models.bdd.TaskModel;
import com.models.bdd.UsersModel;
import com.models.beans.LabelBean;
import com.models.beans.TaskBean;
import com.models.beans.User;


@WebServlet( urlPatterns = { "/taches" })
public class Tasks extends HttpServlet {
	
	 private static final long serialVersionUID = 1L;

    public Tasks() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if(session.getAttribute("profil") != null) {
			String inputText = "Ajouter une taches";
			
			TaskModel task = new TaskModel();
			UsersModel userModel = new UsersModel();
			LabelModel labelModel = new LabelModel();
			
			List<TaskBean> result =  task.getTasks();
			
			for(TaskBean t : result) {
				User user = userModel.getUserTask(t.getUserid());
				LabelBean label = labelModel.getLabelTask(t.getLabelid());
				
				t.setFname(user.getFname());
				t.setLname(user.getLname());
				
				t.setLabel(label.getTitle());
				t.setCode(label.getCode());
			}
			
			List<User> users = userModel.getUsersMin();
			List<LabelBean> labels = labelModel.getLabelsMin();
			
			request.setAttribute("profil", session.getAttribute("profil"));
			request.setAttribute("users", users);
			request.setAttribute("labels", labels);
			request.setAttribute("tasks", result);
			request.setAttribute("input", inputText);
			request.getRequestDispatcher("/WEB-INF/tasks.jsp").forward(request, response);
		}
		
		else {
			response.sendRedirect("/TasksManagement/connexion");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TaskForm task = new TaskForm();
		task.addTask(request);
		
		doGet(request, response);
	}

}
