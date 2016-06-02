package com.miller.ibcc.controller;

import org.apache.log4j.Logger;

import com.ib.client.EClientSocketSSL;
import com.miller.ibcc.controller.ApplicationSettingsController.Setting;
import com.miller.ibcc.domain.Error;
import com.miller.ibcc.domain.User;
import com.miller.ibcc.event.GlobalEventHandler;
import com.miller.ibcc.event.GlobalSignalEventHandler;
import com.miller.ibcc.exception.AuthorizationException;
import com.miller.ibcc.gui.ApplicationFrame;
import com.miller.ibcc.gui.FXApplicationFrame;
import com.miller.ibcc.gui.login.ClientAuthForm;
import com.miller.ibcc.gui.login.ClientAuthForm.ClientAuthListener;
import com.miller.ibcc.gui.login.FXClientAuthForm;
import com.miller.ibcc.menu.MenuBarItem;
import com.miller.ibcc.menu.file.FileMenuBarItem;
import com.miller.ibcc.menu.help.DashboardHelpMenuBarItem;
import com.miller.ibcc.menu.options.AbstractOptionsMenu;
import com.miller.ibcc.menu.options.DashboardMenuBarItem;
import com.miller.ibcc.menu.options.AbstractHelpMenuBarItem;

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
	private MenuBarItem optionsMenu = new AbstractOptionsMenu() {
		@Override
		public MenuBarItem[] getSubMenus() {
			return new MenuBarItem[]{ DashboardMenuBarItem.INSTANCE };
		}
	};
	private MenuBarItem helpMenu = new AbstractHelpMenuBarItem() {
		@Override
		public MenuBarItem[] getOptionalHelpMenus() {
			return new MenuBarItem[]{ DashboardHelpMenuBarItem.INSTANCE };
		}
	};
	
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
				ApplicationController.INSTANCE.shutdown();
			}
			@Override
			public void onAuth() {
				logger.info("Client successfully authenticated");
				DashboardController.INSTANCE.show();
			}
			@Override
			public void onError(Throwable t) {
				ErrorController.INSTANCE.displayError(new Error("Authorization Error", 
						"Not sure what happened here", 
						"Not sure what to do either"));
			}
		});
	}
	
	public void authenticate(AuthenticationControllerListener listener) {
		
		logger.info("Authenticating user");
		
		/* Get a GUI instance */
		ClientAuthForm clientAuthForm = FXClientAuthForm.INSTANCE;
		
		logger.info("Client auth form type: " + clientAuthForm.getClass());
	
		clientAuthForm.setClientId(ApplicationSettingsController.INSTANCE.getSettingAsInt(Setting.CLIENT_ID));
		clientAuthForm.setHost(ApplicationSettingsController.INSTANCE.getSetting(Setting.HOST));
		clientAuthForm.setPort(ApplicationSettingsController.INSTANCE.getSettingAsInt(Setting.PORT));
		
		/* Set the third party menu items */
		ApplicationFrame applicationFrame = FXApplicationFrame.INSTANCE;
		applicationFrame.setThirdPartyMenuBarItems(FileMenuBarItem.INSTANCE, optionsMenu, helpMenu);
		
		/* */
		clientAuthForm.display(new ClientAuthListener() {
			@Override
			public void onAuth(int clientId, String host, int port) {
				EClientSocketSSL eclientSSL = new EClientSocketSSL(GlobalEventHandler.getInstance(), GlobalSignalEventHandler.getInstance());
				eclientSSL.eConnect(host, port, clientId);
				if(eclientSSL.isConnected()) {
					listener.onAuth();
				} else {
					listener.onError(new AuthorizationException("Could not connect to TWS session"));
				}
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
		public void onError(Throwable t);
		public void onCancel();
	}

}
