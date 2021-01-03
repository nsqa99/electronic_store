package ltweb.electronic_store.model;

public class Customer extends User {
	private int idCust;
	private String phone;

	public Customer() {
	
	}

	public Customer(int idCust, String username, String password, String fullName, String address, String phone) {
		super(username, password, fullName, address, phone);
		this.idCust = idCust;
		this.phone = phone;
	}
	public Customer(String username, String password, String fullName, String address, String phone, String gender) {
		super(username, password, fullName, address, phone);
		
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Customer [idCust=" + idCust + ", phone=" + phone + ", getGender()=" + getGender() + ", getUsername()="
				+ getUsername() + ", getPassword()=" + getPassword() + ", getFullName()=" + getFullName()
				+ ", getAddress()=" + getAddress() + "]";
	}

	public Customer(String phone) {
		super();
		this.phone = phone;
	}

	public Customer(String username,  String fullName, String address, String phone, String gender) {
		super(username, fullName, address, phone, gender);
		this.phone = phone;
	}

	public Customer(int idCust, String username, String password, String fullName, String address, String phone,
			String dob) {
		super(username, password, fullName, address, phone, dob);
		this.idCust = idCust;
		this.phone = phone;
	}
	public Customer(String username, String password, String fullName,String gender, String phone, String address ) {
		super(username, password, fullName, address,gender);
//		this.idCust = idCust;
		this.phone = phone;
	}
	public int getIdCust() {
		return idCust;
	}

	public void setIdCust(int idCust) {
		this.idCust = idCust;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
