package ltweb.electronic_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ltweb.electronic_store.contants.Queries;
import ltweb.electronic_store.model.ChitietHoadon;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.model.Order;
import ltweb.electronic_store.utils.CustomerConverter;
import ltweb.electronic_store.utils.DBConnect;
import ltweb.electronic_store.utils.HoadonConverter;

public class HoadonDAO {
	private Connection conn;
	private DBConnect db = DBConnect.getInstance();

	public HoadonDAO() {
		this.conn = db.getConnection();
	}

// tra lai danh sach cac hoa don --> cho admin su dung
	public ArrayList<Order> getAll() {
		ArrayList<Order> hoadon = new ArrayList<Order>();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_ORDER);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Order hd = HoadonConverter.convert(rs);
				hd = setHDByIDKH(hd.getIdCust());
				hoadon.add(hd);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hoadon;
	}
	// lay danh dach chi tiet hoa don theo ma hoa don
	public ArrayList<ChitietHoadon> getAllByIDHD(int ma) {
		ArrayList<ChitietHoadon> ct = new ArrayList<ChitietHoadon>();
		ChitietHoaDonDAO dao = new ChitietHoaDonDAO();
		ct = dao.getByIDHD(ma);
		return ct;
	}

// lay tong tu chi tiet hoa don tu id cua hoa don da biet
	public double getTotalByIDKH(int ma) {
		
		ArrayList<ChitietHoadon> chitiet = new ArrayList<ChitietHoadon>();
		double total = 0;
		ChitietHoaDonDAO dao = new ChitietHoaDonDAO();
		chitiet = dao.getByIDHD(ma);
		if (chitiet.size() > 0) {

			for (int i = 0; i < chitiet.size(); i++) {
				total += (chitiet.get(i).getGia() * chitiet.get(i).getSoluong());
			}

		} else {
			System.out.println("Khong ton tai");
		}
		System.out.println(total);
		return total;
	}

	public int getAmountByIDKH(int ma) {
		ArrayList<ChitietHoadon> chitietHD = new ArrayList<ChitietHoadon>();
		
		int total = 0;
		ChitietHoaDonDAO dao = new ChitietHoaDonDAO();
		chitietHD = dao.getByIDHD(ma);
		if (chitietHD.size() > 0) {
			for (int i = 0; i < chitietHD.size(); i++) {
				total += chitietHD.get(i).getSoluong();
			}

		} else {
			System.out.println("Khong ton tai");
		}
		System.out.println(total);
		return total;
	}

	// cai dat gia tri gia va so luong cho hoa don
	public Order getHDByIDKH(int ma) {
		Order hoadon = new Order();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_HOADON_BY_IDKH);
			stm.setInt(1, ma);
			ResultSet rs = stm.executeQuery();
			rs.next();
			hoadon = HoadonConverter.convert(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(hoadon.toString());
		return hoadon;
	}

	public Order setHDByIDKH(int ma) {
		Order hd = getHDByIDKH(ma);
		int amount = getAmountByIDKH(hd.getIdOrd());
		double total = getTotalByIDKH(hd.getIdOrd());
		hd.setTotal(total);
		hd.setAmount(amount);
		return hd;
	}
	public Order getHDByIDHD(int ma) {
		Order hoadon = new Order();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_HOADON_BY_IDHD);
			stm.setInt(1, ma);
			ResultSet rs = stm.executeQuery();
			rs.next();
			hoadon = HoadonConverter.convert(rs);
			hoadon = setHDByIDKH(hoadon.getIdCust());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(hoadon.toString());
		return hoadon;
	}
	public Customer getKHByIDHD(int ma) {
		Customer cs = new Customer();
		Order hoadon = new Order();
		try {
			System.out.println("ma kh 1 "+ ma);
			PreparedStatement stm = conn.prepareStatement(Queries.GET_HOADON_BY_IDHD);
			stm.setInt(1, ma);
			ResultSet rs = stm.executeQuery();
			rs.next();
			hoadon = HoadonConverter.convert(rs);
			System.out.println(hoadon.toString()+" hoa don");
			PreparedStatement stm1 = conn.prepareStatement(Queries.GET_CUSTOMER_BY_ID);
			stm1.setInt(1, hoadon.getIdCust());
			ResultSet rs1 = stm1.executeQuery();
			rs1.next();
			cs = CustomerConverter.convert(rs1);
			System.out.println(cs.getAddress()+" dia chi");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cs.toString());
		return cs;
	}
}
