package ltweb.electronic_store.model;

public class DetailOrdes {
	private int idHD;
	private int idSP;
	private String tenSP;
	private int soluong;
	private double gia;
	public DetailOrdes(int idHD, int idSP, String tenSP, int soluong, double gia) {
		super();
		this.idHD = idHD;
		this.idSP = idSP;
		this.tenSP = tenSP;
		this.soluong = soluong;
		this.gia = gia;
	}
	
	@Override
	public String toString() {
		return "DetailOrdes [idHD=" + idHD + ", idSP=" + idSP + ", tenSP=" + tenSP + ", soluong=" + soluong + ", gia="
				+ gia + "]";
	}

	public DetailOrdes() {
		super();
	}

	public int getIdHD() {
		return idHD;
	}
	public void setIdHD(int idHD) {
		this.idHD = idHD;
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
	
}
