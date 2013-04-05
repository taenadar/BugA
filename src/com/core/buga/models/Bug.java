package com.core.buga.models;

import org.joda.time.DateTime;

public class Bug {
	
	private String number;
	private String title;
	private String body;
	private String state;
	private User user;
	
	public Bug(){
	}
	
	public Bug(String number, String title, String body, String state, User user) {
		super();
		this.number = number;
		this.title = title;
		this.body = body;
		this.state = state;
		this.user = user;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
