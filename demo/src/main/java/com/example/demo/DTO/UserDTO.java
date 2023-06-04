package com.example.demo.DTO;

public class UserDTO {
	
	private int id;
	private String fullname;
	private String username;
	private String userpassword;
	
	public UserDTO(int id, String fullname, String username, String userpassword) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.userpassword = userpassword;
	}

	public UserDTO() {
	}

	

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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
		return "UserDTO [fullname=" + fullname + ", username=" + username + ", userpassword="
				+ userpassword + "]";
	}
	
	
}
