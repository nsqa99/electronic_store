package ltweb.electronic_store.model;

public class Rating {
//	private int idRating;
	private String content;
	private int idCust;
	private int idProduct;
	private int star;

	public Rating(String content, int idCust, int idProduct, int star) {
		super();
		this.content = content;
		this.idCust = idCust;
		this.idProduct = idProduct;
		this.star = star;
	}

	@Override
	public String toString() {
		return "Rating [ content=" + content + ", idCust=" + idCust + ", idProduct="
				+ idProduct + ", star=" + star + "]";
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public Rating() {
		// TODO Auto-generated constructor stub
	}

//	public Rating(String content, int idCust, int idProduct, int star) {
////		this.idRating = idRating;
//		this.content = content;
//		this.idCust = idCust;
//		this.idProduct = idProduct;
//		this.star = star;
//	}

//	public int getIdRating() {
//		return idRating;
//	}
//
//	public void setIdRating(int idRating) {
//		this.idRating = idRating;
//	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIdCust() {
		return idCust;
	}

	public void setIdCust(int idCust) {
		this.idCust = idCust;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

}
