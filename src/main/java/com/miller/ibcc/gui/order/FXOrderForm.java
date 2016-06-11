package com.miller.ibcc.gui.order;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.miller.ibcc.gui.FXApplicationFrame;
import com.miller.ibcc.gui.injector.FXContentInjector;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public enum FXOrderForm implements OrderForm {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(FXOrderForm.class);
	private Pane pane;
	
	private FXOrderForm() {
		try {
			FXMLLoader loader = new FXMLLoader(FXApplicationFrame.class.getResource("/fxml/order-form.fxml"));
			loader.setController(this);
			pane = loader.load();
		} catch (IOException e) {
			logger.error("Could not load FXML document", e);
		} catch(IllegalStateException e) {
			logger.error("Could not load FXML document", e);
		}
	}

	@Override
	public void display() {
		FXContentInjector.INSTANCE.injectContent(pane);
	}
	
	

}
