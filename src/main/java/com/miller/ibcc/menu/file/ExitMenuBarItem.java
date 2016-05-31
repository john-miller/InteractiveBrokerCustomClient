package com.miller.ibcc.menu.file;

import org.apache.log4j.Logger;

import com.miller.ibcc.controller.ApplicationController;
import com.miller.ibcc.menu.MenuBarItem;

/**
 * Will attempt to show the dashboard
 *
 * Created On May 29, 2016
 * @author Jonathan Miller
 */
public enum ExitMenuBarItem implements MenuBarItem {
	 
	INSTANCE;
	
	private Logger logger = Logger.getLogger(ExitMenuBarItem.class);

	@Override
	public String getName() {
		return "Exit";
	}

	@Override
	public void onAction() {
		logger.info("User exited program");
		ApplicationController.INSTANCE.shutdown();
	}

	@Override
	public MenuBarItem[] getSubMenus() {
		return new MenuBarItem[]{};
	}
	
	
	

}
