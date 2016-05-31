package com.miller.ibcc.menu.options;

import org.apache.log4j.Logger;

import com.miller.ibcc.menu.MenuBarItem;

/**
 * Will attempt to show the dashboard
 *
 * Created On May 29, 2016
 * @author Jonathan Miller
 */
public enum HelpMenuBarItem implements MenuBarItem {
	 
	INSTANCE;
	
	private Logger logger = Logger.getLogger(HelpMenuBarItem.class);
	
	@Override
	public String getName() {
		return "Help";
	}

	@Override
	public void onAction() {
		logger.info("User selected help");
	}

	@Override
	public MenuBarItem[] getSubMenus() {
		return new MenuBarItem[]{};
	}
	
	
	

}
