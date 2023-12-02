package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {
	/*
	 * attributes section
	 */
	private LocalDate manufacture_date;

	/*
	 * constructors section
	 */
	// constructor - default
	public UsedProduct() {
		super();
	}

	// constructor - overload
	public UsedProduct(String name, Double price, LocalDate manufacture_date) {
		super(name, price);
		this.setManufactureDate(manufacture_date);
	}

	public LocalDate getManufactureDate() {
		return manufacture_date;
	}

	private void setManufactureDate(LocalDate manufacture_date) {
		this.manufacture_date = manufacture_date;
	}

	/*
	 * methods section
	 */
	@Override
	public String priceTag() {
		return String.format(this.getName()) + String.format(" R$ %.2f", this.getPrice())
				+ String.format(" (Data de fabricação: %s)",
						this.getManufactureDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}
}
