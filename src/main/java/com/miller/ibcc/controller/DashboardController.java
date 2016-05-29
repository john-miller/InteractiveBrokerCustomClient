package com.miller.ibcc.controller;

import com.miller.ibcc.gui.dashboard.DashboardForm;
import com.miller.ibcc.gui.dashboard.SwingDashboardForm;

public enum DashboardController {
	
	INSTANCE;
	
	public void show() {
		
		DashboardForm dashboardForm = SwingDashboardForm.INSTANCE;
		dashboardForm.display();
		
	}

}
