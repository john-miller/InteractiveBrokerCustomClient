package com.miller.ibcc.controller;

import com.miller.ibcc.gui.ApplicationFrame;
import com.miller.ibcc.gui.FXApplicationFrame;
import com.miller.ibcc.gui.dashboard.DashboardForm;
import com.miller.ibcc.gui.dashboard.FXDashboardForm;
import com.miller.ibcc.menu.options.PlaceOrderMenuBarItem;

public enum DashboardController {
	
	INSTANCE;
	
	public void show() {
		
		DashboardForm dashboardForm = FXDashboardForm.INSTANCE;
		dashboardForm.display();

		ApplicationFrame applicationFrame = FXApplicationFrame.INSTANCE;
		applicationFrame.setThirdPartyMenuBarItems(PlaceOrderMenuBarItem.INSTANCE);
		
	}

}
