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


@WebServlet("/etiquette")
public class Etiquette extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Etiquette() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String labelid = request.getParameter("id");
		LabelModel labelModel = new LabelModel();
		LabelBean label = labelModel.getLabelById(labelid);

		request.setAttribute("label", label);
		request.getRequestDispatcher("/WEB-INF/Details/label.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String labelid = request.getParameter("id");
		LabelModel labelModel = new LabelModel();
		LabelBean labelBean = new LabelBean();
		
		labelBean.setTitle(request.getParameter("title"));
		labelBean.setCode(request.getParameter("code"));
		
		labelModel.updateLabel(labelBean, labelid);
		
		response.sendRedirect("/TasksManagement/etiquettes");
	}

}
