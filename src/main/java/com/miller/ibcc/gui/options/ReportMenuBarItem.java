package com.miller.ibcc.gui.options;

import org.apache.log4j.Logger;

import com.miller.ibcc.gui.ApplicationFrame.MenuBarItem;

/**
 * Reports a problem
 *
 * Created On May 29, 2016
 * @author Jonathan Miller
 */
public enum ReportMenuBarItem implements MenuBarItem {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(ReportMenuBarItem.class);
	
	@Override
	public String getName() {
		return "Report Problem";
	}

	@Override
	public void onAction() {
		//TODO figure out what to do here
		logger.info("User reported problem");
	}

}
