package entities;

public abstract class Taxpayer {
	/*
	 * attributes section
	 */
	private String name;
	private Double annual_income;

	/*
	 * constructors section
	 */
	// constructor - default
	public Taxpayer() {
	}

	// constructor - overload
	public Taxpayer(String name, Double annual_income) {
		this.setName(name);
		this.setAnnualIncome(annual_income);
	}

	/*
	 * getters and setters section
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAnnualIncome() {
		return this.annual_income;
	}

	public void setAnnualIncome(Double annual_income) {
		this.annual_income = annual_income;
	}
	
	/*
	 * methods section
	 */
	public abstract double tax();
}
