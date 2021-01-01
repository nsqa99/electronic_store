package ltweb.electronic_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ltweb.electronic_store.contants.Queries;
import ltweb.electronic_store.model.ChitietHoadon;
import ltweb.electronic_store.model.Product;
import ltweb.electronic_store.utils.ChitietHoadonConverter;
import ltweb.electronic_store.utils.DBConnect;
import ltweb.electronic_store.utils.ProductConverter;

public class ChitietHoaDonDAO {
	private Connection conn;
	private DBConnect db = DBConnect.getInstance();

	public ChitietHoaDonDAO() {
		this.conn = db.getConnection();
	}
	
	public ArrayList<ChitietHoadon> getByIDHD(int ma) {
		ArrayList<ChitietHoadon> chitietHD = new ArrayList<ChitietHoadon>();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_CHITIETHOADON_BY_IDHD);
			stm.setInt(1, ma);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ChitietHoadon ct = ChitietHoadonConverter.convert(rs);
				Product sp = get_SP_ByCTHD(ct);
				ct = set_Gia_BySP(sp, ct);
				chitietHD.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chitietHD;
	}
	public Product get_SP_ByCTHD(ChitietHoadon cthd) {
		int maSP = cthd.getIdSP();
		Product sp = new Product();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_PRODUCT_BY_ID);
			stm.setInt(1, maSP);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				sp = ProductConverter.convert(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sp;
	}
	// cat dat gia tri gia san pham cho chi tiet hoa don
	public ChitietHoadon set_Gia_BySP(Product sp, ChitietHoadon cthd) {
		double gia = sp.getPrice();
		String tensp = sp.getName();
		cthd.setGia(gia);
		cthd.setTenSP(tensp);
		
		return cthd;
	}
}
