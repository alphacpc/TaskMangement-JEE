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


@WebServlet("/")
public class Etiquettes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Etiquettes() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		
		switch (action) {
			case "/etiquettes/delete":
				doDelete(request, response);
				break;
				
			case "/etiquettes":
				listLabel(request, response);
				break;
				
			default:
				listLabel(request, response);
				break;
		}

	}
	
	protected void listLabel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputText = "Ajouter une étiquette";
		LabelModel labels = new LabelModel();
		
		List<LabelBean> result = labels.getLabels();
		
		System.out.println("Dans Gets");
		
		request.setAttribute("labels", result);
		request.setAttribute("input", inputText);
		request.getRequestDispatcher("/WEB-INF/etiquettes.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LabelForm label = new LabelForm();
		String result = label.addLabel(request);
		System.out.println(result);
		System.out.println("Dans Post");
		
		doGet(request, response);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("dans delete ******");
		//listLabel(request, response);
		String inputText = "Ajouter une étiquette";
		LabelModel labels = new LabelModel();
		
		List<LabelBean> result = labels.getLabels();
		
		System.out.println("Dans Gets");
		
		request.setAttribute("labels", result);
		request.setAttribute("input", inputText);
		request.getRequestDispatcher("/WEB-INF/etiquettes.jsp").forward(request, response);
	}

}
