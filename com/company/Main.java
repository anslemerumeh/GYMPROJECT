package com.company;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.company.account.Account;
import com.company.exceptions.idnumberDoesNotExist.IdNumberDoesNotExistException;
import com.company.exceptions.registrationtype.RegistrationTypeRequireException;
import com.company.people.customer.Customer;
import com.company.registrationServices.RegistrationServices;

public class Main {

	public static void main(String[] args) {
		// write your code here
		RegistrationServices registration = new RegistrationServices();
		Scanner scanner = new Scanner(System.in);
		String type = "", username = "", password = "";
		int i = 0, startDate = 0, startMonth = 0, startYear = 0, option = 0;
		long phoneNumber = 0;
		long idNumber;

		String dateOfBirth = "", fname = "", surname = "", email = "", address = "";
		outer: do {

			do {
				try {

					scanner.nextLine();
					System.out.println();
					System.out.println("================================");
					System.out.println("Press 1 to register");
					System.out.println("Press 2 to display customer information");
					System.out.println("Press 3 to proceed to package activation");
					System.out.println("Press 4 to check account status");
					System.out.println("Press 5 to extend package");
					System.out.println("Press 6 to shutdown");
					System.out.println("=================================");
					option = scanner.nextInt();
					System.out.println("-------------------------------");
					break;
				} catch (InputMismatchException ex) {
					System.out.println("Wrong input");
					System.out.println();
				}
			} while (i < 5);
			switch (option) {

			case 1:
				System.out.println();
				System.out.println("----------------------------------------");
				System.out.print("ATTENTION: ");
				System.out.println("If it is a customer  registration, enter customer as a registration type");
				System.out.println("If it is an employee registration, enter employee as a registration type");
				System.out.println("----------------------------------------");
				System.out.println();

				for (int a = 0; a < 5;) {
					try {
						scanner.nextLine();
						System.out.println("Enter registration type");
						type = scanner.nextLine();
						if (type.equalsIgnoreCase("EMPLOYEE"))
							break;
						else if (type.equalsIgnoreCase("CUSTOMER"))
							break;
						else if (type.equalsIgnoreCase(""))
							throw new RegistrationTypeRequireException();
						else
							System.out.println("Wrong input.");
					} catch (RegistrationTypeRequireException ex) {
						System.out.println(ex.getMessage());
					}
				}
				System.out.println("Enter first name");
				fname = scanner.nextLine();

				System.out.println("Enter surname");
				surname = scanner.nextLine();

				System.out.println("Enter address");
				address = scanner.nextLine();

				System.out.println("Enter email");
				email = scanner.nextLine();
				do {
					try {
						scanner.nextLine();

						System.out.println("Enter Date of birth(year-month-date)");

						dateOfBirth = scanner.nextLine();
						break;
					} catch (InputMismatchException ex) {
						System.out.println("Wrong input");
						System.out.println();
					}
				} while (i < 5);
				do {
					try {
						scanner.nextLine();
						System.out.println("Enter phone number");
						phoneNumber = scanner.nextLong();
						break;
					} catch (InputMismatchException ex) {
						System.out.println("Wrong input");
						System.out.println();
					}
				} while (i < 5);

				if (type.equalsIgnoreCase("EMPLOYEE")) {
					idNumber = 100200;
					idNumber++;
					System.out.println("Enter username");
					username = scanner.nextLine();

					System.out.println("Enter username");
					password = scanner.nextLine();
				} else {
					idNumber = 200100;
					idNumber++;
					System.out.println();
					/*
					 * System.out.println("Does the customer want to start workout now(y/n)?");
					 * String answer = scanner.nextLine(); switch (answer) { case "y":
					 */
					System.out.println("********Workout information**********");
					do {
						try {
							scanner.nextLine();
							System.out.println();
							System.out.println("Enter start date");
							startDate = scanner.nextInt();

							System.out.println("Enter start month");
							startMonth = scanner.nextInt();

							System.out.println("Enter start year");
							startYear = scanner.nextInt();
							System.out.println();
							break;
						} catch (InputMismatchException ex) {
							System.out.println("Wrong input");
							System.out.println();
						}
					} while (i < 5);
					// break;
				}

				System.out.println();
				// List<RegistrationServices> services = new ArrayList<>();
				System.out.println("ID: " + idNumber);
				registration.registration(type, fname, surname, address, email, dateOfBirth, idNumber, username,
						password, startDate, startMonth, startYear, phoneNumber);

				// break;

			case 2:
				System.out.println("************Information details**************");

				for (int a = 0; a < RegistrationServices.getPersons().size(); a++) {
					System.out.println();
					System.out
							.println("First name: " + RegistrationServices.getPersons().get(a).getName().toUpperCase());
					System.out
							.println("Surname: " + RegistrationServices.getPersons().get(a).getSurname().toUpperCase());
					System.out
							.println("Address: " + RegistrationServices.getPersons().get(a).getAddress().toUpperCase());
					System.out.println("Email: " + RegistrationServices.getPersons().get(a).getEmail());
					System.out.println("Date of birth: " + RegistrationServices.getPersons().get(a).getDateOfBirth());
					System.out.println("Cell number: " + RegistrationServices.getPersons().get(a).getCellNumber());
					System.out.println("Membership number: " + RegistrationServices.getPersons().get(a).getIdNumber());
					System.out.println("-----------------------------------------------");
				}
				break;
			case 3:

				System.out.println("*******Packages Activation**********");
				System.out.println();
				int choice = 0, n = 0;
				byte idNumberFound = 0;
				long idNo;
				do {
					try {
						scanner.nextLine();
						System.out.println("Enter Membership number");
						idNo = scanner.nextLong();
						for (int x = 0; x <= registration.getPackages().size(); x++) {
							// try {
							if (idNo == RegistrationServices.getPersons().get(x).getIdNumber()) {
								idNumberFound = 100;
							}
						}
						if (idNumberFound != 100) {
							throw new IdNumberDoesNotExistException();
						}
						System.out.println();
						System.out.println("Select package");
						for (@SuppressWarnings("rawtypes")
						Map.Entry entry : registration.membershipPackages().entrySet())
							System.out.println(entry.getKey() + " " + entry.getValue());

						System.out.println("----------------------------");
						choice = scanner.nextInt();
						System.out.println("----------------------------");
						System.out.println();

						System.out.println("Package: " + registration.activatePackages(choice, idNo));
						n++;
					} catch (IdNumberDoesNotExistException ex) {
						System.out.println(ex.getMessage());
					} catch (NullPointerException ex) {
						System.out.println();
					} catch (InputMismatchException ex) {
						System.out.println("Wrong input.");
					}
					// }
					/*
					 * }catch (NullPointerException ex){ System.out.println("Abel"); } }
					 */
					System.out.println();

				} while (n < RegistrationServices.getPersons().size());

				try {

					System.out.println("Package information");
					for (int o = 0; o < RegistrationServices.getPersons().size(); o++) {
						System.out.println(
								"NAME: " + RegistrationServices.getPersons().get(o).getSurname().toUpperCase());
						System.out.println("Start date: " + Customer.getAccounts().get(o).getStartDate().getTime());

						System.out.println("End date: " + Customer.getAccounts().get(o).getEndDate().getTime());
						System.out.println("--------------------------------------------");
						System.out.println();

					}

				} catch (NullPointerException ex) {
					System.out.println("Null pointer");
				}
				break;
			case 4:
				byte idNumberFound1 = 0;
				System.out.println("*********Account status********");
				System.out.println();
				System.out.println();
				do {
					try {
						scanner.nextLine();
						System.out.println("Enter membership number");
						long number = scanner.nextLong();
						for (int a = 0; a < RegistrationServices.getPersons().size(); a++) {
							if (number == RegistrationServices.getPersons().get(a).getIdNumber()) {
								idNumberFound1 = 100;
							}
						}
						if (idNumberFound1 != 100) {
							throw new IdNumberDoesNotExistException();

						}
						Account account = new Account();
						System.out.println("Status: " + (account.accountStatus(number)));
						System.out.println();
						if (account.accountStatus(number) == false) {
							System.out.println("Does the customer want to extend package(y/n)?");
							String button = scanner.nextLine();
							if (button.equalsIgnoreCase("Y"))
								System.out.println("choose the desired package ");
							System.out.println(registration.membershipPackages());
							int select = scanner.nextInt();
							account.extendPackage(select, number);

						} else

							System.out.println("Keep up the good workout.");
						break;
					} catch (IdNumberDoesNotExistException ex) {
						System.out.println(ex.getMessage());
					} catch (NullPointerException ex) {
						System.out.println();
					} catch (InputMismatchException ex) {
						System.out.println("Wrong input.");
					}
				} while (i < RegistrationServices.getPersons().size());
				break;

			case 5:
				int a = 0;
				byte number = 0;
				long accNum = 0;
				System.out.println("*********Account extension********");
				System.out.println();
				System.out.println();
				do {
					try {
						scanner.nextLine();
						System.out.println("Enter membership number");
						accNum = scanner.nextLong();
						for (int x = 0; x < RegistrationServices.getPersons().size(); x++) {
							if (accNum == RegistrationServices.getPersons().get(x).getIdNumber()) {
								Account account = new Account();
								System.out.println("Select package");
								System.out.println();
								for (Map.Entry<Integer, String> entry : registration.membershipPackages().entrySet())
									System.out.println(entry.getKey() + " " + " " + entry.getValue());
								System.out.println();
								int extend = scanner.nextInt();

								account.extendPackage(extend, accNum);
								System.out.println();
								System.out
										.println("End date: " + Customer.getAccounts().get(x).getStartDate().getTime());

								System.out.println("End date: " + Customer.getAccounts().get(x).getEndDate().getTime());

								number = 100;
							}
						}
						if (number != 100) {
							throw new IdNumberDoesNotExistException();

						}

					} catch (InputMismatchException ex) {
						System.out.println("Wrong input");
					} catch (IdNumberDoesNotExistException ex) {
						System.out.println(ex.getMessage());
					} catch (NullPointerException ex) {

					}
					break;
				} while (a < RegistrationServices.getPersons().size());

				break;
			case 6:
				break outer;
			}
		} while (i < 5);
	}
}
