package entities;

public class Account {
	/*
	 * attributes section
	 */
	private Integer number;
	private String holder;
	protected Double balance;

	/*
	 * constructors section
	 */
	// constructor - default
	public Account() {
	}

	// constructor - overload
	public Account(Integer number, String holder, Double balance) {
		this.setNumber(number);
		this.setHolder(holder);
		this.setBalance(balance);
	}

	/*
	 * getters and setters section
	 */
	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return this.holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return this.balance;
	}

	private void setBalance(double amount) {
		this.balance = amount;
	}

	/*
	 * methods section
	 */
	public void withdraw(double amount) {
		this.balance -= amount;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}
}
