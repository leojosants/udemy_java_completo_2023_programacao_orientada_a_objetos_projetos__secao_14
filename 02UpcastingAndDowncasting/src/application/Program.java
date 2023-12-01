package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {

		Account account = new Account(1001, "Alex", 0.0);
		BusinessAccount business_account = new BusinessAccount(generateRandomNumber(), "Maria", 0.0, 500.00);

		/*
		 * upcasting - converter um obj da subclasse para a super classe
		 */
		Account account_1 = business_account;
		Account account_2 = new BusinessAccount(generateRandomNumber(), "Bob", 0.0, 200.00);
		Account account_3 = new SavingsAccount(generateRandomNumber(), "Anna", 0.0, 0.01);

		/*
		 * downcasting - converter um obj da super classe para a subclasse
		 */
		// BusinessAccount business_account_4 = account_2; // Type mismatch: cannot
		// convert from Account to BusinessAccount
		BusinessAccount business_account_4 = (BusinessAccount) account_2;
		business_account_4.loan(100.00);

		// ocorre erro de execucao
		// BusinessAccount business_account_5 = (BusinessAccount) account_3;
		// business_account_5.loan(0);

		// verificar se obj eh uma instancia
		if (account_3 instanceof BusinessAccount) {
			BusinessAccount business_account_5 = (BusinessAccount) account_3;
			business_account_5.loan(200.00);
			System.out.println("Emprestimo realizado!");
		}

		if (account_3 instanceof SavingsAccount) {
			SavingsAccount account_5 = (SavingsAccount) account_3;
			account_5.updateBalance();
			System.out.println("Realizado update!");
		}

		System.out.println("-> fim do programa");
	}

	/*
	 * functions section
	 */
	private static int generateRandomNumber() {
		return (int) (Math.random() * 1000);
	}
}
