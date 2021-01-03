package ltweb.electronic_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public Customer getCust(String username, String password) {
		Customer c = null;
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_CUSTOMER_BY_USN);
			stm.setString(1, username);
			stm.setString(2, password);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				c = CustomerConverter.convert(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	public int addCust(Customer customer) {
		int res = 0;
		if (customer != null) {
			try {
				PreparedStatement stm = conn.prepareStatement(Queries.ADD_CUSTOMER);
				String username = customer.getUsername();
				String password = customer.getPassword();
				String fullname = customer.getFullName();
				String address = customer.getAddress();
				String gender = customer.getGender();
				String phone = customer.getPhone();
				stm.setString(1, username);
				stm.setString(2, password);
				stm.setString(3, fullname);
				stm.setString(4, gender);
				stm.setString(5, phone);
				stm.setString(6, address);

				res = stm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

}
