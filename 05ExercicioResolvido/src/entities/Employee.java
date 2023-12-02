package entities;

public class Employee {
	/*
	 * attributes section
	 */
	private String name;
	private Integer hours;
	private Double value_per_hour;

	/*
	 * constructors section
	 */
	// constructor - default
	public Employee() {
	}

	// constructor - overload
	public Employee(String name, Integer hours, Double value_per_hour) {
		this.setName(name);
		this.setHours(hours);
		this.setValuePerHour(value_per_hour);
	}

	/*
	 * getters and setters section
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHours() {
		return this.hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Double getValuePerHour() {
		return this.value_per_hour;
	}

	public void setValuePerHour(Double value_per_hour) {
		this.value_per_hour = value_per_hour;
	}

	/*
	 * methods section
	 */
	public Double payment() {
		return this.getValuePerHour() * this.getHours();
	}

	public void printEmployee() {
		System.out.printf(" %s - R$ %.2f%n", this.getName(), this.payment());
	}
}
