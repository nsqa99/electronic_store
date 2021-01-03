package ltweb.electronic_store.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import ltweb.electronic_store.model.Rating;

public class RatingConverter {
	public static Rating convert(ResultSet rs) throws SQLException {
		int MaKH = rs.getInt("MaKH");
		int MaSP = rs.getInt("MaSP");
		String Danhgia = rs.getString("Danhgia");
		int Star = rs.getInt("Star");
		return new Rating(Danhgia, MaKH, MaSP, Star);
	}
}
