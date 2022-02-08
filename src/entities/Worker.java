package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private double baseSalary;

	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	// Constructor----------------------------------------------------------------------
	public Worker() {

	}

	public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	// Getters e
	// setters----------------------------------------------------------------
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	// Functions-----------------------------------------------------
	// Add contract in list
	public void addContracts(HourContract contract) {
		contracts.add(contract);
	}

	// Remove contract of list
	public void removeContracts(HourContract contract) {
		contracts.remove(contract);
	}

	// calcule salary
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar calc = Calendar.getInstance();
		for (HourContract x : contracts) {
			calc.setTime(x.getDate());
			int cYear = calc.get(Calendar.YEAR);
			int cMonth = calc.get(Calendar.MONTH) + 1;
			if (cYear == year && cMonth == month) {
				sum += x.totalValue();
			}
		}
		return sum;
	}

	// ToString
	public String toString() {
		return "Name: " + name + "\nDepartment: " + department + "\n";
	}
}
