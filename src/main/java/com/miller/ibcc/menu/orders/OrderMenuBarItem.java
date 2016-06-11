package com.miller.ibcc.menu.orders;

import org.apache.log4j.Logger;

import com.miller.ibcc.menu.MenuBarItem;

public enum OrderMenuBarItem implements MenuBarItem {
	
	INSTANCE;

	private Logger logger = Logger.getLogger(OrderMenuBarItem.class);
	
	@Override
	public String getName() {
		return "Orders";
	}

	@Override
	public MenuBarItem[] getSubMenus() {
		return new MenuBarItem[]{ PlaceOrderMenuBarItem.INSTANCE };
	}

	@Override
	public void onAction() {
		logger.info("User clicked order option");
		
	}

}
