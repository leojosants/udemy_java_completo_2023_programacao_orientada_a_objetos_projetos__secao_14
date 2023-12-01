package entities;

public class SavingsAccount extends Account {
	/*
	 * attributes section
	 */
	private Double interest_rate;

	/*
	 * constructors section
	 */
	// constructor - default
	public SavingsAccount() {
		super();
	}

	// constructor - overload
	public SavingsAccount(Integer number, String holder, Double balance, Double interest_rate) {
		super(number, holder, balance);
		this.setInterestRate(interest_rate);
	}

	/*
	 * getters and setters section
	 */
	public Double getInterestRate() {
		return this.interest_rate;
	}

	public void setInterestRate(Double interest_rate) {
		this.interest_rate = interest_rate;
	}

	/*
	 * methods section
	 */
	public void updateBalance() {
		balance += balance * this.getInterestRate();
	}
}
