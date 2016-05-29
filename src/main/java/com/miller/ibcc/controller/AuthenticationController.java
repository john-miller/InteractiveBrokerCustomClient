package com.miller.ibcc.controller;

import org.apache.log4j.Logger;

import com.ib.client.EClientSocketSSL;
import com.miller.ibcc.controller.ApplicationSettingsController.Setting;
import com.miller.ibcc.domain.User;
import com.miller.ibcc.event.GlobalEventHandler;
import com.miller.ibcc.event.GlobalSignalEventHandler;
import com.miller.ibcc.gui.login.ClientAuthForm;
import com.miller.ibcc.gui.login.ClientAuthForm.ClientAuthListener;
import com.miller.ibcc.gui.login.SwingClientAuthForm;

/**
 * Controller for user authentication
 *
 * Created on May 27, 2016 3:54:28 PM
 * @author Jonathan Miller
 */
public enum AuthenticationController {
	
	INSTANCE;

	private User currentUser;
	private Logger logger = Logger.getLogger(AuthenticationController.class);
	
	public boolean isAuthenticated() {
		if(currentUser != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void authenticateToDashboard() {
		authenticate(new AuthenticationControllerListener() {
			@Override
			public void onCancel() {
				logger.info("Client canceled authentication");
			}
			@Override
			public void onAuth() {
				logger.info("Client successfully authenticated");
				DashboardController.INSTANCE.show();
			}
		});
	}
	
	public void authenticate(AuthenticationControllerListener listener) {
		
		logger.info("Authenticating user");
		
		/* Get a GUI instance */
		ClientAuthForm clientAuthForm = SwingClientAuthForm.INSTANCE;
		
		logger.info("Client auth form type: " + clientAuthForm.getClass());
		
		clientAuthForm.setClientId(ApplicationSettingsController.INSTANCE.getSettingAsInt(Setting.CLIENT_ID));
		clientAuthForm.setHost(ApplicationSettingsController.INSTANCE.getSetting(Setting.HOST));
		clientAuthForm.setPort(ApplicationSettingsController.INSTANCE.getSettingAsInt(Setting.PORT));
		
		/* */
		clientAuthForm.display(new ClientAuthListener() {
			@Override
			public void onAuth(int clientId, String host, int port) {
				EClientSocketSSL eclientSSL = new EClientSocketSSL(GlobalEventHandler.getInstance(), GlobalSignalEventHandler.getInstance());
				eclientSSL.eConnect(host, port, clientId);
				listener.onAuth();
			}
			@Override
			public void onCancel() {
				listener.onCancel();
			}
		});
	}
	
	public User getCurrentUser() {
		return currentUser;
	}
	
	public interface AuthenticationControllerListener {
		public void onAuth();
		public void onCancel();
	}

}
