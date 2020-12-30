package ltweb.electronic_store.model;


public class Order {
	private int idOrd;
	private int idCust;
	private String createdDate;
	private double total;
	private int amount;

	public Order() {
		// TODO Auto-generated constructor stub
	}


	public Order(int idOrd, int idCust, String createdDate, double total,int amount) {

		super();
		this.idOrd = idOrd;
		this.idCust = idCust;
		this.total = total;
		this.createdDate = createdDate;
		this.amount = amount;
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

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	
}
