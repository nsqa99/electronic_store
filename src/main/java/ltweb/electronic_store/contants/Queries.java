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
	public static final String GET_CHITIETHOADON = GET + "ChitietHD";
	
	public static final String GET_LAPTOP = GET + "Laptop AS lt INNER JOIN Sanpham AS sp ON lt.MaSP = sp.MaSP";
	public static final String GET_MOBILE = GET + "Dienthoai AS dt INNER JOIN Sanpham AS sp ON dt.MaSP = sp.MaSP";

	// get by id
	public static final String GET_CUSTOMER_BY_ID = GET_CUSTOMER + " " + CONDITION + "MaKhach = ?";
	public static final String GET_PRODUCT_BY_ID = GET_PRODUCT + " " + CONDITION + "MaSP = ?";
	public static final String GET_ORDER_BY_ID = GET_ORDER + " " + CONDITION + "MaHD = ?";
	public static final String GET_HOADON_BY_IDHD = GET_ORDER + " " + CONDITION + "MaHD = ?";
	public static final String GET_HOADON_BY_IDKH = GET_ORDER + " " + CONDITION + "MaKH = ?";
	public static final String GET_CHITIETHOADON_BY_IDHD = GET_CHITIETHOADON + " " + CONDITION + "MaHD = ?";
	

	// search product by name
	public static final String GET_PRODUCT_BY_NAME = GET_PRODUCT + " " + CONDITION + "TenSP LIKE ?";
	
	// add product
	 public static final String ADD_PRODUCT = ADD + "sanpham (MaSP,TenSP,Giadagiam,Giaban,Soluong,Hinhanh,Manhinh,HDH,CPU,RAM,ROM,Pin,BaoHanh) VALUES(null, ?, ? , ? , ? , ?, ?, ?, ?, ?, ?, ?, ? )";
	 public static final String ADD_LAPTOP = ADD + "laptop (MaSP,Camera, VGA) VALUES(?, ? , ?)";
	 public static final String ADD_MOBILE = ADD + "dienthoai (MaSP,Camtruoc, Camsau) VALUES(?, ? , ?)";
	// pagin product
	public static final String GET_PRODUCT_WITH_PAGIN = GET_PRODUCT + " LIMIT ?, ?";
	public static final String GET_PRODUCT_BY_NAME_WITH_PAGIN = GET_PRODUCT + " " + CONDITION + "TenSP LIKE ? "
			+ "LIMIT ?, ?";
	public static final String GET_LAPTOP_BY_NAME_WITH_PAGIN = GET_LAPTOP + " " + CONDITION + "sp.TenSP LIKE ? "
			+ "LIMIT ?, ?";
	public static final String GET_MOBILE_BY_NAME_WITH_PAGIN = GET_MOBILE + " " + CONDITION + "sp.TenSP LIKE ? "
			+ "LIMIT ?, ?";

	public static final String GET_TOTAL_PRODUCT = "SELECT COUNT(MaSP) FROM Sanpham";

	public static final String GET_TOTAL_PRODUCT_BY_NAME = "SELECT COUNT(MaSP) AS numberOfProducts FROM Sanpham "
			+ CONDITION + "TenSP LIKE ?";
	public static final String GET_TOTAL_LAPTOP_BY_NAME = "SELECT COUNT(lt.MaSP) AS numberOfLaptops "
			+ "FROM Laptop AS lt INNER JOIN Sanpham AS sp ON lt.MaSP = sp.MaSP " + CONDITION + "sp.TenSP LIKE ?";
	public static final String GET_TOTAL_MOBILE_BY_NAME = "SELECT COUNT(dt.MaSP) AS numberOfMobiles "
			+ "FROM Dienthoai AS dt INNER JOIN Sanpham AS sp ON dt.MaSP = sp.MaSP " + CONDITION + "sp.TenSP LIKE ?";

}
