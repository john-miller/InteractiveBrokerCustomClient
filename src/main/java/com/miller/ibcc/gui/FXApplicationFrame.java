package com.miller.ibcc.gui;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.miller.ibcc.menu.MenuBarItem;
import com.sun.javafx.application.PlatformImpl;
import com.sun.javafx.application.PlatformImpl.FinishListener;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * JavaFX implementation of the application frame
 *
 * Created on May 27, 2016 3:20:38 PM
 * @author Jonathan Miller
 */
public enum FXApplicationFrame implements ApplicationFrame {
	
	INSTANCE;
	
	private AnchorPane pane;
	private Stage primaryStage;
	private Scene scene;
	
	private Menu optionsMenu = new Menu("Options");
	
	@FXML
	private BorderPane container;
	
	@FXML
	private MenuBar menuBar;
	
	private DoubleProperty visibleProperty = new SimpleDoubleProperty(0);
	
	private Logger logger = Logger.getLogger(FXApplicationFrame.class);
	
	private FXApplicationFrame() {
	
		logger.info("Starting up platform");
		PlatformImpl.startup(new Runnable() {
			@Override
			public void run() {
				logger.info("Starting up JavaFX platform");
			}
		});
		
		logger.info("Setting up resources");
		PlatformImpl.addListener(new FinishListener() {
			@Override
			public void idle(boolean arg0) {
				logger.info("Platform is idle");
			}
			@Override
			public void exitCalled() {
				logger.info("Platform exit has been initiated");
			}
		});
			
		logger.info("Loading stage fxml document");

		try {
			FXMLLoader loader = new FXMLLoader(FXApplicationFrame.class.getResource("/fxml/application-frame.fxml"));
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
		PlatformImpl.runAndWait(new Runnable() {
			@Override
			public void run() {
				logger.info("Showing primary stage");
				visibleProperty.set(1);
				primaryStage = new Stage();
				menuBar.getMenus().add(optionsMenu);
				scene = new Scene(pane);
				scene.getStylesheets().add(FXApplicationFrame.class.getResource("/css/default-style.css").toExternalForm());
				primaryStage.getIcons().add(new Image(FXApplicationFrame.class.getResourceAsStream("/images/icon.png")));
				primaryStage.setTitle("Custom Interactive Broker Client");
				primaryStage.setScene(scene);
				primaryStage.show();
			}
		});
	}

	@Override
	public Object getContainer() {
		return container;
	}

	@Override
	public void setThirdPartyMenuBarItems(MenuBarItem...menuBarItems) {
		PlatformImpl.runLater(new Runnable() {
			@Override
			public void run() {
				logger.info("Adding third party menu items");
				menuBar.getMenus().removeAll(menuBar.getMenus());
				
				for(final MenuBarItem item : menuBarItems) {
					addMenuBarItems(null, item);
				}
			}
		});
	}
	
	private void addMenuBarItems(Menu parentItem, MenuBarItem item) {
		//TODO make code cleaner
		if(parentItem == null || item.getSubMenus().length > 0) {
			Menu parentMenu = new Menu(item.getName());
			parentMenu.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					item.onAction();
				}
			});
			for(MenuBarItem childItem : item.getSubMenus()) {
				addMenuBarItems(parentMenu, childItem);
			}
			
			menuBar.getMenus().add(parentMenu);
		} else {
			MenuItem newItem = new MenuItem(item.getName());
			newItem.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					item.onAction();
				}
			});
			parentItem.getItems().add(newItem);
		}
		
		
	}
	
}

