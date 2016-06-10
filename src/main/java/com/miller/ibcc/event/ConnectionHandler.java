package com.miller.ibcc.event;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ib.controller.ApiController.IConnectionHandler;

public enum ConnectionHandler implements IConnectionHandler {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(ConnectionHandler.class);

	@Override
	public void connected() {
		logger.info("Connected");
	}

	@Override
	public void disconnected() {
		logger.info("Disconnected");
	}

	@Override
	public void accountList(ArrayList<String> list) {
		logger.info(list);
	}

	@Override
	public void error(Exception e) {
		
	}

	@Override
	public void message(int id, int errorCode, String errorMsg) {
	
	}

	@Override
	public void show(String string) {
		logger.info(string);
	}

}
