package com.miller.ibcc.gui.login;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.miller.ibcc.gui.FXApplicationFrame;
import com.miller.ibcc.gui.injector.FXContentInjector;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * JavaFX implementation of the login form
 *
 * Created on May 27, 2016 3:07:40 PM
 * @author Jonathan Miller
 */
public enum FXClientAuthForm implements ClientAuthForm {
	
	INSTANCE;
	
	private BooleanProperty propSave = new SimpleBooleanProperty(false);
	private StringProperty propPort = new SimpleStringProperty();
	private StringProperty propClientId = new SimpleStringProperty();
	private StringProperty propHost = new SimpleStringProperty();
	private Logger logger = Logger.getLogger(FXClientAuthForm.class);
	private AnchorPane pane;
	private ClientAuthListener currentListener;
	@FXML
	private TextField txtClientId;
	@FXML
	private TextField txtHost;
	@FXML
	private TextField txtPort;
	
	private FXClientAuthForm() {
		try {
			FXMLLoader loader = new FXMLLoader(FXApplicationFrame.class.getResource("/fxml/login-form.fxml"));
			loader.setController(this);
			pane = loader.load();
			txtClientId.textProperty().bindBidirectional(propClientId);
			txtHost.textProperty().bindBidirectional(propHost);
			txtPort.textProperty().bindBidirectional(propPort);
		} catch (IOException e) {
			logger.error("Could not load FXML document", e);
		} catch(IllegalStateException e) {
			logger.error("Could not load FXML document", e);
		}
	}
	
	@Override
	public void display(ClientAuthListener listener) {
		this.currentListener = listener;
		FXContentInjector.INSTANCE.injectContent(pane);
	}

	@Override
	public boolean isSave() {
		return propSave.get();
	}

	@Override
	public void setSave(boolean save) {
		propSave.set(save);
	}

	@Override
	public int getPort() {
		return Integer.parseInt(propPort.get());
	}

	@Override
	public void setPort(int port) {
		propPort.set(String.valueOf(port));
	}

	@Override
	public int getClientId() {
		return Integer.parseInt(propClientId.get());
	}

	@Override
	public void setClientId(int clientId) {
		propClientId.set(String.valueOf(clientId));
	}

	@Override
	public String getHost() {
		return propHost.get();
	}

	@Override
	public void setHost(String host) {
		propHost.set(host);
	}
	
	@FXML
	public void login() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				if(currentListener != null) 
					currentListener.onAuth(getClientId(), getHost(), getPort());
			}
		}).start();
	}
	
	@FXML
	public void cancel() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				if(currentListener != null)
					currentListener.onCancel();
			}
		}).start();
	}
	
	
	

}
