package ltweb.electronic_store.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import ltweb.electronic_store.model.Laptop;
import ltweb.electronic_store.model.Mobile;
import ltweb.electronic_store.model.Product;

public class ProductConverter {

	public static Product convert(ResultSet rs) throws SQLException {
		int idProduct = rs.getInt("MaSP");
		String name = rs.getString("TenSP");
		double discountedPrice = rs.getDouble("Giadagiam");
		double price = rs.getDouble("Giaban");
		int amount = rs.getInt("Soluong");
		String image = rs.getString("Hinhanh");
		String screen = rs.getString("Manhinh");
		String os = rs.getString("HDH");
		String CPU = rs.getString("CPU");
		String RAM = rs.getString("RAM");
		String ROM = rs.getString("ROM");
		String battery = rs.getString("Pin");
		String warranty = rs.getString("Baohanh");

		return new Product(idProduct, name, discountedPrice, price, amount, image, screen, os, CPU, RAM, ROM, battery,
				warranty);
	}

	public static Laptop convertLaptop(ResultSet rs) throws SQLException {
		int idProduct = rs.getInt("MaSP");
		String name = rs.getString("TenSP");
		double discountedPrice = rs.getDouble("Giadagiam");
		double price = rs.getDouble("Giaban");
		int amount = rs.getInt("Soluong");
		String image = rs.getString("Hinhanh");
		String screen = rs.getString("Manhinh");
		String os = rs.getString("HDH");
		String CPU = rs.getString("CPU");
		String RAM = rs.getString("RAM");
		String ROM = rs.getString("ROM");
		String battery = rs.getString("Pin");
		String warranty = rs.getString("Baohanh");
		String camera = rs.getString("Camera");
		String vga = rs.getString("VGA");

		return new Laptop(idProduct, name, discountedPrice, price, amount, image, screen, os, CPU, RAM, ROM, battery,
				warranty, camera, vga);
	}

	public static Mobile convertMobile(ResultSet rs) throws SQLException {
		int idProduct = rs.getInt("MaSP");
		String name = rs.getString("TenSP");
		double discountedPrice = rs.getDouble("Giadagiam");
		double price = rs.getDouble("Giaban");
		int amount = rs.getInt("Soluong");
		String image = rs.getString("Hinhanh");
		String screen = rs.getString("Manhinh");
		String os = rs.getString("HDH");
		String CPU = rs.getString("CPU");
		String RAM = rs.getString("RAM");
		String ROM = rs.getString("ROM");
		String battery = rs.getString("Pin");
		String warranty = rs.getString("Baohanh");
		String frontCam = rs.getString("Camtruoc");
		String backCam = rs.getString("Camsau");

		return new Mobile(idProduct, name, discountedPrice, price, amount, image, screen, os, CPU, RAM, ROM, battery,
				warranty, frontCam, backCam);
	}

}
