package com.miller.ibcc.controller;

import com.miller.ibcc.domain.Error;
import com.miller.ibcc.gui.ApplicationFrame;
import com.miller.ibcc.gui.FXApplicationFrame;
import com.miller.ibcc.gui.error.ErrorForm;
import com.miller.ibcc.gui.error.FXErrorForm;
import com.miller.ibcc.menu.MenuBarItem;
import com.miller.ibcc.menu.options.AbstractOptionsMenu;
import com.miller.ibcc.menu.options.DashboardMenuBarItem;
import com.miller.ibcc.menu.options.ReportMenuBarItem;

public enum ErrorController {
	
	INSTANCE;
	
	private ErrorController() {
	
	}
	
	public void displayError(Error error) {
		ErrorForm errorForm = FXErrorForm.INSTANCE;
		errorForm.displayError(error);
		
		ApplicationFrame applicationFrame = FXApplicationFrame.INSTANCE;
		applicationFrame.setThirdPartyMenuBarItems(ReportMenuBarItem.INSTANCE, new AbstractOptionsMenu() {
			@Override
			public MenuBarItem[] getSubMenus() {
				return new MenuBarItem[]{ DashboardMenuBarItem.INSTANCE };
			}
		});
	}

}
