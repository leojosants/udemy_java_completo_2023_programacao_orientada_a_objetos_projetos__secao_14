package entities;

public class ImportedProduct extends Product {
	/*
	 * attributes section
	 */
	private Double custms_fee;

	/*
	 * constructors section
	 */
	// constructor - default
	public ImportedProduct() {
		super();
	}

	// constructor - overload
	public ImportedProduct(String name, Double price, Double custms_fee) {
		super(name, price);
		this.setCustmsFee(custms_fee);
	}

	public Double getCustmsFee() {
		return custms_fee;
	}

	private void setCustmsFee(Double custms_fee) {
		this.custms_fee = custms_fee;
	}

	/*
	 * methods section
	 */
	@Override
	public String priceTag() {
		StringBuilder string_builder = new StringBuilder();
		string_builder.append(this.getName().concat(" "));
		string_builder.append(String.format("R$ %.2f ", this.getPrice()));
		string_builder.append(String.format("(Taxa alfandegária ..: R$ %.2f)", this.getCustmsFee()));
		return string_builder.toString();
	}

	public Double totalPrice() {
		return super.getPrice() + this.getCustmsFee();
	}
}
