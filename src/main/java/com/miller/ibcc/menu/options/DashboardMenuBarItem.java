package com.miller.ibcc.menu.options;

import org.apache.log4j.Logger;

import com.miller.ibcc.controller.DashboardController;
import com.miller.ibcc.menu.MenuBarItem;

/**
 * Will attempt to show the dashboard
 *
 * Created On May 29, 2016
 * @author Jonathan Miller
 */
public enum DashboardMenuBarItem implements MenuBarItem {
	 
	INSTANCE;
	
	private Logger logger = Logger.getLogger(DashboardMenuBarItem.class);

	@Override
	public String getName() {
		return "Go To Dashboard";
	}

	@Override
	public void onAction() {
		logger.info("User selected dashboard");
		DashboardController.INSTANCE.show();
	}

	@Override
	public MenuBarItem[] getSubMenus() {
		return new MenuBarItem[]{};
	}
	
	
	

}
