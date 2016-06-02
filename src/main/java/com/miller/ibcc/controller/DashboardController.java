package com.miller.ibcc.controller;

import com.miller.ibcc.gui.ApplicationFrame;
import com.miller.ibcc.gui.FXApplicationFrame;
import com.miller.ibcc.gui.dashboard.DashboardForm;
import com.miller.ibcc.gui.dashboard.FXDashboardForm;
import com.miller.ibcc.menu.MenuBarItem;
import com.miller.ibcc.menu.file.FileMenuBarItem;
import com.miller.ibcc.menu.help.DashboardHelpMenuBarItem;
import com.miller.ibcc.menu.options.AbstractHelpMenuBarItem;
import com.miller.ibcc.menu.options.AbstractOptionsMenu;
import com.miller.ibcc.menu.options.LogoutMenuBarItem;
import com.miller.ibcc.menu.options.ReportMenuBarItem;
import com.miller.ibcc.menu.orders.OrderMenuBarItem;

public enum DashboardController {
	
	INSTANCE;
	
	private MenuBarItem optionsMenu = new AbstractOptionsMenu() {
		@Override
		public MenuBarItem[] getSubMenus() {
			return new MenuBarItem[]{ReportMenuBarItem.INSTANCE, LogoutMenuBarItem.INSTANCE};
		}
	};
	
	private MenuBarItem helpMenu = new AbstractHelpMenuBarItem() {
		@Override
		public MenuBarItem[] getOptionalHelpMenus() {
			return new MenuBarItem[]{ DashboardHelpMenuBarItem.INSTANCE };
		}
	};
	
	public void show() {
		
		DashboardForm dashboardForm = FXDashboardForm.INSTANCE;
		dashboardForm.display();

		ApplicationFrame applicationFrame = FXApplicationFrame.INSTANCE;
		applicationFrame.setThirdPartyMenuBarItems(FileMenuBarItem.INSTANCE, OrderMenuBarItem.INSTANCE, optionsMenu, helpMenu);
		
	}

}
