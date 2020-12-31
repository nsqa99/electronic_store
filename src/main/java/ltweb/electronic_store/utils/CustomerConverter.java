package ltweb.electronic_store.utils;

import java.sql.*;
import ltweb.electronic_store.model.Customer;

public class CustomerConverter {
	
	public static Customer convert(ResultSet rs) throws SQLException {
		int idCust = rs.getInt("MaKH");
		String username = rs.getString("TenTK");
		String password = rs.getString("MK");
		String fullName = rs.getString("TDD");
		String address = rs.getString("DC");
		String phone = rs.getString("DT");
		String gender = rs.getString("GT");
		
		return new Customer(idCust, username, password, fullName, address, phone,gender);
	}

}
