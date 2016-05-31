package com.miller.ibcc.gui.dashboard;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.miller.ibcc.gui.FXApplicationFrame;
import com.miller.ibcc.gui.injector.FXContentInjector;
import com.sun.javafx.application.PlatformImpl;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public enum FXDashboardForm implements DashboardForm {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(FXDashboardForm.class);
	private AnchorPane pane;
	
	private FXDashboardForm() {
		PlatformImpl.runAndWait(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(FXApplicationFrame.class.getResource("/fxml/dashboard-form.fxml"));
					loader.setController(FXDashboardForm.INSTANCE);
					pane = loader.load();
				} catch (IOException e) {
					logger.error("Could not load FXML document", e);
				} catch(IllegalStateException e) {
					logger.error("Could not load FXML document", e);
				}
			} 
		});
	}

	@Override
	public void display() {
		FXContentInjector.INSTANCE.injectContent(pane);
	}

}
