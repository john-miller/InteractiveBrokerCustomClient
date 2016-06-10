package com.miller.ibcc.gui.dashboard;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.miller.ibcc.controller.ErrorController;
import com.miller.ibcc.gui.FXApplicationFrame;
import com.miller.ibcc.gui.injector.FXContentInjector;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public enum FXDashboardForm implements DashboardForm {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(FXDashboardForm.class);
	private Pane pane;
	
	private FXDashboardForm() {
		try {
			logger.info("Creating FXDashboard UI");
			FXMLLoader loader = new FXMLLoader(FXApplicationFrame.class.getResource("/fxml/dashboard-form.fxml"));
			loader.setController(this);
			pane = loader.load();
		} catch (IOException e) {
			logger.error("Could not load FXML document", e);
			ErrorController.INSTANCE.displayError(new com.miller.ibcc.domain.Error("Dashboard Error", "Could not load the dashboard", ""));
		} catch(IllegalStateException e) {
			logger.error("Could not load FXML document", e);
			ErrorController.INSTANCE.displayError(new com.miller.ibcc.domain.Error("Dashboard Error", "Could not load the dashboard", ""));
		}
	}

	@Override
	public void display() {
		logger.info("Display dashboard form");
		FXContentInjector.INSTANCE.injectContent(pane);
	}

}
