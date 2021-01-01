package ltweb.electronic_store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ltweb.electronic_store.contants.Queries;
import ltweb.electronic_store.model.Product;
import ltweb.electronic_store.utils.DBConnect;
import ltweb.electronic_store.utils.ProductConverter;

public class ProductDAO {
	private Connection conn;
	private DBConnect db = DBConnect.getInstance();

	public ProductDAO() {
		this.conn = db.getConnection();
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

}
