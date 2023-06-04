package com.example.demo.DTO;

public class LoginDTO {

	private String username;
	private String userpassword;
	
	public LoginDTO(String username, String userpassword) {
		super();
		this.username = username;
		this.userpassword = userpassword;
	}

	public LoginDTO() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public String toString() {
		return "LoginDTO [username=" + username + ", userpassword=" + userpassword + "]";
	}
	
	
}
