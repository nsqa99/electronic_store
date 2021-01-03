package ltweb.electronic_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ltweb.electronic_store.contants.Queries;
import ltweb.electronic_store.model.Cart;
import ltweb.electronic_store.model.Rating;
import ltweb.electronic_store.utils.CartConverter;
import ltweb.electronic_store.utils.DBConnect;
import ltweb.electronic_store.utils.RatingConverter;

public class RatingDAO {
	private Connection conn;
	private DBConnect db = DBConnect.getInstance();

	public RatingDAO() {
		this.conn = db.getConnection();
	}

// lấy giỏ hàng dựa vào mã khách hàng -- chua có danh sách sản phẩm
	public boolean createRating(Rating rate) {

		try {
			PreparedStatement stm = conn.prepareStatement(Queries.INSERT_RATING);
			stm.setInt(1, rate.getIdCust());
			stm.setInt(2, rate.getIdProduct());
			stm.setInt(3, rate.getStar());
			stm.setString(4, rate.getContent());
			System.out.println("\\\\\\\\\\");
			int rs = stm.executeUpdate();
			System.out.println("Them danh gia thanh cong");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("co loi");
		}

		return false;
	}
	
	//check ton tai cua danh gia
	public boolean checkRating(int kh, int sp) {

		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_RATING_BY_ID);
			stm.setInt(1, kh);
			stm.setInt(2, sp);;
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				return true;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("co loi");
		}

		return false;
	}
	public boolean updateRating(Rating rate) {

		try {
			PreparedStatement stm = conn.prepareStatement(Queries.UPDATE_RATING);
			stm.setInt(1, rate.getStar());
			stm.setString(2, rate.getContent());
			stm.setInt(3, rate.getIdCust());
			stm.setInt(4, rate.getIdProduct());
			int rs = stm.executeUpdate();
			if(rs == 1) {
				return true;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("co loi");
			
		}

		return false;
	}
// lay danh gia dua vao ma khach hang va ma san pham
	public Rating getRating(int kh, int sp) {
		Rating rate = new Rating();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_RATING_BY_ID);
			stm.setInt(1, kh);
			stm.setInt(2, sp);
			
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				rate = RatingConverter.convert(rs);
				break;
			}
			System.out.println("lay danh gia thanh cong");
//			return rate;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("co loi");
		}

		return rate;
	}
}
