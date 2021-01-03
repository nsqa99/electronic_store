package ltweb.electronic_store.model;

public class DetailCart {
	private int idGH;
	private int idSP;
	private String tenSP;
	private int soluong;
	private double gia;
	public DetailCart(int idGH, int idSP, String tenSP, int soluong, double gia) {
		super();
		this.idGH = idGH;
		this.idSP = idSP;
		this.tenSP = tenSP;
		this.soluong = soluong;
		this.gia = gia;
	}
	public DetailCart() {
		super();
	}
	public int getIdGH() {
		return idGH;
	}
	public void setIdGH(int idGH) {
		this.idGH = idGH;
	}
	public int getIdSP() {
		return idSP;
	}
	public void setIdSP(int idSP) {
		this.idSP = idSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public DetailCart(int idSP, String tenSP, int soluong, double gia) {
		super();
		this.idSP = idSP;
		this.tenSP = tenSP;
		this.soluong = soluong;
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "DetailCart [idGH=" + idGH + ", idSP=" + idSP + ", tenSP=" + tenSP + ", soluong=" + soluong + ", gia="
				+ gia + "]";
	}
	
}
