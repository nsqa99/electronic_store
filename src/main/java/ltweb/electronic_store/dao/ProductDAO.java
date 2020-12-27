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
		ArrayList<Product> products = getAll();
		if (products.size() <= size)
			return products;
		return new ArrayList(products.subList(page - 1, page + size - 1));
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
		ArrayList<Product> products = getByName(name);
		int start = (page - 1) * size;
		int end = page * size > products.size() ? products.size() : page * size;
		if (products.size() <= size)
			return products;
		return new ArrayList(products.subList(start, end));
	}

}
