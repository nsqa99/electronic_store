package ltweb.electronic_store.model;

public class Admin extends User {
	private int idAdmin;
	private String role;

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Admin(String username, String password, String fullName, String address, String gender, String dob,
			int idAdmin, String role) {
		super(username, password, fullName, address, gender, dob);
		this.idAdmin = idAdmin;
		this.role = role;
	}

	public Admin(String username, String password, String fullName, String address, String gender, int idAdmin,
			String role) {
		super(username, password, fullName, address, gender);

		// TODO Auto-generated constructor stub
		this.idAdmin = idAdmin;
		this.role = role;
	}

}
