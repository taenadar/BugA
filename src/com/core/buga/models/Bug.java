package com.core.buga.models;

import org.joda.time.DateTime;

public class Bug {

	private String title;
	private String body;
	private String state;
	
	public Bug(){
	}
	
	public Bug(String title, String description, String state) {
		super();
		this.title = title;
		this.body = description;
		this.state = state;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
