package ltweb.electronic_store.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.model.Order;

public class CustomerConverter {
	public static Customer convert(ResultSet rs) throws SQLException {
		int idCust = rs.getInt("MaKhach");
		String username = rs.getString("Tendangnhap");
		String password = rs.getString("Matkhau");
		String fullName = rs.getString("TenKH");
		String address = rs.getString("Diachi");
		String phone = rs.getString("SDT");
		return new Customer(idCust, username, password, fullName, address, phone);
	}
}
