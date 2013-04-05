package com.core.buga.models;

public class BugDetail {
	
	private String number;
	private String title;
	private String state;
	private String body;
	
	
	public BugDetail(){
	}
	
	public BugDetail(String number, String title, String state,
			String body) {
		super();
		this.number = number;
		this.title = title;
		this.state = state;
		this.body = body;
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


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}
