package com.miller.ibcc.gui.injector;

import org.apache.log4j.Logger;

import com.miller.ibcc.gui.FXApplicationFrame;
import com.sun.javafx.application.PlatformImpl;

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
		PlatformImpl.runAndWait(new Runnable() {
			@Override
			public void run() {
				logger.info("Injecting " + pane);
				BorderPane borderPane = (BorderPane) FXApplicationFrame.INSTANCE.getContainer();
				pane.prefWidthProperty().bind(borderPane.widthProperty());
				pane.prefHeightProperty().bind(borderPane.heightProperty().subtract(borderPane.getTop().getBoundsInParent().getHeight()));
				borderPane.setCenter(pane);
			}
		});
	}


}
