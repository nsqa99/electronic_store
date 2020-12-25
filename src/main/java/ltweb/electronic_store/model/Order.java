package ltweb.electronic_store.model;

import java.util.Date;

public class Order {
	private int idOrd;
	private int idCust;
	private Date createdDate;
	private double total;
	private Cart cart;

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int idOrd, int idCust, Date createdDate, Cart cart) {
		super();
		this.idOrd = idOrd;
		this.idCust = idCust;
		this.createdDate = createdDate;
		this.cart = cart;
	}

	public int getIdOrd() {
		return idOrd;
	}

	public void setIdOrd(int idOrd) {
		this.idOrd = idOrd;
	}

	public int getIdCust() {
		return idCust;
	}

	public void setIdCust(int idCust) {
		this.idCust = idCust;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public double getTotal() {
		return cart.getTotal();
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}
