package com.tasks.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.forms.TaskForm;


@WebServlet( urlPatterns = { "/taches" })
public class Tasks extends HttpServlet {
	
	 private static final long serialVersionUID = 1L;

    public Tasks() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputText = "Ajouter une taches";
		request.setAttribute("input", inputText);
		request.getRequestDispatcher("/WEB-INF/tasks.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaskForm task = new TaskForm();
		String result = task.addTask(request);
		System.out.println(result);
		doGet(request, response);
	}

}
