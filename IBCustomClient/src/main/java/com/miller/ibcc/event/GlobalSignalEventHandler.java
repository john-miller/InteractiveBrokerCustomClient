package com.miller.ibcc.event;

import org.apache.log4j.Logger;

import com.ib.client.EReaderSignal;

public enum GlobalSignalEventHandler implements EReaderSignal {
	
	INSTANCE;

	public static EReaderSignal getInstance() {
		return INSTANCE;
	}
	
	private final Logger logger = Logger.getLogger(GlobalSignalEventHandler.class);
	
	@Override
	public void issueSignal() {
		logger.info("Signal Issued");
	}

	@Override
	public void waitForSignal() {
		logger.info("Waiting for signal");
	}

}
