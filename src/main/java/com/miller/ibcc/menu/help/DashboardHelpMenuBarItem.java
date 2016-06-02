package com.miller.ibcc.menu.help;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;

import com.miller.ibcc.menu.MenuBarItem;

/**
 * Will launch browser to web tutorial on how
 * to use the dashboard
 *
 * Created On May 29, 2016
 * @author Jonathan Miller
 */
public enum DashboardHelpMenuBarItem implements MenuBarItem {
	 
	INSTANCE;
	
	private Logger logger = Logger.getLogger(DashboardHelpMenuBarItem.class);

	@Override
	public String getName() {
		return "Dashboard Tutorial";
	}

	@Override
	public void onAction() {
		try {
			logger.info("User selected tutorial");
			if(Desktop.isDesktopSupported()) {
			  Desktop.getDesktop().browse(new URI("http://www.example.com"));
			}
		} catch(IOException e) {
			logger.error("Could not launch", e);
		} catch (URISyntaxException e) {
			logger.error("", e);
		}
	}

	@Override
	public MenuBarItem[] getSubMenus() {
		return new MenuBarItem[]{};
	}
	
	
	

}
