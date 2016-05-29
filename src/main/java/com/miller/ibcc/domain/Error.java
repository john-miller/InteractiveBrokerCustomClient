package com.miller.ibcc.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A simple error object that can be displayed in a form
 *
 * Created On May 29, 2016
 * @author Jonathan Miller
 */
public class Error {

	private String name;
	private String description;
	private Collection<String> resolutionsSteps = new ArrayList<String>();
	 
	public Error(String name, String description, String...resultionSteps) {
		this.name = name;
		this.description = description;
		resolutionsSteps.addAll(resolutionsSteps);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<String> getResolutionsSteps() {
		return resolutionsSteps;
	}

	public void setResolutionsSteps(Collection<String> resolutionsSteps) {
		this.resolutionsSteps = resolutionsSteps;
	}

}
