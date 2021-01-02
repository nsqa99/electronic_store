package ltweb.electronic_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ltweb.electronic_store.contants.Queries;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.utils.AdminConverter;
import ltweb.electronic_store.utils.CustomerConverter;
import ltweb.electronic_store.utils.DBConnect;

public class CustomerDAO {

	
	private Connection conn;
	private DBConnect db = DBConnect.getInstance();

	public CustomerDAO() {
		this.conn = db.getConnection();
	}
	
	public ArrayList<Customer> getCustByID(int ID) {
		ArrayList<Customer> customer = new ArrayList<Customer>();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_CUSTOMER_BY_ID);
			stm.setInt(1, ID);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				customer.add(CustomerConverter.convert(rs));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return customer;
	}
}
