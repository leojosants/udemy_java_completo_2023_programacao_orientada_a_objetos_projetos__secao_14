package entities;

import entities.enums.Color;

public class Rectangle extends Shape {
	/*
	 * attributes section
	 */
	private Double width;
	private Double height;

	/*
	 * constructors section
	 */
	// constructor - default
	public Rectangle() {
		super();
	}

	// constructor - overload
	public Rectangle(Color color, Double width, Double height) {
		super(color);
		this.setWidth(width);
		this.setHeight(height);
	}

	/*
	 * getters and setters section
	 */
	public Double getWidth() {
		return this.width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	/*
	 * methods section
	 */
	@Override
	public final double area() {
		return this.getWidth() * this.getHeight();
	}

}
