package com.miller.ibcc.menu.file;

import org.apache.log4j.Logger;

import com.miller.ibcc.controller.DashboardController;
import com.miller.ibcc.menu.MenuBarItem;
import com.miller.ibcc.menu.options.HelpMenuBarItem;

/**
 * Will attempt to show the dashboard
 *
 * Created On May 29, 2016
 * @author Jonathan Miller
 */
public enum FileMenuBarItem implements MenuBarItem {
	 
	INSTANCE;
	
	private Logger logger = Logger.getLogger(FileMenuBarItem.class);

	@Override
	public String getName() {
		return "File";
	}

	@Override
	public void onAction() {
		logger.info("User selected dashboard");
		DashboardController.INSTANCE.show();
	}

	@Override
	public MenuBarItem[] getSubMenus() {
		return new MenuBarItem[]{HelpMenuBarItem.INSTANCE, ExitMenuBarItem.INSTANCE};
	}
	
	
	

}
