package com.miller.ibcc.controller;


import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

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
import com.miller.ibcc.service.TWSConnectionClientService;

public enum DashboardController {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(DashboardController.class);
	private Timer updateTimer;
	
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
	
	private DashboardController() {
		logger.info("Creating dashboard controller");
	}
	
	public synchronized void startUpdates() {
		
		if(updateTimer != null) 
			updateTimer.cancel();
		
		updateTimer = new Timer();
		updateTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				TWSConnectionClientService.INSTANCE.updatePortfolio();
			}
		}, 0, 1000);
	}
	
	public synchronized void stopUpdates() {
		if(updateTimer != null) {
			updateTimer.cancel();
		}
	}
	
	public void show() {
		logger.info("Showing dashboard controller");
		
		DashboardForm dashboardForm = FXDashboardForm.INSTANCE;
		dashboardForm.display();

		ApplicationFrame applicationFrame = FXApplicationFrame.INSTANCE;
		applicationFrame.setThirdPartyMenuBarItems(FileMenuBarItem.INSTANCE, OrderMenuBarItem.INSTANCE, optionsMenu, helpMenu);
		
		startUpdates();
	}

}
