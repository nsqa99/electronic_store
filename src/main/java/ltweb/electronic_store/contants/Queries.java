package ltweb.electronic_store.contants;

public class Queries {
	public static final String GET = "SELECT * FROM ";
	public static final String DELETE = "DELETE FROM ";
	public static final String UPDATE = "UPDATE TABLE ";
	public static final String CONDITION = "WHERE ";
	public static final String ADD = "INSERT INTO ";
	
	// get all
	public static final String GET_CUSTOMER = GET + "Khach";
	public static final String GET_PRODUCT = GET + "Sanpham";
	public static final String GET_ORDER = GET + "Hoadon";
	public static final String GET_CART = GET + "Giohang";

	// get by id
	public static final String GET_CUSTOMER_BY_ID = GET_CUSTOMER + " " + CONDITION + "MaKH = ?";
	public static final String GET_PRODUCT_BY_ID = GET_PRODUCT + " " + CONDITION + "MaSP = ?";
	public static final String GET_ORDER_BY_ID = GET_ORDER + " " + CONDITION + "MaHD = ?";
	public static final String GET_CART_BY_ID = GET_CART + " " + CONDITION + "MaGH = ?";

	// search product by name
	public static final String GET_PRODUCT_BY_NAME = GET_PRODUCT + " " + CONDITION + "TenSP LIKE ?";
	
	// add product
	 public static final String ADD_PRODUCT = ADD + "sanpham (MaSP,TenSP,Giadagiam,Giaban,Soluong,Hinhanh,Manhinh,HDH,CPU,RAM,ROM,Pin,BaoHanh) VALUES(null, ?, ? , ? , ? , ?, ?, ?, ?, ?, ?, ?, ? )";
	 public static final String ADD_LAPTOP = ADD + "laptop (MaSP,Camera, VGA) VALUES(?, ? , ?)";
	 public static final String ADD_MOBILE = ADD + "dienthoai (MaSP,Camtruoc, Camsau) VALUES(?, ? , ?)";
}
