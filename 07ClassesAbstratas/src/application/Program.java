package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Account;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		exeamplo01();

		exeamplo02();

		System.out.println("-> fim do programa");
	}

	/*
	 * functions section
	 */
	private static int generateRandomNumber() {
		return (int) (Math.random() * 1000);
	}

	private static Account generateInstanceAccountSavingsAccount(int number, String holder, double balance, double interest_rate) {
		Account savings_account = new SavingsAccount(number, holder, balance, interest_rate);
		return savings_account;
	}

	private static Account generateInstanceAccountBusinessAccount(int number, String holder, double balance, double loan_limit) {
		Account business_account = new SavingsAccount(number, holder, balance, loan_limit);
		return business_account;
	}

	private static void exeamplo01() {
		// Account account_1 = new Account(1001, "Alex", 0.0); // Cannot instantiate the
		// type Account

		int number_savings_account = generateRandomNumber();
		String holder_savings_account = "Maria";
		double balance_savings_account = 1000.00;
		double interest_rate_savings_account = 0.01;

		int number_business_account = generateRandomNumber();
		String holder_business_account = "Bob";
		double balance_business_account = 1000.00;
		double interest_rate_business_account = 500.00;

		Account account_2 = generateInstanceAccountSavingsAccount(number_savings_account, holder_savings_account, balance_savings_account, interest_rate_savings_account);
		Account account_3 = generateInstanceAccountBusinessAccount(number_business_account, holder_business_account, balance_business_account, interest_rate_business_account);
	}

	private static void exeamplo02() {
		List<Account> accounts_list = new ArrayList<>();

		int number_savings_account_1 = generateRandomNumber();
		String holder_savings_account_1 = "Alex";
		double balance_savings_account_1 = 500.00;
		double interest_rate_savings_account_1 = 0.01;

		int number_savings_account_2 = generateRandomNumber();
		String holder_savings_account_2 = "Bob";
		double balance_savings_account_2 = 300.00;
		double interest_rate_savings_account_2 = 0.01;

		int number_business_account_1 = generateRandomNumber();
		String holder_business_account_1 = "Maria";
		double balance_business_account_1 = 1000.00;
		double interest_rate_business_account_1 = 400.00;

		int number_business_account_2 = generateRandomNumber();
		String holder_business_account_2 = "Ana";
		double balance_business_account_2 = 5000.00;
		double interest_rate_business_account_2 = 500.00;

		accounts_list.add(generateInstanceAccountSavingsAccount(number_savings_account_1, holder_savings_account_1, balance_savings_account_1, interest_rate_savings_account_1));
		accounts_list.add(generateInstanceAccountBusinessAccount(number_business_account_1, holder_business_account_1, balance_business_account_1, interest_rate_business_account_1));
		accounts_list.add(generateInstanceAccountSavingsAccount(number_savings_account_2, holder_savings_account_2, balance_savings_account_2, interest_rate_savings_account_2));
		accounts_list.add(generateInstanceAccountBusinessAccount(number_business_account_2, holder_business_account_2, balance_business_account_2, interest_rate_business_account_2));

		double total_balance = 0.0;

		// totalizar o saldo de todas as contas
		for (Account account : accounts_list) {
			total_balance += account.getBalance();
		}

		System.out.printf("\nSaldo total ..: R$ %.2f%n", total_balance);

		// depositar 10.00 em todas as contas
		for (Account account : accounts_list) {
			account.deposit(10.00);
		}

		for (Account account : accounts_list) {
			total_balance += account.getBalance();
			System.out.printf("Atualizado saldo para conta %d ..: R$ %.2f%n", account.getNumber(),
					account.getBalance());
		}
	}
}
