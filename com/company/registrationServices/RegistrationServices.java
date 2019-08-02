package com.company.registrationServices;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.company.account.Account;
import com.company.exceptions.idnumberDoesNotExist.IdNumberDoesNotExistException;
import com.company.factories.personfactory.PersonFactory;
import com.company.people.customer.Customer;
import com.company.people.employee.Employee;
import com.company.people.person.Person;

public class RegistrationServices {
	public GregorianCalendar calendar;
	private Map<Integer, String> packages = new HashMap<>();

	private static List<Person> persons = new ArrayList<>();

	public static List<Person> getPersons() {
		return persons;
	}

	public static void setPersons(List<Person> persons) {
		RegistrationServices.persons = persons;
	}

	public Set<Entry<Integer, String>> getPackages() {
		Set<Entry<Integer, String>> entry = packages.entrySet();
		return entry;
	}

	public Map<Integer, String> membershipPackages() {
		this.packages = new HashMap<>();
		this.packages.put(1, "month/R200");
		this.packages.put(2, "months/R200PM");
		this.packages.put(3, "months/R200PM");

		return packages;
	}

	public void registration(String type, String fname, String surname, String address, String email,
			String dateOfBirth, long idNumber, String username, String password, int startDate, int startMonth,
			int startYear, long cellNumber) {

		Person person = PersonFactory.createPerson(type);
		if (type.equalsIgnoreCase("CUSTOMER")) {

			calendar = new GregorianCalendar(startYear, startMonth, startDate);

			Customer.getAccounts().add(new Account(calendar));
		} else if (type.equalsIgnoreCase("EMPLOYEE")) {
			Employee.getAccounts().add(new Account(new StringBuilder(username), new StringBuilder(password)));
		}

		person.setName(fname);
		person.setSurname(surname);
		person.setDateOfBirth(dateOfBirth);
		person.setAddress(address);
		person.setCellNumber(cellNumber);
		person.setEmail(email);
		person.setIdNumber(idNumber);
		RegistrationServices.persons.add(person);

	}

	public String activatePackages(Integer choice, long idNumber) throws IdNumberDoesNotExistException {

		String selectedPackage = "";
		try {
			for (int a = 0; a < Person.getAccounts().size(); a++) {
				if (idNumber == RegistrationServices.persons.get(a).getIdNumber()) {
					for (Entry<Integer, String> entry : getPackages()) {
						if (choice == entry.getKey()) {
							selectedPackage = String.valueOf(entry.getKey()) + entry.getValue();
							Customer.getAccounts().get(a).setSelectedPackage(selectedPackage);
							// calendar.add(Calendar.MONTH, choice);
							System.out.println();
							Customer.getAccounts().get(a).getStartDate();
							Customer.getAccounts().get(a).getStartDate();
							Customer.getAccounts().get(a).getStartDate();
							Customer.getAccounts().get(a)
									.setEndDate(new GregorianCalendar(
											Customer.getAccounts().get(a).getStartDate().get(Calendar.YEAR),
											Customer.getAccounts().get(a).getStartDate().get(Calendar.MONTH),
											Customer.getAccounts().get(a).getStartDate().get(Calendar.DATE)));

							Customer.getAccounts().get(a).getEndDate().add(Calendar.MONTH, choice);

							// Customer.getAccounts().get(a).getEndDate().getTime().a;
						}

					}
				}
			}
		} catch (NullPointerException ex) {
			System.out.println("Please give few days to activate account");
		}
		return selectedPackage;
	}

}
