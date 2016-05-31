package com.miller.ibcc.menu;

public interface MenuBarItem {
	
	public String getName();
	
	public MenuBarItem[] getSubMenus();
	
	public void onAction();
	
}