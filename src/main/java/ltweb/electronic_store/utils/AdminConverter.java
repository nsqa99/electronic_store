package ltweb.electronic_store.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import ltweb.electronic_store.model.Admin;

public class AdminConverter {

	public static Admin convert(ResultSet rs) throws SQLException {
		int idAdmin = rs.getInt("MaAdmin");
		String tendnAdmin = rs.getString("Tendangnhap");
		String passAdmin = rs.getString("Matkhau");
		String role = rs.getString("Quyen");
		String ten = rs.getString("Ten");
		String gioitinh = rs.getString("Gioitinh");
		Date ngaysinh = rs.getDate("Ngaysinh");
		String ns = (ngaysinh != null) ? ngaysinh.toString() : null;
		String diachi = rs.getString("Diachi");
		// System.out.println("admin: " + idAdmin + tendnAdmin + passAdmin + ten +
		// diachi + gioitinh + ngaysinh + diachi);

		return new Admin(tendnAdmin, passAdmin, ten, diachi, gioitinh, ns, idAdmin, role);
	}
}
