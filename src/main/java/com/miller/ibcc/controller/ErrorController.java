package com.miller.ibcc.controller;

import com.miller.ibcc.domain.Error;
import com.miller.ibcc.gui.error.ErrorForm;
import com.miller.ibcc.gui.error.SwingErrorForm;

public enum ErrorController {
	
	INSTANCE;
	
	private ErrorController() {
	
	}
	
	public void displayError(Error error) {
		ErrorForm errorForm = SwingErrorForm.INSTANCE;
		errorForm.displayError(error);
	}

}
