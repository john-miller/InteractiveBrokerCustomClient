package com.miller.ibcc.event;

import org.apache.log4j.Logger;

import com.ib.client.CommissionReport;
import com.ib.client.Contract;
import com.ib.client.ContractDetails;
import com.ib.client.DeltaNeutralContract;
import com.ib.client.EWrapper;
import com.ib.client.Execution;
import com.ib.client.Order;
import com.ib.client.OrderState;
import com.miller.ibcc.controller.DashboardController;
import com.miller.ibcc.controller.ErrorController;
import com.miller.ibcc.domain.Error;

/**
 * Singleton instance of global event handler
 *
 * Created on May 27, 2016 3:39:54 PM
 * @author Jonathan Miller
 */
public enum GlobalEventHandler implements EWrapper {
	
	INSTANCE;
	
	private final Logger logger = Logger.getLogger(GlobalEventHandler.class);

	@Override
	public void tickPrice(int tickerId, int field, double price, int canAutoExecute) {
		// TODO Auto-generated method stub
		logger.info("ticker " + tickerId + " field " + field + " price " + price);
		
	}

	@Override
	public void tickSize(int tickerId, int field, int size) {
		logger.info("Tick Size");
	}

	@Override
	public void tickOptionComputation(int tickerId, int field, double impliedVol, double delta, double optPrice,
			double pvDividend, double gamma, double vega, double theta, double undPrice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickGeneric(int tickerId, int tickType, double value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickString(int tickerId, int tickType, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickEFP(int tickerId, int tickType, double basisPoints, String formattedBasisPoints,
			double impliedFuture, int holdDays, String futureLastTradeDate, double dividendImpact,
			double dividendsToLastTradeDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void orderStatus(int orderId, String status, int filled, int remaining, double avgFillPrice, int permId,
			int parentId, double lastFillPrice, int clientId, String whyHeld) {
		logger.info("Order Status");
	}

	@Override
	public void openOrder(int orderId, Contract contract, Order order, OrderState orderState) {
		logger.info("Open order");
	}

	@Override
	public void openOrderEnd() {
		logger.info("Open order has ended");
	}

	@Override
	public void updateAccountValue(String key, String value, String currency, String accountName) {
		logger.info("Account Value");
	}

	@Override
	public void updatePortfolio(Contract contract, int position, double marketPrice, double marketValue,
			double averageCost, double unrealizedPNL, double realizedPNL, String accountName) {
		logger.info("Portfolio Updated");
	}

	@Override
	public void updateAccountTime(String timeStamp) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void accountDownloadEnd(String accountName) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void nextValidId(int orderId) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void contractDetails(int reqId, ContractDetails contractDetails) {
		logger.info("");
	}

	@Override
	public void bondContractDetails(int reqId, ContractDetails contractDetails) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void contractDetailsEnd(int reqId) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void execDetails(int reqId, Contract contract, Execution execution) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void execDetailsEnd(int reqId) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void updateMktDepth(int tickerId, int position, int operation, int side, double price, int size) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void updateMktDepthL2(int tickerId, int position, String marketMaker, int operation, int side, double price,
			int size) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void updateNewsBulletin(int msgId, int msgType, String message, String origExchange) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void managedAccounts(String accountsList) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void receiveFA(int faDataType, String xml) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void historicalData(int reqId, String date, double open, double high, double low, double close, int volume,
			int count, double WAP, boolean hasGaps) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void scannerParameters(String xml) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void scannerData(int reqId, int rank, ContractDetails contractDetails, String distance, String benchmark,
			String projection, String legsStr) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void scannerDataEnd(int reqId) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void realtimeBar(int reqId, long time, double open, double high, double low, double close, long volume,
			double wap, int count) {
		logger.info("");
	}

	@Override
	public void currentTime(long time) {
		logger.info("Current Time: " + time);
	}

	@Override
	public void fundamentalData(int reqId, String data) {
		logger.info("");
	}

	@Override
	public void deltaNeutralValidation(int reqId, DeltaNeutralContract underComp) {
		logger.info("");
	}

	@Override
	public void tickSnapshotEnd(int reqId) {
		logger.info("");
	}

	@Override
	public void marketDataType(int reqId, int marketDataType) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void commissionReport(CommissionReport commissionReport) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void position(String account, Contract contract, int pos, double avgCost) {
		logger.info(account);
	}

	@Override
	public void positionEnd() {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void accountSummary(int reqId, String account, String tag, String value, String currency) {
		logger.info(account);
	}

	@Override
	public void accountSummaryEnd(int reqId) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void verifyMessageAPI(String apiData) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void verifyCompleted(boolean isSuccessful, String errorText) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void verifyAndAuthMessageAPI(String apiData, String xyzChallange) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void verifyAndAuthCompleted(boolean isSuccessful, String errorText) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void displayGroupList(int reqId, String groups) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void displayGroupUpdated(int reqId, String contractInfo) {
		// TODO Auto-generated method stub
		logger.info("");
	}

	@Override
	public void error(Exception e) {
		// TODO Auto-generated method stub
		logger.info(e);
	}

	@Override
	public void error(String str) {
		// TODO Auto-generated method stub
		logger.info(str);
	}

	@Override
	public void error(int id, int errorCode, String errorMsg) {
		logger.info(id + " " + errorCode + " " + errorMsg);
		if(id == 513) {
			DashboardController.INSTANCE.stopUpdates();
			ErrorController.INSTANCE.displayError(new Error("Connection Error", errorMsg, ""));
		} else if(id == 504) {
			DashboardController.INSTANCE.stopUpdates();
			ErrorController.INSTANCE.displayError(new Error("Connection Error", errorMsg, ""));
		}
	}

	@Override
	public void connectionClosed() {
		// TODO Auto-generated method stub
		logger.info("Connection Closed");
	}

	@Override
	public void connectAck() {
		logger.info("Connection acknowledged");
	}


}
