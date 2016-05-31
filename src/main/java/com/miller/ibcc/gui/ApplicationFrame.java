package com.miller.ibcc.gui;

import com.miller.ibcc.menu.MenuBarItem;

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
	
}
