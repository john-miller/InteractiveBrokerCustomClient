package com.miller.ibcc.service;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.ib.client.Contract;
import com.ib.controller.ApiController;
import com.ib.controller.ApiController.IAccountHandler;
import com.ib.controller.ApiController.IConnectionHandler;
import com.ib.controller.ApiController.IPositionHandler;
import com.ib.controller.Position;
import com.miller.ibcc.controller.ApplicationSettingsController.Setting;
import com.miller.ibcc.event.ConnectionHandler;
import com.miller.ibcc.event.DataLogger;
import com.miller.ibcc.exception.AuthorizationException;

public enum TWSConnectionClientService implements ConnectionClientService, IConnectionHandler, IAccountHandler, IPositionHandler {

	INSTANCE;
	
	private ApiController apiController; 
	private Logger logger = Logger.getLogger(TWSConnectionClientService.class);
	
	private TWSConnectionClientService() {
		apiController = new ApiController(ConnectionHandler.INSTANCE, DataLogger.IN, DataLogger.OUT);
	}
	
	public void connect(Properties connectionProps, ConnectionListener listener) {
		logger.info(connectionProps);
		apiController.connect(
				connectionProps.getProperty(Setting.HOST.toString()), 
				(int) connectionProps.get(Setting.PORT), 
				(int) connectionProps.get(Setting.CLIENT_ID), 
				"");

		if(apiController.client().isConnected()) 
			listener.success();
		else 
			listener.failure(new AuthorizationException("Could not connect to TWS session"));
			
	}
	
	public void updatePortfolio() {
		logger.info("Requesting update");
		apiController.reqPositions(this);
		apiController.reqAccountUpdates(false, "U1710472", this);
	}
	
	public interface ConnectionListener {
		public void success();
		public void failure(Throwable t);
	}

	@Override
	public void connected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accountList(ArrayList<String> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(Exception e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void message(int id, int errorCode, String errorMsg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accountValue(String account, String key, String value, String currency) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accountTime(String timeStamp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accountDownloadEnd(String account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePortfolio(Position position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void position(String account, Contract contract, int position, double avgCost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void positionEnd() {
		// TODO Auto-generated method stub
		
	}
	
	
}
