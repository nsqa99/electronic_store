package ltweb.electronic_store.contants;

public class Queries {
	public static final String GET = "SELECT * FROM ";
	public static final String DELETE = "DELETE FROM ";
	public static final String UPDATE = "UPDATE TABLE ";
	public static final String CONDITION = "WHERE ";
	public static final String AND = " AND ";
	public static final String ADD = "INSERT INTO ";
	// get all
	public static final String GET_CUSTOMER = GET + "Khach";
	public static final String GET_PRODUCT = GET + "Sanpham";
	public static final String GET_ORDER = GET + "Hoadon";
	public static final String GET_CART = GET + "Giohang";
	public static final String GET_ADMIN = GET + "Admin";
	public static final String GET_CHITIETHOADON = GET + "ChitietHD";
	public static final String GET_DETAILCART = GET + "ChitietGH";
	public static final String GET_RATING = GET + "Danhgia";
	

	public static final String GET_LAPTOP = GET + "Laptop AS lt INNER JOIN Sanpham AS sp ON lt.MaSP = sp.MaSP";
	public static final String GET_MOBILE = GET + "Dienthoai AS dt INNER JOIN Sanpham AS sp ON dt.MaSP = sp.MaSP";

	// get by id
	public static final String GET_CUSTOMER_BY_ID = GET_CUSTOMER + " " + CONDITION + "MaKhach = ?";
	public static final String GET_PRODUCT_BY_ID = GET_PRODUCT + " " + CONDITION + "MaSP = ?";
	public static final String GET_LAPTOP_BY_ID = GET_LAPTOP + " " + CONDITION + "sp.MaSP = ?";
	public static final String GET_MOBILE_BY_ID = GET_MOBILE + " " + CONDITION + "sp.MaSP = ?";
	public static final String GET_ORDER_BY_ID = GET_ORDER + " " + CONDITION + "MaHD = ?";
	public static final String GET_HOADON_BY_IDHD = GET_ORDER + " " + CONDITION + "MaHD = ?";
	public static final String GET_HOADON_BY_IDKH = GET_ORDER + " " + CONDITION + "MaKH = ?";
	public static final String GET_RATING_BY_ID = GET_RATING + " " + CONDITION + "MaKH = ?" + AND + "MaSP = ?" ;
	public static final String GET_RATING_BY_IDSP = GET_RATING + " " + CONDITION + "MaSP = ?" ;

	public static final String GET_CART_BY_ID = GET_CART + " " + CONDITION + "MaKH = ?";
	public static final String GET_CHITIETHOADON_BY_IDHD = GET_CHITIETHOADON + " " + CONDITION + "MaHD = ?";
	public static final String GET_DETAILCART_BY_IDGH = GET_DETAILCART + " " + CONDITION + "MaGH = ?";
	
	//insert
		public static final String INSERT_HOADON = "insert Hoadon (MaKH, Ngaylap) values"+"(?, ?)";
		public static final String INSERT_DETAIL_ORDER = "insert ChitietHD (MaHD, MaSP, TenSP, Soluong,Gia) values"+"(?,?,?,?,?)";
		public static final String INSERT_RATING = "insert Danhgia values"+"(?, ?, ?,?)";
	

	public static final String GET_ONE_PRODUCT_BY_NAME = GET_PRODUCT + " " + CONDITION + "TenSP = ?";
	// search product by name
	public static final String GET_PRODUCT_BY_NAME = GET_PRODUCT + " " + CONDITION + "TenSP LIKE ?";
	public static final String ADD_CUSTOMER = ADD + "Khach VALUES (null,?, ?, ?, ?, ?, ?,null)";

	public static final String ADD_PRODUCT = ADD
			+ "Sanpham (MaSP,TenSP,Giadagiam,Giaban,Soluong,Hinhanh,Manhinh,HDH,CPU,RAM,ROM,Pin,BaoHanh) VALUES(null, ?, ? , ? , ? , ?, ?, ?, ?, ?, ?, ?, ? )";
	public static final String ADD_LAPTOP = ADD + "Laptop VALUES(?, ?, ?)";
	public static final String ADD_MOIBLE = ADD + "Dienthoai VALUES(?, ?, ?)";
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

	// delete by id
	public static final String DELETE_ADMIN_BY_ID = DELETE + "Admin " + CONDITION + "MaAdmin = ?";
	
	//update
	public static final String UPDATE_RATING =   "update Danhgia set Star = ?,Danhgia= ? where MaKH = ? and MaSP = ? ;" ;
			

	public static final String GET_CUSTOMER_BY_USN = GET_CUSTOMER + " " + CONDITION + "Tendangnhap = ? AND Matkhau = ?";
}
