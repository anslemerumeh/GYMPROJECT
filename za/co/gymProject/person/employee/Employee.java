package za.co.gymProject.person.employee;

import za.co.gymProject.person.person.Person;

public class Employee extends Person {

	
	private int employeeNumber;

	
	
	private Employee(int employeeNumber) {
		super();
		this.employeeNumber = employeeNumber;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	
	
	
}
