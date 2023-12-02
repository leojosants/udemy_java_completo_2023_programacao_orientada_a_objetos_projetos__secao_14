package entities;

public class CompanyTaxpayer extends Taxpayer {
	/*
	 * attributes section
	 */
	private Integer number_of_employees;

	/*
	 * constructors section
	 */
	// constructor - default
	public CompanyTaxpayer() {
		super();
	}

	// constructor - overload
	public CompanyTaxpayer(String name, Double annual_income, Integer number_of_employees) {
		super(name, annual_income);
		this.setNumberOfEmployees(number_of_employees);
	}

	/*
	 * getters and setters section
	 */
	public int getNumberOfEmployees() {
		return this.number_of_employees;
	}

	public void setNumberOfEmployees(int number_of_employees) {
		this.number_of_employees = number_of_employees;
	}

	/*
	 * methods section
	 */
	@Override
	public double tax() {
		double tax = 0.0;

		if (this.getNumberOfEmployees() > 10) {
			tax = this.getAnnualIncome() * 0.14;
			return tax;
		} else {
			tax = this.getAnnualIncome() * 0.16;
			return tax;
		}
	}

}
