package ltweb.electronic_store.model;

public class Mobile extends Product {
	private String frontCamera;
	private String backCamera;

	public Mobile() {
		// TODO Auto-generated constructor stub
	}

	public Mobile(int idProduct, String name, double discountedPrice, double price, int amount, String image,
			String screen, String os, String cpu, String ram, String rom, String battery, String warranty,
			String frontCamera, String backCamera) {
		super(idProduct, name, discountedPrice, price, amount, image, screen, os, cpu, ram, rom, battery, warranty);
		this.frontCamera = frontCamera;
		this.backCamera = backCamera;

	}

	public Mobile(String name, double discountedPrice, double price, int amount, String image, String screen, String os,
			String cpu, String ram, String rom, String battery, String warranty, String frontCamera,
			String backCamera) {
		super(name, discountedPrice, price, amount, image, screen, os, cpu, ram, rom, battery, warranty);
		this.frontCamera = frontCamera;
		this.backCamera = backCamera;

	}

	public String getFrontCamera() {
		return frontCamera;
	}

	public void setFrontCamera(String frontCamera) {
		this.frontCamera = frontCamera;
	}

	public String getBackCamera() {
		return backCamera;
	}

	public void setBackCamera(String backCamera) {
		this.backCamera = backCamera;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " Mobile: {cam truoc: " + frontCamera + "; cam sau: " + backCamera + "}";
	}

}
