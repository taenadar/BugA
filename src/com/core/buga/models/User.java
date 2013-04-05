package com.core.buga.models;

public class User {
	private String login;
	private String id;
	private String avatar_url;
	
	public User(){
	}
	
	public User(String login, String id, String avatar_url) {
		super();
		this.login = login;
		this.id = id;
		this.avatar_url = avatar_url;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}
}
