package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		Scanner scanner = generateInstanceScanner();

		List<Shape> shapes_list = generateInstanceShapeList();

		System.out.print("\nEntre com o número de formas ..: ");
		int total_shapes = requestTotalShapes(scanner);

		executeData(total_shapes, scanner, shapes_list);

		System.out.println("Área(s) da(s) forma(s)");
		displayAreas(shapes_list);

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

	private static List<Shape> generateInstanceShapeList() {
		List<Shape> shapes_list = new ArrayList<>();
		return shapes_list;
	}

	private static int requestTotalShapes(Scanner scanner) {
		int total_shapes = 0;

		// Entre com o número de formas ..:
		total_shapes = scanner.nextInt();
		scanner.nextLine(); // buffer

		while (total_shapes <= 0) {
			System.out.print(" -> campo 'Entre com o número de formas' não pode ser menor ou igual a 0 ..: ");
			total_shapes = scanner.nextInt();
			scanner.nextLine(); // buffer
		}

		return total_shapes;
	}

	private static char requestShapeType(Scanner scanner) {
		char shape_type_char = 0;
		String shape_type_string = "";

		// Tipo de forma Retangulo [R] ou Círculo [C]
		shape_type_string = scanner.nextLine().toUpperCase().trim();

		while ((shape_type_string.length() == 0) || ((!shape_type_string.equals("R")) && (!shape_type_string.equals("C")))) {
			System.out.print(" -> campo 'Tipo de forma Retangulo [R] ou Círculo [C]', informe somente [R] ou [C] ..: ");
			shape_type_string = scanner.nextLine().toUpperCase().trim();
		}

		shape_type_char = shape_type_string.charAt(0);

		return shape_type_char;
	}

	private static Color requestColor(Scanner scanner) {
		String color_string = "";
		Color color;

		// Qual cor Preto, Azul ou Vermelho ..:
		color_string = scanner.nextLine().toUpperCase().trim();

		while ((color_string.length() == 0) || ((!color_string.equals("PRETO")) && (!color_string.equals("AZUL") && (!color_string.equals("VERMELHO"))))) {
			System.out.print(" -> campo 'Qual cor Preto, Azul ou Vermelho', informe somente Preto, Azul ou Vermelho ..: ");
			color_string = scanner.nextLine().toUpperCase().trim();
		}

		color = Color.valueOf(color_string);

		return color;
	}

	private static double requestWidth(Scanner scanner) {
		double width = 0.0;

		// Largura [cm] ..:
		width = scanner.nextDouble();
		scanner.nextLine(); // buffer

		while (width <= 0.0) {
			System.out.print(" -> campo 'Largura [cm]' não pode ser menor ou igual a 0.0 ..: ");
			width = scanner.nextDouble();
			scanner.nextLine(); // buffer
		}

		return width;
	}

	private static double requestHeight(Scanner scanner) {
		double height = 0.0;

		// Altura [cm] ..:
		height = scanner.nextDouble();
		scanner.nextLine(); // buffer

		while (height <= 0.0) {
			System.out.print(" -> campo 'Altura [cm]' não pode ser menor ou igual a 0.0 ..: ");
			height = scanner.nextDouble();
			scanner.nextLine(); // buffer
		}

		return height;
	}

	private static double requestRadius(Scanner scanner) {
		double radius = 0.0;

		// Raio [cm] ..:
		radius = scanner.nextDouble();
		scanner.nextLine(); // buffer

		while (radius <= 0.0) {
			System.out.print(" -> campo 'Raio [cm]' não pode ser menor ou igual a 0.0 ..: ");
			radius = scanner.nextDouble();
			scanner.nextLine(); // buffer
		}

		return radius;
	}

	private static Shape generateInstanceShapeRectangle(Color color, double width, double height) {
		Shape rectangle = new Rectangle(color, width, height);
		return rectangle;
	}

	private static Shape generateInstanceShapeCircle(Color color, double radius) {
		Shape circle = new Circle(color, radius);
		return circle;
	}

	private static void executeData(int total_shapes, Scanner scanner, List<Shape> shapes_list) {
		System.out.printf("\nEntre com os dados da(s) %d Forma(s) %n", total_shapes);

		for (int i = 1; i <= total_shapes; i++) {
			System.out.printf(" Dados da Forma #%d%n", i);

			System.out.print(" Tipo de forma Retangulo [R] ou Círculo [C] ..: ");
			char shape_type = requestShapeType(scanner);

			System.out.print(" Qual cor Preto, Azul ou Vermelho ..: ");
			Color color = requestColor(scanner);

			if (shape_type == 'R') {
				System.out.print(" Largura [cm] ..: ");
				double width = requestWidth(scanner);

				System.out.print(" Altura  [cm] ..: ");
				double height = requestHeight(scanner);

				shapes_list.add(generateInstanceShapeRectangle(color, width, height));
				System.out.println();

			} else if (shape_type == 'C') {
				System.out.print(" Raio [cm] ..: ");
				double radius = requestRadius(scanner);

				shapes_list.add(generateInstanceShapeCircle(color, radius));
				System.out.println();
			}
		}
	}

	private static void displayAreas(List<Shape> shapes_list) {
		for (Shape shape : shapes_list) {
			System.out.printf(" %.2f cm²%n", shape.area());
		}
	}
}
