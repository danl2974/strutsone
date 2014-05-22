package com.dl2974.struts;

import org.apache.struts.action.ActionForm;

public class MainForm extends ActionForm {
	
	String message;
	 
	public String getMessage() {
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}

}
