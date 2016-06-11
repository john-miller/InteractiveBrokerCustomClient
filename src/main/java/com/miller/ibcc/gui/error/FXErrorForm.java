package com.miller.ibcc.gui.error;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.miller.ibcc.domain.Error;
import com.miller.ibcc.gui.FXApplicationFrame;
import com.miller.ibcc.gui.injector.FXContentInjector;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public enum FXErrorForm implements ErrorForm {
	
	INSTANCE;
	
	private AnchorPane anchorPane;
	
	@FXML
	private Label lblErrorHeader;
	
	@FXML
	private Label lblErrorDescription;
	
	private Logger logger = Logger.getLogger(FXErrorForm.class);	
	private StringProperty propErrorName = new SimpleStringProperty();
	private StringProperty propErrorMessage = new SimpleStringProperty();
	
	private FXErrorForm() {
		try {
			FXMLLoader loader = new FXMLLoader(FXApplicationFrame.class.getResource("/fxml/error-form.fxml"));
			loader.setController(this);
			anchorPane = loader.load();
			lblErrorHeader.textProperty().bindBidirectional(propErrorName);
			lblErrorDescription.textProperty().bindBidirectional(propErrorMessage);
		} catch (IOException e) {
			logger.error("Could not load FXML document", e);
		} catch(IllegalStateException e) {
			logger.error("Could not load FXML document", e);
		}
	}

	@Override
	public void displayError(Error error) {
		propErrorName.set(error.getName());
		propErrorMessage.set(error.getDescription());
		FXContentInjector.INSTANCE.injectContent(anchorPane);
	}

}
