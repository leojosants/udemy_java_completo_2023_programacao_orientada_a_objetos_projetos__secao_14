package entities;

import entities.enums.Color;

public abstract class Shape {
	/*
	 * attributes section
	 */
	private Color color;

	/*
	 * constructors section
	 */
	// constructor - default
	public Shape() {
	}

	// constructor - overload
	public Shape(Color color) {
		this.setColor(color);
	}

	/*
	 * getters and setters
	 */
	public Color getColor() {
		return this.color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	/*
	 * methods section
	 */
	public abstract double area();
}
