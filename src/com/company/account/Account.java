package com.company.account;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.company.people.customer.Customer;
import com.company.registrationServices.RegistrationServices;

public class Account {

	private GregorianCalendar startDate;
	private GregorianCalendar endDate;
	private StringBuilder username;
	private StringBuilder password;
	private String selectedPackage;

	public Account() {

	}

	public Account(StringBuilder username, StringBuilder password) {
		this.username = username;
		this.password = password;
	}

	public Account(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	public Account(String selectedPackage) {
		this.selectedPackage = selectedPackage;
	}

	public String getSelectedPackage() {
		return selectedPackage;
	}

	public void setSelectedPackage(String selectedPackage) {
		this.selectedPackage = selectedPackage;
	}

	public StringBuilder getUsername() {
		return username;
	}

	public void setUsername(StringBuilder username) {
		this.username = username;
	}

	public StringBuilder getPassword() {
		return password;
	}

	public void setPassword(StringBuilder password) {
		this.password = password;
	}

	public GregorianCalendar getStartDate() {
		return startDate;
	}

	public void setStartDate(GregorianCalendar startDate) {
		this.startDate = startDate;
	}

	public GregorianCalendar getEndDate() {
		return endDate;
	}

	public void setEndDate(GregorianCalendar endDate) {
		this.endDate = endDate;
	}

	@SuppressWarnings("deprecation")
	public Boolean accountStatus(long idNo) {
		int a = 0;

		GregorianCalendar calendar = new GregorianCalendar();
		do {
			if (idNo == RegistrationServices.getPersons().get(a).getIdNumber()) {
				if (calendar.getTime().getDate() == Customer.getAccounts().get(a).getEndDate().getTime().getDate()
						&& calendar.getTime().getMonth() == Customer.getAccounts().get(a).getEndDate().getTime()
								.getMonth()
						&& calendar.getTime().getYear() == Customer.getAccounts().get(a).getEndDate().getTime()
								.getYear()) {
					return false;
				} else

					return true;
			}

			a++;
		} while (a < RegistrationServices.getPersons().size());

		return null;
	}

	public void extendPackage(int choice, long idNumber) {

		int a = 0;
		// Calendar date = GregorianCalendar.getInstance();
		do {
			if (idNumber == RegistrationServices.getPersons().get(a).getIdNumber()) {

				Customer.getAccounts().get(a).getEndDate().add(Calendar.MONTH, choice);

				a++;
			}

		} while (a < RegistrationServices.getPersons().size());

	}

}
