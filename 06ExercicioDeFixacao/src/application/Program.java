package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = generateInstanceScanner();

		List<Product> product_list = generateInstanceListProduct();

		System.out.print("\nEntre com o número de produto(s) ..: ");
		int total_product = requestTotalProduct(scanner);

		System.out.printf("\nEntre com os dados do(s) %d produto(s) %n", total_product);
		requestProductData(total_product, scanner, product_list);

		System.out.println("Etiquetas de preço");
		displayData(product_list);

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

	private static List<Product> generateInstanceListProduct() {
		List<Product> product_list = new ArrayList<>();
		return product_list;
	}

	private static int requestTotalProduct(Scanner scanner) {
		int total_product = 0;

		total_product = scanner.nextInt();
		scanner.nextLine(); // buffer

		while (total_product <= 0) {
			System.out.print(" -> campo 'Número de produto(s)' não pode ser menor ou igual a 0 ..: ");
			total_product = scanner.nextInt();
			scanner.nextLine(); // buffer
		}

		return total_product;
	}

	private static String requestproductType(Scanner scanner) {
		String product_type = "";

		System.out.print(" Tipo: Comum [C], Usado [U] ou Importado [I]? [C/U/I] ..: ");
		product_type = scanner.nextLine().toUpperCase().trim();

		while ((product_type.length() == 0)
				|| ((!product_type.equals("C")) && (!product_type.equals("U") && (!product_type.equals("I"))))) {
			System.out.print(" -> campo 'Tipo: Comum [C], Usado [U] ou Importado [I]', informe somente [C/U/I] ..: ");
			product_type = scanner.nextLine().toUpperCase().trim();
		}

		return product_type;
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

	private static double requestPrice(Scanner scanner) {
		double price = 0.0;

		System.out.print(" Preço ..: R$ ");
		price = scanner.nextDouble();
		scanner.nextLine(); // buffer

		while (price <= 0.0) {
			System.out.print(" -> campo 'Preço' não pode ser menor ou igual a 0.0 ..: R$ ");
			price = scanner.nextDouble();
			scanner.nextLine(); // buffer
		}

		return price;
	}

	private static double requestcustomsFee(Scanner scanner) {
		double customs_fee = 0.0;

		System.out.print(" Taxa da alfândega ..: R$ ");
		customs_fee = scanner.nextDouble();
		scanner.nextLine(); // buffer

		while (customs_fee <= 0.0) {
			System.out.print(" -> campo 'Taxa da alfândega' não pode ser menor ou igual a 0.0 ..: R$ ");
			customs_fee = scanner.nextDouble();
			scanner.nextLine(); // buffer
		}

		return customs_fee;
	}

	private static String requestManufactureDate(Scanner scanner) {
		String manufacture_date = "";

		System.out.print(" Data de fabricação [DD/MM/AAAA] ..: ");
		manufacture_date = scanner.nextLine().trim();

		while (manufacture_date.length() == 0) {
			System.out.print(" -> Data de fabricação [DD/MM/AAAA] não pode ser vazio ..: ");
			manufacture_date = scanner.nextLine().trim();
		}

		return manufacture_date;
	}

	private static void requestProductData(int total_product, Scanner scanner, List<Product> product_list) {
		int total = total_product;
		char product_type;

		for (int i = 1; i <= total; i++) {
			System.out.printf(" %dº Produto %n", i);
			String product_type_string = requestproductType(scanner);
			product_type = product_type_string.charAt(0);
			String name = requestName(scanner);
			double price = requestPrice(scanner);

			if (product_type == 'C') {
				product_list.add(new Product(name, price));
				System.out.println();

			} else if (product_type == 'U') {
				String manufacture_date_string = requestManufactureDate(scanner);
				LocalDate manufacture_date = LocalDate.parse(manufacture_date_string,
						DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				product_list.add(new UsedProduct(name, price, manufacture_date));

			} else if (product_type == 'I') {
				double customs_fee = requestcustomsFee(scanner);
				product_list.add(new ImportedProduct(name, price, customs_fee));
				System.out.println();
			}
		}
	}

	private static void displayData(List<Product> product_list) {
		for (Product product : product_list) {
			System.out.printf(" %s%n", product.priceTag());
		}
	}
}
