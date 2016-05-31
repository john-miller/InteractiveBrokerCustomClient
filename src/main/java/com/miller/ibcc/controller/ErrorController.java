package com.miller.ibcc.controller;

import com.miller.ibcc.domain.Error;
import com.miller.ibcc.gui.ApplicationFrame;
import com.miller.ibcc.gui.SwingApplicationFrame;
import com.miller.ibcc.gui.error.ErrorForm;
import com.miller.ibcc.gui.error.SwingErrorForm;
import com.miller.ibcc.menu.options.DashboardMenuBarItem;
import com.miller.ibcc.menu.options.ReportMenuBarItem;

public enum ErrorController {
	
	INSTANCE;
	
	private ErrorController() {
	
	}
	
	public void displayError(Error error) {
		ErrorForm errorForm = SwingErrorForm.INSTANCE;
		errorForm.displayError(error);
		
		ApplicationFrame applicationFrame = SwingApplicationFrame.INSTANCE;
		applicationFrame.setThirdPartyMenuBarItems(ReportMenuBarItem.INSTANCE, DashboardMenuBarItem.INSTANCE);
	}

}
