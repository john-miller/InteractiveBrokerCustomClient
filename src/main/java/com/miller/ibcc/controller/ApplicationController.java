package com.miller.ibcc.controller;

import org.apache.log4j.Logger;

import com.miller.ibcc.gui.ApplicationFrame;
import com.miller.ibcc.gui.SwingApplicationFrame;

public enum ApplicationController {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(ApplicationController.class);
	
	private ApplicationController() {
		
	}
	
	public void shutdown() {
		logger.info("Shutting down application");
		System.exit(0);
	}
	
	public void start() {
		logger.info("Displaying application frame");
		ApplicationFrame applicationFrame = SwingApplicationFrame.INSTANCE;
		applicationFrame.display();
		
		/* Authenticate the client */
		AuthenticationController.INSTANCE.authenticateToDashboard();
	}

}
