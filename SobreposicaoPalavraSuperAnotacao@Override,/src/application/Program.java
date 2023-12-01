package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {

		int number_account = generateRandomNumber();
		String holder_account = "Alex";
		double balance_account = 1000.00;

		int number_savings_account = generateRandomNumber();
		String holder_savings_account = "Maria";
		double balance_savings_account = 1000.00;
		double interest_rate_savings_account = 0.01;
		
		int number_business_account = generateRandomNumber();
		String holder_business_account = "Bob";
		double balance_business_account = 1000.00;
		double loan_limit_business_account = 500.00;

		Account account_1 = generateIntanceAccount(number_account, holder_account, balance_account);
		account_1.withdraw(200.00);
		account_1.printBalance();

		Account account_2 = generateIntanceSavingsAccount(number_savings_account, holder_savings_account, balance_savings_account,
				interest_rate_savings_account);
		account_2.withdraw(200.00);
		account_2.printBalance();
		
		Account account_3 = generateIntanceBusinessAccount(number_business_account, holder_business_account, balance_business_account,
				loan_limit_business_account);
		account_3.withdraw(200.00);
		account_3.printBalance();

		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions section
	 */
	private static int generateRandomNumber() {
		return (int) (Math.random() * 1000);
	}

	private static Account generateIntanceAccount(int number, String holder, double balance) {
		Account account = new Account(number, holder, balance);
		return account;
	}

	private static SavingsAccount generateIntanceSavingsAccount(int number, String holder, double balance,
			double interest_rate) {
		SavingsAccount savings_account = new SavingsAccount(number, holder, balance, interest_rate);
		return savings_account;
	}
	
	private static BusinessAccount generateIntanceBusinessAccount(int number, String holder, double balance,
			double loan_limit) {
		BusinessAccount business_account = new BusinessAccount(number, holder, balance, loan_limit);
		return business_account;
	}
}
