package com.miller.ibcc.menu.options;

import org.apache.log4j.Logger;

import com.miller.ibcc.menu.MenuBarItem;

public enum LogoutMenuBarItem implements MenuBarItem {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(LogoutMenuBarItem.class);

	@Override
	public String getName() {
		return "Logout";
	}

	@Override
	public void onAction() {
		logger.info("User logged out");
	}

	@Override
	public MenuBarItem[] getSubMenus() {
		return new MenuBarItem[]{};
	}

}
