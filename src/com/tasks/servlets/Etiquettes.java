package com.tasks.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.forms.LabelForm;


@WebServlet("/etiquettes")
public class Etiquettes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Etiquettes() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputText = "Ajouter une étiquette";
		request.setAttribute("input", inputText);
		request.getRequestDispatcher("/WEB-INF/etiquettes.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LabelForm label = new LabelForm();
		String result = label.addLabel(request);
		System.out.println(result);
		doGet(request, response);
	}

}
