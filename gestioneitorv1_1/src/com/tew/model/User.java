package com.tew.model;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private String login1;
	private String name;
	
	public User(String login, String string) {
		// TODO Auto-generated constructor stub
		login1=login;
		name=string;
	}
	public String getLogin1() {
		return login1;
	}
	public void setLogin1(String login1) {
		this.login1 = login1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
