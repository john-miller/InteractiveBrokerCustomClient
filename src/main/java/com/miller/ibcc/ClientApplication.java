package com.miller.ibcc;

import org.apache.log4j.Logger;

import com.miller.ibcc.controller.AuthenticationController;
import com.miller.ibcc.gui.ApplicationFrame;
import com.miller.ibcc.gui.SwingApplicationFrame;

/**
 * Entry point for the application
 *
 * Created on May 27, 2016 2:55:59 PM
 * @author Jonathan Miller
 */
public class ClientApplication {
	
	private static Logger logger = Logger.getLogger(ClientApplication.class);
	
	public static void main(String[] args) {
		
		logger.info("Displaying application frame");
		ApplicationFrame applicationFrame = SwingApplicationFrame.INSTANCE;
		applicationFrame.display();
		
		/* Authenticate the client */
		AuthenticationController.INSTANCE.authenticateToDashboard();
		
	}

}
