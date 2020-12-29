package ltweb.electronic_store.contants;

public class Queries {
	public static final String GET = "SELECT * FROM ";
	public static final String DELETE = "DELETE FROM ";
	public static final String UPDATE = "UPDATE TABLE ";
	public static final String CONDITION = "WHERE ";
	// get all
	public static final String GET_CUSTOMER = GET + "Khach";
	public static final String GET_PRODUCT = GET + "Sanpham";
	public static final String GET_ORDER = GET + "Hoadon";
	public static final String GET_CART = GET + "Giohang";
	public static final String GET_CHITIETHOADON = GET + "ChitietHD";
	
	// get by id
	public static final String GET_CUSTOMER_BY_ID = GET_CUSTOMER + " " + CONDITION + "MaKhach = ?";
	public static final String GET_PRODUCT_BY_ID = GET_PRODUCT + " " + CONDITION + "MaSP = ?";
	public static final String GET_ORDER_BY_ID = GET_ORDER + " " + CONDITION + "MaHD = ?";
	public static final String GET_HOADON_BY_IDHD = GET_ORDER + " " + CONDITION + "MaHD = ?";
	public static final String GET_HOADON_BY_IDKH = GET_ORDER + " " + CONDITION + "MaKH = ?";
	public static final String GET_CHITIETHOADON_BY_IDHD = GET_CHITIETHOADON + " " + CONDITION + "MaHD = ?";
	

	// search product by name
	public static final String GET_PRODUCT_BY_NAME = GET_PRODUCT + " " + CONDITION + "TenSP LIKE ?";
}
