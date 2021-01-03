package ltweb.electronic_store.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import ltweb.electronic_store.model.Order;

public class OrderConverter {
	public static Order convert(ResultSet rs) throws SQLException {
		int idOrd = rs.getInt("MaHD");
		int idCust = rs.getInt("MaKH");
		String createdDate = rs.getString("Ngaylap");
		int amount = 0;
		double total = 0.0;
		return new Order(idOrd, idCust, createdDate, total, amount);
	}
}
