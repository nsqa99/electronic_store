package ltweb.electronic_store.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import ltweb.electronic_store.model.DetailOrdes;

public class DetailOrderConverter {
	public static DetailOrdes convert(ResultSet rs) throws SQLException {
		int MaHD = rs.getInt("MaHD");
		int MaSP = rs.getInt("MaSP");
		String TenSP = rs.getString("TenSP");
		int Soluong = rs.getInt("Soluong");
		double Gia = rs.getDouble("Gia");

		return new DetailOrdes(MaHD, MaSP, TenSP, Soluong, Gia);
	}
}
