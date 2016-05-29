package com.miller.ibcc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public enum ApplicationSettingsController {
	
	INSTANCE;
	
	private File SETTINGSFILE;
	
	private Map<Setting, Object> settings = new HashMap<Setting, Object>();
	private Logger logger = Logger.getLogger(ApplicationSettingsController.class);
	
	private ApplicationSettingsController() {
		logger.info("Initializing Settings Controller");
		
		SETTINGSFILE = new File(System.getProperty("user.home") 
				+ File.separator + "IBCC" + File.separator + "settings.conf");
		
		try {
			if(!SETTINGSFILE.exists()) {
				SETTINGSFILE.mkdirs();
				SETTINGSFILE.createNewFile();
			}
		} catch(IOException e) {
			logger.error("Could not create settings file!", e);
		}
		
		read();
	}
		
	/**
	 * Initializes the properties
	 */
	private void read() {
		logger.info("Reading settings file");
		//TODO read the settings from somewher
		settings.put(Setting.CLIENT_ID, "123456");
		settings.put(Setting.HOST, "localhost");
		settings.put(Setting.PORT, "7496");
	}
	
	/**
	 * Saves the properties
	 */
	private void save() {
		logger.info("Saving settings file");
		//TODO do something with settings map
	}
	
	public String getSetting(Setting setting) {
		return String.valueOf(settings.get(setting));
	}
	
	public int getSettingAsInt(Setting setting) {
		return Integer.parseInt(String.valueOf(settings.get(setting)));
	}
	
	public void setSetting(Setting setting, Object value) {
		settings.put(setting, value);
		save();
	}
	
	public enum Setting {
		CLIENT_ID,
		PORT,
		HOST
	}

}
