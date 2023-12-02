package entities;

public class IndividualTaxpayer extends Taxpayer {
	/*
	 * attributes section
	 */
	private Double health_spending;

	/*
	 * constructors section
	 */
	// constructor - default
	public IndividualTaxpayer() {
		super();
	}

	// constructor - overload
	public IndividualTaxpayer(String name, Double annual_income, Double health_spending) {
		super(name, annual_income);
		this.setHealthSpending(health_spending);
	}

	/*
	 * getters and setters section
	 */
	public Double getHealthSpending() {
		return this.health_spending;
	}

	public void setHealthSpending(Double health_spending) {
		this.health_spending = health_spending;
	}

	/*
	 * methods section
	 */
	@Override
	public double tax() {
		double tax = 0.0;

		if (this.getAnnualIncome() < 2000.00) {
			tax = this.getAnnualIncome() * 0.15 - this.getHealthSpending() * 0.5;
			return tax;
		} else {
			tax = this.getAnnualIncome() * 0.25 - this.getHealthSpending() * 0.5;
			return tax;
		}
	}

}
