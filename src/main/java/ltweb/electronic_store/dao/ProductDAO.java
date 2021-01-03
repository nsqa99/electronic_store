package ltweb.electronic_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ltweb.electronic_store.contants.Queries;
import ltweb.electronic_store.model.Laptop;
import ltweb.electronic_store.model.Mobile;
import ltweb.electronic_store.model.Product;
import ltweb.electronic_store.model.Rating;
import ltweb.electronic_store.utils.DBConnect;
import ltweb.electronic_store.utils.ProductConverter;
import ltweb.electronic_store.utils.RatingConverter;

public class ProductDAO {
	private Connection conn;
	private DBConnect db = DBConnect.getInstance();

	public ProductDAO() {
		this.conn = db.getConnection();
	}

	public ArrayList getProductByID(int id) {
		ArrayList<Laptop> laptops = new ArrayList<Laptop>();
		ArrayList<Mobile> mobiles = new ArrayList<Mobile>();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_LAPTOP_BY_ID);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				laptops.add(ProductConverter.convertLaptop(rs));
			} else {
				// System.out.println("not laptop");
				PreparedStatement stm1 = conn.prepareStatement(Queries.GET_MOBILE_BY_ID);
				stm1.setInt(1, id);
				ResultSet rs1 = stm1.executeQuery();
				if (rs1.next()) {
					// System.out.println("is mobile");
					mobiles.add(ProductConverter.convertMobile(rs1));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return laptops.size() > 0 ? laptops : mobiles.size() > 0 ? mobiles : laptops;
	}

	public Product getOneByName(String name) {
		Product p = new Product();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_ONE_PRODUCT_BY_NAME);
			stm.setString(1, name);
			ResultSet rs = stm.executeQuery();
			rs.next();
			p = ProductConverter.convert(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public int addProduct(Product p) {
		int res = 0;
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.ADD_PRODUCT);
			stm.setString(1, p.getName());
			stm.setDouble(2, p.getDiscountedPrice());
			stm.setDouble(3, p.getPrice());
			stm.setInt(4, p.getAmount());
			stm.setString(5, p.getImage());
			stm.setString(6, p.getScreen());
			stm.setString(7, p.getOs());
			stm.setString(8, p.getCpu());
			stm.setString(9, p.getRam());
			stm.setString(10, p.getRom());
			stm.setString(11, p.getBattery());
			stm.setString(12, p.getWarranty());
			res = stm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public int addLaptop(Laptop lt) {
		int res = 0;
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.ADD_LAPTOP);

			stm.setInt(1, lt.getIdProduct());
			stm.setString(2, lt.getCamera());
			stm.setString(3, lt.getVGA());
			res = stm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public int addMobile(Mobile mb) {
		int res = 0;
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.ADD_MOIBLE);

			stm.setInt(1, mb.getIdProduct());
			stm.setString(2, mb.getFrontCamera());
			stm.setString(3, mb.getBackCamera());
			res = stm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public ArrayList<Product> getAll() {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_PRODUCT);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				products.add(ProductConverter.convert(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
	}

	public ArrayList<Product> getAllPagin(int page, int size) {
		ArrayList<Product> products = new ArrayList<Product>();
		int start = (page - 1) * size;
		int end = size;

		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(Queries.GET_PRODUCT_WITH_PAGIN);
			stm.setInt(1, start);
			stm.setInt(2, end);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				products.add(ProductConverter.convert(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
	}

	public ArrayList<Product> getByName(String name) {
		ArrayList<Product> products = new ArrayList<Product>();
		// System.out.println(conn);
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_PRODUCT_BY_NAME);
			stm.setString(1, "%" + name + "%");
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				products.add(ProductConverter.convert(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
	}

	public ArrayList<Product> getByNamePagin(String name, int page, int size) {
		ArrayList<Product> products = new ArrayList<Product>();
		int start = (page - 1) * size;
		int end = size;

		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(Queries.GET_PRODUCT_BY_NAME_WITH_PAGIN);
			stm.setString(1, "%" + name + "%");
			stm.setInt(2, start);
			stm.setInt(3, end);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				products.add(ProductConverter.convert(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
	}

	public ArrayList<Product> getByType(String name, String type, int page, int size) {
		ArrayList<Product> products = new ArrayList<Product>();
		System.out.println("type " + type);
		String query = type.equals("laptop") ? Queries.GET_LAPTOP_BY_NAME_WITH_PAGIN
				: Queries.GET_MOBILE_BY_NAME_WITH_PAGIN;
		int start = (page - 1) * size;
		int end = size;

		PreparedStatement stm;
		try {
			stm = conn.prepareStatement(query);
			stm.setString(1, "%" + name + "%");
			stm.setInt(2, start);
			stm.setInt(3, end);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				products.add(type.equals("laptop") ? ProductConverter.convertLaptop(rs)
						: ProductConverter.convertMobile(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
	}

	public int getTotal() {
		int total = 0;
		try {
			ResultSet rs = conn.prepareStatement(Queries.GET_TOTAL_PRODUCT).executeQuery();
			rs.next();
			total = rs.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return total;
	}

	public int getTotalProductByName(String name, String type) {
		int total = 0;
		String query;
		if (type == null) {
			query = Queries.GET_TOTAL_PRODUCT_BY_NAME;
		} else {
			query = type.equals("laptop") ? Queries.GET_TOTAL_LAPTOP_BY_NAME : Queries.GET_TOTAL_MOBILE_BY_NAME;
		}

		try {
			PreparedStatement stm = conn.prepareStatement(query);
			stm.setString(1, "%" + name + "%");
			ResultSet rs = stm.executeQuery();
			rs.next();
			total = rs.getInt(1);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return total;
	}

	public ArrayList<Rating> getAllRating(int maSP) {
		ArrayList<Rating> list = new ArrayList<>();
		try {
			PreparedStatement stm = conn.prepareStatement(Queries.GET_RATING_BY_IDSP);
			stm.setInt(1, maSP);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				list.add(RatingConverter.convert(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
