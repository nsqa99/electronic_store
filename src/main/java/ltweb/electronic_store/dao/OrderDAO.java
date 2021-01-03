package ltweb.electronic_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ltweb.electronic_store.contants.Queries;
import ltweb.electronic_store.model.DetailOrdes;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.model.Order;
import ltweb.electronic_store.utils.CustomerConverter;
import ltweb.electronic_store.utils.DBConnect;
import ltweb.electronic_store.utils.DetailCartConverter;
import ltweb.electronic_store.utils.DetailOrderConverter;
import ltweb.electronic_store.utils.OrderConverter;

public class OrderDAO {
	private Connection conn;
	private DBConnect db = DBConnect.getInstance();

	public OrderDAO() {
		this.conn = db.getConnection();
	}

// tra lai danh sach cac hoa don --> cho admin su dung
	public ArrayList<Order> getAll() {
		ArrayList<Order> hoadon = new ArrayList<Order>();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_ORDER);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Order hd = OrderConverter.convert(rs);
				hd = setHDByIDKH(hd);
				hoadon.add(hd);
				System.out.println("hd "+ hd.toString());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return hoadon;
	}
	// lay danh dach chi tiet hoa don theo ma hoa don
	public ArrayList<DetailOrdes> getAllByIDHD(int ma) {
		ArrayList<DetailOrdes> ct = new ArrayList<DetailOrdes>();
		DetailOrderDAO dao = new DetailOrderDAO();
		ct = dao.getByIDHD(ma);
		return ct;
	}

// lay tong tu chi tiet hoa don tu id cua hoa don da biet
	public double getTotalByIDKH(int ma) {
		
		ArrayList<DetailOrdes> chitiet = new ArrayList<DetailOrdes>();
		double total = 0;
		DetailOrderDAO dao = new DetailOrderDAO();
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
	public ArrayList<DetailOrdes> getDetailByIDOrder(int ma) {
		DetailOrdes ct = new DetailOrdes();
		ArrayList<DetailOrdes> list = new ArrayList<DetailOrdes>();
		System.out.println("llllllll");
		
			DetailOrderDAO dao = new DetailOrderDAO();
			list = dao.getByIDHD(ma);
			System.out.println("den day chua");
		
//		System.out.println(hoadon.toString());
		return list;
	}
// lay so luong theo id hoa don
	public int getAmountByIDKH(int ma) {
		ArrayList<DetailOrdes> chitietHD = new ArrayList<DetailOrdes>();
		
		int total = 0;
		DetailOrderDAO dao = new DetailOrderDAO();
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
	public ArrayList<Order> getAllHDByIDKH(int ma) {
		ArrayList<Order> hoadon = new ArrayList<Order>();
		
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_HOADON_BY_IDKH);
			stm.setInt(1, ma);
			
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				hoadon.add(OrderConverter.convert(rs));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("danh sach hoa don cua khach hang tim duoc "+ hoadon.toString());
		return hoadon;
	}
	
	public ArrayList<DetailOrdes> getAllDetailByIDOrder(int ma) {
		DetailOrdes ct = new DetailOrdes();
		ArrayList<DetailOrdes> list = new ArrayList<DetailOrdes>();
		System.out.println("llllllll");
		ArrayList<Order> hd = getAllHDByIDKH(ma);
		ArrayList<Order> order = new ArrayList<Order>();
		for (int i = 0; i < hd.size(); i++) {
			Order m = hd.get(i);
			System.out.println(";;;;;;;;;;;;;" + m.toString());
			m = setHDByIDKH(hd.get(i).getIdCust());
			System.out.println("m o day " + m.toString());
			order.add(m);
		}
		
		for (int i = 0; i < hd.size(); i++) {
			
			ArrayList<DetailOrdes> od = getDetailByIDOrder(hd.get(i).getIdOrd());
			System.out.println("ggggggggg" + od.toString());
			for (int j = 0; j < od.size(); j++) {
				list.add(od.get(j));
				System.out.println("lít o day " + list.get(j).toString());
			}
		}
		
			
		
//		System.out.println(hoadon.toString());
		return list;
	}
	
	
	// cai dat gia tri gia va so luong cho hoa don
	public Order getHDByIDKH(int ma) {
		Order hoadon = new Order();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_HOADON_BY_IDKH);
			stm.setInt(1, ma);
			ResultSet rs = stm.executeQuery();
			rs.next();
			hoadon = OrderConverter.convert(rs);
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
	public Order setHDByIDKH(Order hd) {
//		Order hd = getHDByIDKH(ma);
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
			hoadon = OrderConverter.convert(rs);
			hoadon = setHDByIDHD(hoadon);
			System.out.println(hoadon.toString() + "hoa đon oi");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(hoadon.toString());
		return hoadon;
	}
	
	public Order setHDByIDHD(Order order) {
		ArrayList<DetailOrdes> list = new ArrayList<DetailOrdes>();
		list = getDetailByIDOrder(order.getIdOrd());
		int total = 0;
		int mount = 0;
		for (int i = 0; i < list.size(); i++) {
			mount+= list.get(i).getSoluong();
			total += (list.get(i).getSoluong()*list.get(i).getGia());
		}
		order.setAmount(mount);
		order.setTotal(total);
		return order;
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
			hoadon = OrderConverter.convert(rs);
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
	
	public ArrayList<DetailOrdes> getDetailByIDOr(int ma) {
		
		ArrayList<DetailOrdes> list = new ArrayList<DetailOrdes>();
		try {
			System.out.println("ma kh 1 "+ ma);
			PreparedStatement stm = conn.prepareStatement(Queries.GET_CHITIETHOADON_BY_IDHD);
			stm.setInt(1, ma);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				list.add(DetailOrderConverter.convert(rs));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
