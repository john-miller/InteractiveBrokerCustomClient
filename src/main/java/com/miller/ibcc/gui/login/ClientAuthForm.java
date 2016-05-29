package com.miller.ibcc.gui.login;

/**
 * Login form for the application
 *
 * Created on May 27, 2016 3:02:19 PM
 * @author Jonathan Miller
 */
public interface ClientAuthForm {
	
	/**
	 * Event handler for the login form
	 *
	 * Created on May 27, 2016 3:06:54 PM
	 * @author Jonathan Miller
	 */
	public interface ClientAuthListener {
		public void onAuth(int clientId, String host, int port);
		public void onCancel();
	}
	
	public void display(ClientAuthListener listener);
	
	public boolean isSave();
	
	public void setSave(boolean save);
	
	public int getPort();
	
	public void setPort(int port);
	
	public int getClientId();
	
	public void setClientId(int clientId);
	
	public String getHost();
	
	public void setHost(String host);

}
