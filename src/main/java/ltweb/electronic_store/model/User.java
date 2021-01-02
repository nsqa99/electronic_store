package ltweb.electronic_store.model;

import java.util.Date;

public class User {

	private String username;
	private String password;
	private String fullName;
	private String address;
	private String gender;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String fullName, String address, String gender) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.address = address;
		this.gender = gender;
	}

	public User(String username, String fullName, String address, String gender) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.address = address;
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
