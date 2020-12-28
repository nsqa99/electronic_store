package ltweb.electronic_store.model;

import java.util.Date;

public class Admin extends User {
	private int idAdmin;
	private String role;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password, String fullName, String address, String gender, Date dob,
			String idAdmin, String role) {
		super(username, password, fullName, address, gender, dob);
		// TODO Auto-generated constructor stub
		this.idAdmin = idAdmin;
		this.role = role;
	}

}
