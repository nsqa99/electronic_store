package ltweb.electronic_store.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import ltweb.electronic_store.model.ChitietHoadon;

public class ChitietHoadonConverter {
	public static ChitietHoadon convert(ResultSet rs) throws SQLException {
		int MaHD = rs.getInt("MaHD");
		int MaSP = rs.getInt("MaSP");
		String TenSP = rs.getString("TenSP");
		int Soluong = rs.getInt("Soluong");
		double Gia = rs.getDouble("Gia");

		return new ChitietHoadon(MaHD, MaSP, TenSP, Soluong, Gia);
	}
}
