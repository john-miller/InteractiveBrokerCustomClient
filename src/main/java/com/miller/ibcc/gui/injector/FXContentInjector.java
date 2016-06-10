package com.miller.ibcc.gui.injector;

import org.apache.log4j.Logger;

import com.miller.ibcc.gui.FXApplicationFrame;
import com.sun.javafx.application.PlatformImpl;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 * Inject any subclass of pane into the FXApplication frame
 *
 * Created On May 30, 2016
 * @author Jonathan Miller
 */
public enum FXContentInjector implements ContentInjector<Pane> {
	
	INSTANCE;
	
	private Logger logger = Logger.getLogger(FXContentInjector.class);
	private final long transitionTimeMillis = 150;
	
	public void injectContent(final Pane pane) {
		PlatformImpl.runAndWait(new Runnable() {
			@Override
			public void run() {
				logger.info("Injecting " + pane);
				BorderPane borderPane = (BorderPane) FXApplicationFrame.INSTANCE.getContainer();
				Node centerNode = borderPane.getCenter();
				fadeNodes(borderPane, centerNode, pane);
			}
		});
	}
	
	/**
	 * Transitions the panes in and out of the parent frame
	 * @param parentPane
	 * @param out
	 * @param in
	 */
	public void fadeNodes(final BorderPane parentPane, final Node out, final Pane in) {
		FadeTransition transitionOut = new FadeTransition(Duration.millis(transitionTimeMillis), out);
		transitionOut.setFromValue(1.0);
		transitionOut.setToValue(0.0);
		transitionOut.setCycleCount(1);
		transitionOut.setAutoReverse(false);
		transitionOut.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				in.prefWidthProperty().bind(parentPane.widthProperty());
				in.prefHeightProperty().bind(parentPane.heightProperty().subtract(parentPane.getTop().getBoundsInParent().getHeight()));
				in.setOpacity(0);
				parentPane.setCenter(in);
				FadeTransition transitionIn = new FadeTransition(Duration.millis(transitionTimeMillis), in);
				transitionIn.setFromValue(0);
				transitionIn.setToValue(1);
				transitionIn.setCycleCount(1);
				transitionIn.setAutoReverse(false);
				transitionIn.play();
			}
		});
		 
		transitionOut.play();
	}
	
	
	/**
	 * Transitions the panes in and out of the parent frame
	 * @param parentPane
	 * @param out
	 * @param in
	 */
	public void slideNodes(final BorderPane parentPane, final Node out, final Pane in) {
		
		if(out != null) {
			TranslateTransition transitionOut = new TranslateTransition();
			transitionOut.setDuration(Duration.millis(2000));
			transitionOut.setNode(out);
			transitionOut.setToX(out.getLayoutBounds().getWidth()*-1);
			transitionOut.setCycleCount(1);
			transitionOut.setAutoReverse(false);
			transitionOut.setOnFinished(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					in.prefWidthProperty().bind(parentPane.widthProperty());
					in.prefHeightProperty().bind(parentPane.heightProperty().subtract(parentPane.getTop().getBoundsInParent().getHeight()));
					parentPane.setCenter(in);
					TranslateTransition transitionIn = new TranslateTransition();
					transitionIn.setDuration(Duration.millis(2000));
					transitionIn.setNode(in);
					transitionIn.setFromX(parentPane.getWidth());
					transitionIn.setCycleCount(1);
					transitionIn.setAutoReverse(false);
					transitionIn.play();
				}
			});
			 
			transitionOut.play();
		} else {
			in.prefWidthProperty().bind(parentPane.widthProperty());
			in.prefHeightProperty().bind(parentPane.heightProperty().subtract(parentPane.getTop().getBoundsInParent().getHeight()));
			in.setOpacity(0);
			parentPane.setCenter(in);
			FadeTransition ft = new FadeTransition(Duration.millis(transitionTimeMillis), in);
			ft.setFromValue(0);
			ft.setToValue(1);
			ft.setCycleCount(1);
			ft.setAutoReverse(false);
			ft.play();
		}
	}
	

}
