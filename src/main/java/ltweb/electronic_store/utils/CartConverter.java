package ltweb.electronic_store.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import ltweb.electronic_store.model.Cart;

public class CartConverter {
	public static Cart convert(ResultSet rs) throws SQLException {
		int MaGH = rs.getInt("MaGH");
		int MaKH = rs.getInt("MaKH");
		String Diachi = rs.getString("Diachi");
		String SDT = rs.getString("SDT");
		return new Cart(MaGH, MaKH, Diachi, SDT);
	}
}
