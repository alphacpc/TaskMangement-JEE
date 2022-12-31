package com.tasks.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.models.bdd.LabelModel;
import com.models.bdd.TaskModel;
import com.models.bdd.UsersModel;
import com.models.beans.LabelBean;
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
		UsersModel userModel = new UsersModel();
		LabelModel labelModel = new LabelModel();
		TaskBean task = taskModel.getTaskById(taskid);
		
		List<User> users = userModel.getUsersMin();
		List<LabelBean> labels = labelModel.getLabelsMin();
		
		request.setAttribute("users", users);
		request.setAttribute("labels", labels);
		request.setAttribute("task", task);
		request.getRequestDispatcher("/WEB-INF/Details/tache.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TaskBean task = new TaskBean();
		TaskModel taskModel = new TaskModel();
		String taskid = request.getParameter("taskid");
		
		task.setTitle(request.getParameter("title"));
		task.setDesc(request.getParameter("desc"));
		task.setLabelid(request.getParameter("labelid"));
		task.setUserid(request.getParameter("userid"));
		
		taskModel.updateTask(task, taskid);
		
		doGet(request, response);
	}

}
