package entities;

import entities.enums.Color;

public class Circle extends Shape {
	/*
	 * attributes section
	 */
	private Double radius;
	private static final Double PI = Math.PI;

	/*
	 * constructors section
	 */
	// constructor - default
	public Circle() {
		super();
	}

	// constructor - overload
	public Circle(Color color, Double radius) {
		super(color);
		this.setRadius(radius);
	}

	/*
	 * getters and setters section
	 */
	public Double getRadius() {
		return this.radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	/*
	 * methods section
	 */
	@Override
	public final double area() {
		return PI * Math.pow(this.getRadius(), 2);
	}

}
