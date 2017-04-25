package com.liudonghua.demo.model;

public class UserPartial {

	private int id;
	private String username;

	public UserPartial() {
	}

	public UserPartial(int id, String username) {
		this.id = id;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
