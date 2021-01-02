package ltweb.electronic_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ltweb.electronic_store.contants.Queries;
import ltweb.electronic_store.model.Cart;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.model.DetailCart;
import ltweb.electronic_store.model.DetailOrdes;
import ltweb.electronic_store.model.Order;
import ltweb.electronic_store.model.Product;
import ltweb.electronic_store.utils.CartConverter;
import ltweb.electronic_store.utils.CustomerConverter;
import ltweb.electronic_store.utils.DBConnect;
import ltweb.electronic_store.utils.DetailCartConverter;
import ltweb.electronic_store.utils.OrderConverter;
import ltweb.electronic_store.utils.ProductConverter;

public class CartDAO {
	private Connection conn;
	private DBConnect db = DBConnect.getInstance();

	public CartDAO() {
		this.conn = db.getConnection();
	}
// lấy giỏ hàng dựa vào mã khách hàng -- chua có danh sách sản phẩm
	public Cart getCart(int ma) {
		Cart cart = new Cart();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_CART_BY_ID);
			stm.setInt(1, ma);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				cart = CartConverter.convert(rs);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cart;
	}
	
	// lay khach hang dua vao ma khach hang
	public Customer getCustomer(int ma) {
		Customer cus = new Customer();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_CUSTOMER_BY_ID);
			stm.setInt(1, ma);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				cus = CustomerConverter.convert(rs);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cus;
	}
	// lay danh dach chi tiet giỏ hàng theo ma giỏ hàng
	public ArrayList<DetailCart> getDetailCart(int ma) {
		Cart c = getCart(ma);
		int maGH = c.getIdCart();
		ArrayList<DetailCart> ct = new ArrayList<DetailCart>();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_DETAILCART_BY_IDGH);
			stm.setInt(1, maGH);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ct.add(DetailCartConverter.convert(rs));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ct;
	}

// lấy cac sản phẩm sản phẩm từ chi tiết giỏ hàng
	public ArrayList<Product> getProduct(int ma) {
		ArrayList<Product> sp = new ArrayList<Product>();
		ArrayList<DetailCart> chitiet = getDetailCart(ma);
		for (int i = 0; i < chitiet.size(); i++) {
			int masp = chitiet.get(i).getIdSP();
			Product pro = getProductbyID(masp);
			sp.add(pro);
		}
		return sp;
		
	}
// lấy sản phẩm từ mã sản phẩm
	public Product getProductbyID(int ma) {
		Product pro = new Product();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_PRODUCT_BY_ID);
			stm.setInt(1, ma);
			ResultSet rs = stm.executeQuery();
			rs.next();
			pro = ProductConverter.convert(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("loi nay");
		}
		
		return pro;
	}

	// cài đặt tổng tiền và tổng số lượng sản phẩm cho giỏ hàng từ mã khách hàng
	public Cart setCart(int ma) {
		Cart cart = getCart(ma);
		ArrayList<DetailCart> list = getDetailCart(ma);
		int amount = 0;
		double total = 0;
		for (int i = 0; i < list.size(); i++) {
			amount += list.get(i).getSoluong();
			total += (list.get(i).getGia()*list.get(i).getSoluong());
		}
		cart.setTotal(total);
		cart.setTotalAmount(amount);
		return cart;
	}
	// get hoa don
	public Order getOrder(int ma) {
		ArrayList<DetailCart> list = getDetailCart(ma);
		Order or = new Order();
		Cart cart = getCart(ma);
		cart = setCart(ma);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		// tạo hóa đơn 
		or = new Order(ma, dateFormat.format(date), cart.getTotal(), cart.getTotalAmount());
		return or;
		
	}
	
	// insert hóa đơn vào csdl theo mã khách hàng
	public Order createOrder(Order or) {
		ArrayList<DetailCart> list = getDetailCart(or.getIdCust());
		for (int i = 0; i < list.size(); i++) {
			System.out.println("chi tiet gio hang "+list.get(i).toString());
		}
		int x = 0;
		// insert hóa đơn vào csdl
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(Queries.INSERT_HOADON);
			preparedStatement.setInt(1, or.getIdCust());
			preparedStatement.setString(2, or.getCreatedDate());
            
            System.out.println(preparedStatement);
            
            preparedStatement.executeUpdate();
            
            System.out.println(x+ " xxxxxxxxxxx");
            System.out.println("xong roi nhá");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// lay ma hoa don vua duoc tao
		Order order = new Order();
		ArrayList<Order> listOrder = new ArrayList<>();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_ORDER);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				listOrder.add(OrderConverter.convert(rs));
			}
			
			for (int i = listOrder.size()-1; i > 0; i--) {
				if(listOrder.get(i).getCreatedDate().equals(or.getCreatedDate()) && listOrder.get(i).getIdCust() == or.getIdCust()) {
					x = listOrder.get(i).getIdOrd();
					break;
				}
			}
            System.out.println("xong roi nhá");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//insert vào chi tiết hóa đơn
		
		System.out.println("Den day nua");
		try {
			
			PreparedStatement preparedStatement1 = conn.prepareStatement(Queries.INSERT_DETAIL_ORDER);
			System.out.println("vao day");
			System.out.println(or.getIdOrd());
			for (int i = 0; i < list.size(); i++) {
				preparedStatement1.setInt(1, x);
				preparedStatement1.setInt(2, list.get(i).getIdSP());
				preparedStatement1.setString(3, list.get(i).getTenSP());
				preparedStatement1.setInt(4, list.get(i).getSoluong());
				preparedStatement1.setDouble(5, list.get(i).getGia());
				System.out.println("day thi sao");
//				preparedStatement.setInt(6, or.getIdCust());
				preparedStatement1.executeUpdate();
				System.out.println("Luu duoc rôi");
//				listDetail.add();
			}
			
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		
		return or;
	}
		
	
}
