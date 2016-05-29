package com.miller.ibcc.gui;

/**
 * The frame of the application
 *
 * Created on May 27, 2016 3:12:50 PM
 * @author Jonathan Miller
 */
public interface ApplicationFrame {
	
	public void display();
	
	public void setThirdPartyMenuBarItems(MenuBarItem... menuBarItems);
	
	public Object getContainer();
	
	public interface MenuBarItem {
		public String getName();
		public void onAction();
	}

}
