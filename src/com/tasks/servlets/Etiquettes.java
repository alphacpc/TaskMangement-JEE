package com.tasks.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.forms.LabelForm;
import com.models.bdd.LabelModel;
import com.models.beans.LabelBean;


@WebServlet("/etiquettes")
public class Etiquettes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Etiquettes() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String inputText = "Ajouter une étiquette";
		LabelModel labels = new LabelModel();
		
		List<LabelBean> result = labels.getLabels();
		
		request.setAttribute("labels", result);
		request.setAttribute("input", inputText);
		request.getRequestDispatcher("/WEB-INF/etiquettes.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LabelForm label = new LabelForm();
		label.addLabel(request);
		
		doGet(request, response);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String inputText = "Ajouter une étiquette";
		LabelModel labels = new LabelModel();
		
		List<LabelBean> result = labels.getLabels();
		
		request.setAttribute("labels", result);
		request.setAttribute("input", inputText);
		request.getRequestDispatcher("/WEB-INF/etiquettes.jsp").forward(request, response);
	}

}
