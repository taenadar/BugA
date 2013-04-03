package com.core.buga.models;

import org.joda.time.DateTime;

public class Bug {

	private String title;
	private String projectName;
	private String description;
	private int rating;
	private DateTime insertDate;
	private DateTime resolvedDate;
	
	public Bug(){
	}
	
	public Bug(String title, String projectName, String description,
			int rating, DateTime insertDate, DateTime resolvedDate) {
		super();
		this.title = title;
		this.projectName = projectName;
		this.description = description;
		this.rating = rating;
		this.insertDate = insertDate;
		this.resolvedDate = resolvedDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public DateTime getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(DateTime insertDate) {
		this.insertDate = insertDate;
	}
	public DateTime getResolvedDate() {
		return resolvedDate;
	}
	public void setResolvedDate(DateTime resolvedDate) {
		this.resolvedDate = resolvedDate;
	}
	
	
}
