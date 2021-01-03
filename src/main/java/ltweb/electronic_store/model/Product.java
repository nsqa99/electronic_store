package ltweb.electronic_store.model;

public class Product {
	private int idProduct;
	private String name;
	private double discountedPrice;
	private double price;
	private int amount;
	private String image;
	private String screen;
	private String os;
	private String cpu;
	private String ram;
	private String rom;
	private String battery;
	private String warranty;

	public Product() {
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Product: { " + "id: " + idProduct + ", name: " + name + ", price: " + price + " }";
	}

	public Product(int idProduct, String name, double discountedPrice, double price, int amount, String image,
			String screen, String os, String cpu, String ram, String rom, String battery, String warranty) {
		this.idProduct = idProduct;
		this.name = name;
		this.discountedPrice = discountedPrice;
		this.price = price;
		this.amount = amount;
		this.image = image;
		this.screen = screen;
		this.os = os;
		this.cpu = cpu;
		this.ram = ram;
		this.rom = rom;
		this.battery = battery;
		this.warranty = warranty;
	}

	public Product(String name, double discountedPrice, double price, int amount, String image, String screen,
			String os, String cpu, String ram, String rom, String battery, String warranty) {

		this.name = name;
		this.discountedPrice = discountedPrice;
		this.price = price;
		this.amount = amount;
		this.image = image;
		this.screen = screen;
		this.os = os;
		this.cpu = cpu;
		this.ram = ram;
		this.rom = rom;
		this.battery = battery;
		this.warranty = warranty;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getBattery() {
		return battery;
	}

	public void setBattery(String battery) {
		this.battery = battery;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

}
