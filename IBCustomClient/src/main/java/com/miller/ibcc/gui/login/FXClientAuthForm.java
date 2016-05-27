package com.miller.ibcc.gui.login;

/**
 * JavaFX implementation of the login form
 *
 * Created on May 27, 2016 3:07:40 PM
 * @author Jonathan Miller
 */
public enum FXClientAuthForm implements ClientAuthForm {
	
	INSTANCE;
	
	public static ClientAuthForm getInstance() {
		return INSTANCE;
	}

	@Override
	public void display(ClientAuthListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSave() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSave(boolean save) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPort(int port) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getClientId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setClientId(int clientId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHost(String host) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
