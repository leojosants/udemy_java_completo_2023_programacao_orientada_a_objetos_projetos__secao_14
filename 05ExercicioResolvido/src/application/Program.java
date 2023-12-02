package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsorcedEmployee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = generateInstanceScanner();

		List<Employee> employee_list = new ArrayList<>();

		System.out.print("\nEntre com o número de funcionário(s) ..: ");
		int total_employee = requestTotalEmployee(scanner);

		System.out.printf("\nEntre com os dados do(s) %d funcionário(s) %n", total_employee);
		requestEmployeeData(total_employee, scanner, employee_list);

		System.out.println("Pagamentos");
		displayData(employee_list);

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

	private static int requestTotalEmployee(Scanner scanner) {
		int total_employee = 0;

		total_employee = scanner.nextInt();
		scanner.nextLine(); // buffer

		while (total_employee <= 0) {
			System.out.print(" -> campo 'Número de funcionário(s)' não pode ser menor ou igual a 0 ..: ");
			total_employee = scanner.nextInt();
			scanner.nextLine(); // buffer
		}

		return total_employee;
	}

	private static String requestOutsource(Scanner scanner) {
		String outsoursed = "";

		System.out.print(" Terceirizado? [S/N] ..: ");
		outsoursed = scanner.nextLine().toUpperCase().trim();

		while ((outsoursed.length() == 0) || ((!outsoursed.equals("S")) && (!outsoursed.equals("N")))) {
			System.out.print(" -> campo 'Terceirizado?', informe somente [S/N] ..: ");
			outsoursed = scanner.nextLine().toUpperCase().trim();
		}

		return outsoursed;
	}

	private static String requestName(Scanner scanner) {
		String name = "";

		System.out.print(" Nome ..: ");
		name = scanner.nextLine().trim();

		while (name.isEmpty()) {
			System.out.print(" -> campo 'Nome' não pode ser vazio ..: ");
			name = scanner.nextLine().trim();
		}

		return name;
	}

	private static int requestHours(Scanner scanner) {
		int hours = 0;

		System.out.print(" Horas ..: ");
		hours = scanner.nextInt();
		scanner.nextLine(); // buffer

		while (hours <= 0) {
			System.out.print(" -> campo 'Horas' não pode ser menor ou igual a 0 ..: ");
			hours = scanner.nextInt();
			scanner.nextLine(); // buffer
		}

		return hours;
	}

	private static double requestValuePerHour(Scanner scanner) {
		double value_per_hours = 0.0;

		System.out.print(" Valor por horas ..: R$ ");
		value_per_hours = scanner.nextDouble();
		scanner.nextLine(); // buffer

		while (value_per_hours <= 0.0) {
			System.out.print(" -> campo 'Valor por horas' não pode ser menor ou igual a 0.0 ..: R$ ");
			value_per_hours = scanner.nextDouble();
			scanner.nextLine(); // buffer
		}

		return value_per_hours;
	}

	private static double requestAdditionalCharge(Scanner scanner) {
		double additional_charge = 0.0;

		System.out.print(" Cobrança adicional ..: R$ ");
		additional_charge = scanner.nextDouble();
		scanner.nextLine(); // buffer

		while (additional_charge <= 0.0) {
			System.out.print(" -> campo 'Cobrança adicional' não pode ser menor ou igual a 0.0 ..: R$ ");
			additional_charge = scanner.nextDouble();
			scanner.nextLine(); // buffer
		}

		return additional_charge;
	}

	private static void requestEmployeeData(int total_employee, Scanner scanner, List<Employee> employee_list) {
		int total = total_employee;
		char outsoursed_char;

		for (int i = 1; i <= total; i++) {
			System.out.printf(" %dº Funcionário %n", i);
			String outsoursed_string = requestOutsource(scanner);
			outsoursed_char = outsoursed_string.charAt(0);
			String name = requestName(scanner);
			int hours = requestHours(scanner);
			double value_per_hour = requestValuePerHour(scanner);

			if (outsoursed_char == 'S') {
				double additional_charge = requestAdditionalCharge(scanner);
				employee_list.add(new OutsorcedEmployee(name, hours, value_per_hour, additional_charge));
				System.out.println();

			} else {
				employee_list.add(new Employee(name, hours, value_per_hour));
				System.out.println();
			}
		}
	}

	private static void displayData(List<Employee> employee_list) {
		for (Employee employee : employee_list) {
			employee.printEmployee();
		}
	}
}