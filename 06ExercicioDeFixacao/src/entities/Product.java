package entities;

public class Product {
	/*
	 * attributes section
	 */
	private String name;
	private Double price;

	/*
	 * constructors section
	 */
	// constructor - default
	public Product() {
		//
	}

	// constructor - overload
	public Product(String name, Double price) {
		this.setName(name);
		this.setPrice(price);
	}

	/*
	 * getters and setters section
	 */
	public String getName() {
		return this.name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	private void setPrice(Double price) {
		this.price = price;
	}

	public String priceTag() {
		return String.format("%s %.2f", this.getName(), this.getPrice());
	}
}
