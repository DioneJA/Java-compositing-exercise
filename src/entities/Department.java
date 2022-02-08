package entities;

public class Department {
	private String name;

	// Getters e Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Constructor
	public Department(String name) {
		super();
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
