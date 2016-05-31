package com.miller.ibcc.menu.options;

import org.apache.log4j.Logger;

import com.miller.ibcc.menu.MenuBarItem;

/**
 * Customizable Options Menu
 *
 * Created On May 31, 2016
 * @author Jonathan Miller
 */
public abstract class AbstractOptionsMenu implements MenuBarItem {

	private Logger logger = Logger.getLogger(AbstractOptionsMenu.class);
	
	@Override
	public String getName() {
		return "Options";
	}

	@Override
	public void onAction() {
		logger.info("Options Menu Clicked");
	}

}
