package ltweb.electronic_store.model;

public class Mobile extends Product {
	private Product product;
	private String frontCamera;
	private String backCamera;

	public Mobile() {
		// TODO Auto-generated constructor stub
	}

	public Mobile(int idProduct, String name, double discountedPrice, double price, int amount, String image,
			String screen, String os, String cpu, String ram, String rom, String battery, String warranty,
			String frontCamera, String backCamera, String loai) {
		super( name, discountedPrice, price, amount, image, screen, os, cpu, ram, rom, battery, warranty,loai);
		this.frontCamera = frontCamera;
		this.backCamera = backCamera;

	}
	public Mobile(Product product,String frontCamera, String backCamera) {
		super(product.getName(),product.getDiscountedPrice(), product.getPrice(), product.getAmount(),
				product.getImage(), product.getScreen(), product.getOs(), product.getCpu(), product.getRam(), product.getRom(), product.getBattery(),
				product.getWarranty(), product.getType());
		this.product = product;
		this.frontCamera = frontCamera;
		this.backCamera = backCamera;
	}
	public Product getProduct() {
		return product;
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

}
