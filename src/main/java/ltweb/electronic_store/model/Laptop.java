package ltweb.electronic_store.model;

public class Laptop extends Product {
	private String camera;
	private String VGA;

	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	public Laptop(int idProduct, String name, double discountedPrice, double price, int amount, String image,
			String screen, String os, String cpu, String ram, String rom, String battery, String warranty,
			String camera, String VGA) {
		super(idProduct, name, discountedPrice, price, amount, image, screen, os, cpu, ram, rom, battery, warranty);
		this.camera = camera;
		this.VGA = VGA;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getVGA() {
		return VGA;
	}

	public void setVGA(String vGA) {
		VGA = vGA;
	}

}
