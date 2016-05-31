package com.miller.ibcc.gui.injector;

import org.apache.log4j.Logger;

import com.miller.ibcc.gui.FXApplicationFrame;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * Inject any subclass of pane into the FXApplication frame
 *
 * Created On May 30, 2016
 * @author Jonathan Miller
 */
public enum FXContentInjector implements ContentInjector<Pane> {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(FXContentInjector.class);
	
	public void injectContent(Pane pane) {
		logger.info("Injecting " + pane);
		BorderPane borderPane = (BorderPane) FXApplicationFrame.INSTANCE.getContainer();
		borderPane.setCenter(pane);
	}

}
