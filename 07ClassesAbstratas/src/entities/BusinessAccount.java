package entities;

public class BusinessAccount extends Account {
	/*
	 * attributes section
	 */
	private Double loan_limit;

	/*
	 * constructors section
	 */
	// constructor - default
	public BusinessAccount() {
		super();
	}

	// constructor - overload
	public BusinessAccount(Integer number, String holder, Double balance, Double loan_limit) {
		super(number, holder, balance);
		this.setLoanLimit(loan_limit);
	}

	/*
	 * getters and setters section
	 */
	public Double getLoanLimit() {
		return this.loan_limit;
	}

	public void setLoanLimit(Double loan_limit) {
		this.loan_limit = loan_limit;
	}

	/*
	 * methods section
	 */
	public void loan(double amount) {
		if (amount <= this.getLoanLimit()) {
			balance += amount - 10.0;
		} else {
			System.out.println("-> valor excede limite");
		}
	}
}
