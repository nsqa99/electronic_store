package ltweb.electronic_store.utils;

import java.sql.*;
import ltweb.electronic_store.model.Customer;

public class CustomerConverter {
	
	public static Customer convert(ResultSet rs) throws SQLException {
		int idCust = rs.getInt("MaKH");
		String username = rs.getString("TenTK");
		String password = rs.getString("MK");
		String fullName = rs.getString("TDD");
		String gender = rs.getString("GT");
		String phone = rs.getString("DT");
		String address = rs.getString("DC"); 
		return new Customer(idCust, username, password, fullName,gender, phone,address);
	}

}
