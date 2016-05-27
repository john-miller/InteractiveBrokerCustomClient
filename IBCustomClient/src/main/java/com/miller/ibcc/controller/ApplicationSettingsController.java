package com.miller.ibcc.controller;

import java.util.HashMap;
import java.util.Map;

public enum ApplicationSettingsController {
	
	INSTANCE;
	
	public static ApplicationSettingsController getInstance() {
		return INSTANCE;
	}
	
	private Map<Setting, Object> settings = new HashMap<Setting, Object>();
	
	private ApplicationSettingsController() {
		read();
	}
		
	/**
	 * Initializes the properties
	 */
	private void read() {
		//TODO read the settings from somewher
		settings.put(Setting.CLIENT_ID, "123456");
	}
	
	/**
	 * Saves the properties
	 */
	private void save() {
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
