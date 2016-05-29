package com.miller.ibcc.controller;

import com.miller.ibcc.gui.ApplicationFrame;
import com.miller.ibcc.gui.SwingApplicationFrame;
import com.miller.ibcc.gui.dashboard.DashboardForm;
import com.miller.ibcc.gui.dashboard.SwingDashboardForm;
import com.miller.ibcc.gui.options.PlaceOrderMenuBarItem;

public enum DashboardController {
	
	INSTANCE;
	
	public void show() {
		
		DashboardForm dashboardForm = SwingDashboardForm.INSTANCE;
		dashboardForm.display();

		ApplicationFrame applicationFrame = SwingApplicationFrame.INSTANCE;
		applicationFrame.setThirdPartyMenuBarItems(PlaceOrderMenuBarItem.INSTANCE);
		
	}

}
