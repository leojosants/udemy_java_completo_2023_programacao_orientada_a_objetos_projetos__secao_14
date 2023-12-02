package entities;

public class OutsorcedEmployee extends Employee {
	/*
	 * attributes section
	 */
	private Double additional_charge;

	/*
	 * constructors section
	 */
	// constructor - default
	public OutsorcedEmployee() {
		super();
	}

	// constructor - overload
	public OutsorcedEmployee(String name, Integer hours, Double value_per_hour, Double additional_charge) {
		super(name, hours, value_per_hour);
		this.setAdditionalCharge(additional_charge);
	}

	/*
	 * getters and setters section
	 */
	public Double getAdditionalCharge() {
		return this.additional_charge;
	}

	public void setAdditionalCharge(Double additional_charge) {
		this.additional_charge = additional_charge;
	}

	/*
	 * methods section
	 */
	@Override
	public Double payment() {
		return super.payment() + (this.getAdditionalCharge() * 1.1);
	}
}
