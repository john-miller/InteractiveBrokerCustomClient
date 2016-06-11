package com.miller.ibcc.menu.orders;

import org.apache.log4j.Logger;

import com.miller.ibcc.controller.OrderController;
import com.miller.ibcc.menu.MenuBarItem;

public enum PlaceOrderMenuBarItem implements MenuBarItem {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(PlaceOrderMenuBarItem.class);

	@Override
	public String getName() {
		return "New Order";
	}

	@Override
	public MenuBarItem[] getSubMenus() {
		return new MenuBarItem[]{};
	}

	@Override
	public void onAction() {
		logger.info("User placed order");
		OrderController.INSTANCE.display();
	}

}
