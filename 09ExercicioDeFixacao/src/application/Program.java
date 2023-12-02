package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CompanyTaxpayer;
import entities.IndividualTaxpayer;
import entities.Taxpayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = generateInstanceScanner();
		List<Taxpayer> taxpayers_list = generateIntanceTaxpayerList();

		System.out.print("\nEntre com o número de contribuintes ..: ");
		int number_of_taxpayer = requestNumberOfTaxpayer(scanner);

		execute(number_of_taxpayer, scanner, taxpayers_list);

		double total_of_taxes = calculateTotalOfTaxes(taxpayers_list);

		System.out.println("Impostos pagos");
		displayData(taxpayers_list, total_of_taxes);

		scanner.close();
		System.out.println("\n-> fim do programa");
	}

	/*
	 * functions section
	 */
	private static Scanner generateInstanceScanner() {
		Scanner scanner = new Scanner(System.in);
		return scanner;
	}

	private static List<Taxpayer> generateIntanceTaxpayerList() {
		List<Taxpayer> taxpayers_list = new ArrayList<>();
		return taxpayers_list;
	}

	private static Taxpayer generateInstanceTaxpayerIndividualTaxpayer(String name, Double annual_income,
			Double health_spending) {
		Taxpayer individual_taxpayer = new IndividualTaxpayer(name, annual_income, health_spending);
		return individual_taxpayer;
	}

	private static Taxpayer generateInstanceTaxpayerCompanyTaxpayer(String name, double annual_income,
			int number_of_employees) {
		Taxpayer company_taxpayer = new CompanyTaxpayer(name, annual_income, number_of_employees);
		return company_taxpayer;
	}

	private static int requestNumberOfTaxpayer(Scanner scanner) {
		int number_of_taxpayer = 0;

		// Entre com o numero de contribuintes:
		number_of_taxpayer = scanner.nextInt();
		scanner.nextLine(); // buffer

		while (number_of_taxpayer <= 0) {
			System.out.print(" -> campo 'Entre com o número de contribuintes' não pode ser menor ou igual a zero ..: ");
			number_of_taxpayer = scanner.nextInt();
			scanner.nextLine(); // buffer
		}

		return number_of_taxpayer;
	}

	private static char requestTaxpayerType(Scanner scanner) {
		char taxpayer_type_char = 0;
		String taxpayer_type_string = "";

		// Contribuinte da individual ou da Empresa? [I] ou [E]
		taxpayer_type_string = scanner.nextLine().toUpperCase().trim();

		while ((taxpayer_type_string.length() == 0)
				|| ((!taxpayer_type_string.equals("I")) && (!taxpayer_type_string.equals("E")))) {
			System.out.print(" -> campo 'Contribuinte da individual ou da Empresa?', informe somente [I] ou [E] ..: ");
			taxpayer_type_string = scanner.nextLine().toUpperCase().trim();
		}

		taxpayer_type_char = taxpayer_type_string.charAt(0);

		return taxpayer_type_char;
	}

	private static String requestName(Scanner scanner) {
		String name = "";

		// Nome
		name = scanner.nextLine().toUpperCase().trim();

		while (name.length() == 0) {
			System.out.print(" -> campo 'Nome' não pode ser vazio ..: ");
			name = scanner.nextLine().trim();
		}

		return name;
	}

	private static double requestAnnualIncome(Scanner scanner) {
		double annual_income = 0.0;

		// Rendimento anual
		annual_income = scanner.nextDouble();
		scanner.nextLine(); // buffer

		while (annual_income <= 0.0) {
			System.out.print(" -> campo 'Rendimento anual' não pode ser menor ou igual a zero ..: ");
			annual_income = scanner.nextDouble();
			scanner.nextLine(); // buffer
		}

		return annual_income;
	}

	private static double requesthealthSpending(Scanner scanner) {
		double health_spending = 0.0;

		// Despesas com saúde
		health_spending = scanner.nextDouble();
		scanner.nextLine(); // buffer

		while (health_spending <= 0.0) {
			System.out.print(" -> campo 'Despesas com saúde' não pode ser menor ou igual a zero ..: ");
			health_spending = scanner.nextDouble();
			scanner.nextLine(); // buffer
		}

		return health_spending;
	}

	private static int requestNumberOfEmployee(Scanner scanner) {
		int number_of_employees = 0;

		// Número de funcionários
		number_of_employees = scanner.nextInt();
		scanner.nextLine(); // buffer

		while (number_of_employees <= 0) {
			System.out.print(" -> campo 'Número de funcionários' não pode ser menor ou igual a zero ..: ");
			number_of_employees = scanner.nextInt();
			scanner.nextLine(); // buffer
		}

		return number_of_employees;
	}

	private static void execute(int number_of_taxpayer, Scanner scanner, List<Taxpayer> taxpayers_list) {
		System.out.printf("");

		for (int i = 1; i <= number_of_taxpayer; i++) {
			System.out.printf(" Dados do contribuinte #%d%n", i);
			System.out.print(" Contribuinte da individual ou da Empresa? [I] ou [E] ..: ");
			char taxpayer_type = requestTaxpayerType(scanner);

			System.out.print(" Nome ..: ");
			String name = requestName(scanner);

			System.out.print(" Rendimento anual ..: R$ ");
			double annual_income = requestAnnualIncome(scanner);

			if (taxpayer_type == 'I') {
				System.out.print(" Despesas com saúde ..: R$ ");
				double health_spending = requesthealthSpending(scanner);
				taxpayers_list.add(generateInstanceTaxpayerIndividualTaxpayer(name, annual_income, health_spending));
				System.out.println();
			} else if (taxpayer_type == 'E') {
				System.out.print(" Número de funcionários ..: ");
				int number_of_employees = requestNumberOfEmployee(scanner);
				taxpayers_list.add(generateInstanceTaxpayerCompanyTaxpayer(name, annual_income, number_of_employees));
				System.out.println();
			}
		}
	}

	private static double calculateTotalOfTaxes(List<Taxpayer> taxpayers_list) {
		double total_of_taxes = 0.0;

		for (Taxpayer taxpayer : taxpayers_list) {
			total_of_taxes += taxpayer.tax();
		}

		return total_of_taxes;
	}

	private static void displayData(List<Taxpayer> taxpayers_list, double total_of_taxes) {
		for (Taxpayer taxpayer : taxpayers_list) {
			System.out.printf(" %s: R$ %.2f%n", taxpayer.getName(), taxpayer.tax());
		}
		
		System.out.printf("\nImpostos totais ..: R$ %.2f%n", total_of_taxes);
	}
}
