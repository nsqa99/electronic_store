package ltweb.electronic_store.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import ltweb.electronic_store.model.DetailCart;
import ltweb.electronic_store.model.DetailOrdes;

public class DetailCartConverter {
	public static DetailCart convert(ResultSet rs) throws SQLException {
		int MaHD = rs.getInt("MaGH");
		int MaSP = rs.getInt("MaSP");
		String TenSP = rs.getString("TenSP");
		int Soluong = rs.getInt("Soluong");
		double Gia = rs.getDouble("Gia");

		return new DetailCart(MaHD, MaSP, TenSP, Soluong, Gia);
	}
}
