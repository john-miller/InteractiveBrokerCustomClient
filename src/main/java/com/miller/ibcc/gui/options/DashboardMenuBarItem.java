package com.miller.ibcc.gui.options;

import com.miller.ibcc.controller.DashboardController;
import com.miller.ibcc.gui.ApplicationFrame.MenuBarItem;

/**
 * Will attempt to show the dashboard
 *
 * Created On May 29, 2016
 * @author Jonathan Miller
 */
public enum DashboardMenuBarItem implements MenuBarItem {
	 
	INSTANCE;

	@Override
	public String getName() {
		return "Go To Dashboard";
	}

	@Override
	public void onAction() {
		DashboardController.INSTANCE.show();
	}
	
	
	

}
