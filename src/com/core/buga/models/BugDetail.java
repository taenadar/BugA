package com.core.buga.models;

public class BugDetail extends Bug {
	
	private String title;
	private String status;
	private String descriptionFull;
	
	
	public BugDetail(){
		super();
	}
	
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getDescriptionFull() {
		return descriptionFull;
	}

	public void setDescriptionFull(String descriptionFull) {
		this.descriptionFull = descriptionFull;
	}
	
}
