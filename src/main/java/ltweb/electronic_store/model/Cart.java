package ltweb.electronic_store.model;

import java.util.ArrayList;

public class Cart {

	private int idCart;
	private int idCust;
	private ArrayList<Product> products;
	private String address;
	private String phone;
	private double total;
	private int totalAmount;

	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public Cart(int idCart, int idCust, ArrayList<Product> products, String address, String phone) {

		this.idCart = idCart;
		this.idCust = idCust;
		this.products = products;
		this.address = address;
		this.phone = phone;
	}

	public double getTotal() {
		for (Product product : products) {
			total += product.getDiscountedPrice();
		}
		return total;
	}

	public int getTotalAmount() {
		for (Product product : products) {
			totalAmount += product.getAmount();
		}
		return totalAmount;
	}

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public int getIdCust() {
		return idCust;
	}

	public void setIdCust(int idCust) {
		this.idCust = idCust;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
