package com.miller.ibcc.menu.options;

import org.apache.log4j.Logger;

import com.miller.ibcc.menu.MenuBarItem;

public enum PlaceOrderMenuBarItem implements MenuBarItem {

	INSTANCE;
	
	private Logger logger = Logger.getLogger(PlaceOrderMenuBarItem.class);
	
	@Override
	public String getName() {
		return "Place an order";
	}

	@Override
	public void onAction() {
		logger.info("User placing order");
		
	}

	@Override
	public MenuBarItem[] getSubMenus() {
		return new MenuBarItem[]{};
	}

}
