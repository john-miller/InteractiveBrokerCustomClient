package com.miller.ibcc.controller;

import org.apache.log4j.Logger;

import com.miller.ibcc.gui.ApplicationFrame;
import com.miller.ibcc.gui.FXApplicationFrame;
import com.miller.ibcc.gui.order.FXOrderForm;
import com.miller.ibcc.gui.order.OrderForm;
import com.miller.ibcc.menu.MenuBarItem;
import com.miller.ibcc.menu.file.FileMenuBarItem;
import com.miller.ibcc.menu.options.AbstractOptionsMenu;
import com.miller.ibcc.menu.options.DashboardMenuBarItem;
import com.miller.ibcc.menu.options.ReportMenuBarItem;

public enum OrderController {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(OrderController.class);
	
	private MenuBarItem optionsMenu = new AbstractOptionsMenu() {
		@Override
		public MenuBarItem[] getSubMenus() {
			return new MenuBarItem[]{DashboardMenuBarItem.INSTANCE};
		}
	};
	
	private OrderController() {
		logger.info("Creating order controller");
	}
	
	public void display() {
		
		logger.info("Displaying order form");
		
		OrderForm orderForm = FXOrderForm.INSTANCE;
		orderForm.display();
		
		ApplicationFrame applicationFrame = FXApplicationFrame.INSTANCE;
		applicationFrame.setThirdPartyMenuBarItems(FileMenuBarItem.INSTANCE, optionsMenu, ReportMenuBarItem.INSTANCE);
		
	}

}
