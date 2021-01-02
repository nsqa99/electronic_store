package ltweb.electronic_store.dao;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;


import ltweb.electronic_store.contants.Queries;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.utils.CustomerConverter;
import ltweb.electronic_store.utils.DBConnect;


public class CustomerDAO {
	private Connection conn;
	private DBConnect db = DBConnect.getInstance();

	public CustomerDAO() {
		this.conn = db.getConnection();
	}
	public ArrayList<Customer> getAll() {
		ArrayList<Customer> customer = new ArrayList<Customer>();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_CUSTOMER);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				customer.add(CustomerConverter.convert(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customer;
	}
//
//	public Customer getByName(String username, String password, String fullname, String address, String phone, String gender ) {
//		Customer cus =new Customer();
	public int addCust( Customer customer) {
		int res=0;
		if (customer != null) {
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.ADD_CUSTOMER);
			String username=customer.getUsername();
			String password=customer.getPassword();
			String fullname=customer.getFullName();
			String address=customer.getAddress();
			String gender=customer.getGender();
			String phone =customer.getPhone();
			stm.setString(1, username);
			stm.setString(2, password);
			stm.setString(3, fullname);
			stm.setString(4, gender);
		    stm.setString(5, phone);
			stm.setString(6, address);
		
			res=stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		  }
        }
		return res;
	}
	public static String Valadate (String pass) throws NoSuchAlgorithmException {
		MessageDigest alg = MessageDigest.getInstance("MD5");
			alg.reset();
	        alg.update(pass.getBytes());
	        byte[] digest = alg.digest();   
	        StringBuffer hashedpasswd = new StringBuffer();
            String hx;
        for (int i = 0; i < digest.length; i++) {
            hx = Integer.toHexString(0xFF & digest[i]);
            //0x03 is equal to 0x3, but we need 0x03 for our md5sum
            if (hx.length() == 1) {
                hx = "0" + hx;
            }
            hashedpasswd.append(hx);
	       }
        	 return hashedpasswd.toString();
		}
	
}
