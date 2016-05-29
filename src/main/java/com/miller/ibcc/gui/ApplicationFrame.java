package com.miller.ibcc.gui;

import java.util.Collection;

/**
 * The frame of the application
 *
 * Created on May 27, 2016 3:12:50 PM
 * @author Jonathan Miller
 */
public interface ApplicationFrame {
	
	public void display();
	
	public void setThirdPartyMenuBarItems(Collection<MenuBarItem> menuBarItems);
	
	public Object getContainer();
	
	public interface MenuBarItem {
		public String getName();
		public void onAction();
	}

}
