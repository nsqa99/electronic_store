package ltweb.electronic_store.dao;

import java.sql.*;
import java.util.ArrayList;

import ltweb.electronic_store.contants.Queries;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.utils.DBConnect;

public class CustomerDAO {
	private Connection conn;
	private DBConnect db = DBConnect.getInstance();

	public CustomerDAO() {
		this.conn = db.getConnection();
	}

//	public Static Customer getAll() {
//		Customer customer =new Customer();
//		try {
//			PreparedStatement stm = conn.prepareStatement(Queries.GET_CUSTOMER);
//			String usern=customer.getUsername();
//			String passw=customer.getPassword();
//			String fulln=customer.getFullName();
//			String addr=customer.getAddress();
//			String gend=customer.getGender();
//			String pho =customer.getPhone();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return customer;
//	}

	public Customer getByName(String username, String password, String fullname, String address, String phone, String gender ) {
		Customer cus =new Customer();
		// System.out.println(conn);
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.ADD_CUSTOMER);
			String usern=cus.getUsername();
			String passw=cus.getPassword();
			String fulln=cus.getFullName();
			String addr=cus.getAddress();
			String gend=cus.getGender();
			String pho =cus.getPhone();
			stm.setString(1, usern);
			stm.setString(2, passw);
			stm.setString(3, fulln);
			stm.setString(4, addr);
			stm.setString(5, gend);
		    stm.setString(6, pho);
			int kt=stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cus;
	}
	
	
}

