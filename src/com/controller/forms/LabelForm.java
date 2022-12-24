package com.controller.forms;

import javax.servlet.http.HttpServletRequest;

import com.models.bdd.LabelModel;
import com.models.beans.LabelBean;

public class LabelForm {
	public String addLabel(HttpServletRequest request){	
		
		LabelBean labelBean = new LabelBean();
		LabelModel labelModel = new LabelModel();
		
		labelBean.setTitle(request.getParameter("title"));
		labelBean.setCode(request.getParameter("code"));
		
		labelModel.addLabelModel(labelBean);
		
		return "Label created with success !";
	}
}
