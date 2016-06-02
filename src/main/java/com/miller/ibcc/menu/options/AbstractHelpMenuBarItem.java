package com.miller.ibcc.menu.options;

import org.apache.log4j.Logger;

import com.miller.ibcc.menu.MenuBarItem;

/**
 * Contains general help options an custom help options
 *
 * Created On May 29, 2016
 * @author Jonathan Miller
 */
public abstract class AbstractHelpMenuBarItem implements MenuBarItem {
	 
	private Logger logger = Logger.getLogger(AbstractHelpMenuBarItem.class);
	
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
		MenuBarItem[] optionsMenu = new MenuBarItem[]{};
		MenuBarItem[] optionalMenus = getOptionalHelpMenus();
		int aLen = optionsMenu.length;
		int bLen = optionalMenus.length;
		MenuBarItem[] allMenuItems = new MenuBarItem[aLen+bLen];
		System.arraycopy(optionsMenu, 0, allMenuItems, 0, aLen);
		System.arraycopy(optionalMenus, 0, allMenuItems, aLen, bLen);
		return allMenuItems;
	}
	
	public abstract MenuBarItem[] getOptionalHelpMenus();

}
