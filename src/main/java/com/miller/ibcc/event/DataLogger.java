package com.miller.ibcc.event;

import org.apache.log4j.Logger;

import com.ib.controller.ApiConnection.ILogger;

/**
 * Loggers for data in and out of the 
 * TWS api
 *
 * Created on Jun 10, 2016 4:38:25 PM
 * @author Jonathan Miller
 */
public enum DataLogger implements ILogger {
	
	IN("Received"), 
	OUT("Sent");
	
	private String prefix;
	private Logger logger = Logger.getLogger(DataLogger.class);
	
	private DataLogger(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public void log(String valueOf) {
		logger.trace(prefix + ": " + valueOf);
	}

}
