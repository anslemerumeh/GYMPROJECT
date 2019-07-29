package com.company;

import com.company.account.Account;
import com.company.exceptions.packagedoesnotexist.PackageDoesNotExistException;
import com.company.exceptions.registrationtype.RegistrationTypeRequireException;
import com.company.people.customer.Customer;
import com.company.people.employee.Employee;
import com.company.people.person.Person;
import com.company.registrationServices.RegistrationServices;


import java.util.*;

import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        RegistrationServices registration = new RegistrationServices();
        Scanner scanner = new Scanner(System.in);
        String type = "", username = "", password = "";
        int i = 0, startDate = 0, startMonth = 0, startYear = 0;
        long idNumber = 100200;
        int hour = 0, minute = 0;
        String dateOfBirth ="", fname ="", surname ="", email ="", address="";
        outer:
        do {
            idNumber++;
            System.out.println();
            System.out.println("================================");
            System.out.println("Press 1 to register");
            System.out.println("Press 2 to display customer information");
            System.out.println("Press 3 to proceed to package activation");
            System.out.println("=================================");
            int option = scanner.nextInt();
            System.out.println("-------------------------------");
            switch (option) {

                case 1:
                    System.out.println();
                    System.out.println("----------------------------------------");
                    System.out.print("ATTENTION: ");
                    System.out.println("If it is a customer  registration, enter customer as a registration type");
                    System.out.println("If it is an employee registration, enter employee as a registration type");
                    System.out.println("----------------------------------------");
                    System.out.println();

                    for (int a = 0; a < 5; ) {
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

                    System.out.println("Enter Date of birth(date/month/year)");
                    dateOfBirth = scanner.nextLine();


                    if (type.equalsIgnoreCase("EMPLOYEE")) {
                        System.out.println("Enter username");
                        username = scanner.nextLine();

                        System.out.println("Enter username");
                        password = scanner.nextLine();
                    } else {
                        System.out.println();
                        /*System.out.println("Does the customer want to start workout now(y/n)?");
                        String answer = scanner.nextLine();
                        switch (answer) {
                            case "y":*/
                                System.out.println("********Workout information**********");
                                System.out.println();
                                System.out.println("Enter start date");
                                startDate = scanner.nextInt();

                                System.out.println("Enter start month");
                                startMonth = scanner.nextInt();

                                System.out.println("Enter start year");
                                startYear = scanner.nextInt();
                                System.out.println();

                                System.out.println("Hour");
                                hour = scanner.nextInt();

                                System.out.println("Minutes");
                                minute = scanner.nextInt();
                               // break;
                        }


                    System.out.println();
                    // List<RegistrationServices> services = new ArrayList<>();
                    System.out.println("ID: " + idNumber);
                    registration.registration(type, fname, surname, address, email,
                            dateOfBirth, idNumber, username, password, startDate,
                            startMonth, startYear, hour, minute);
                    Calendar cal = Calendar.getInstance();
                    // services.add(registration);

                   // break;

                case 2:
                    System.out.println("************Information details**************");

                    for (int a = 0; a < registration.getPersons().size(); a++) {
                        System.out.println();
                        System.out.println("First name: " + registration.getPersons().get(a).getName().toUpperCase());
                        System.out.println("Surname: " + registration.getPersons().get(a).getSurname().toUpperCase());
                        System.out.println("Address: " + registration.getPersons().get(a).getAddress().toUpperCase());
                        System.out.println("Email: " + registration.getPersons().get(a).getEmail());
                        System.out.println("Date of birth: " + registration.getPersons().get(a).getDateOfBirth());
                        System.out.println("Cell number: " + registration.getPersons().get(a).getCellNumber());
                        System.out.println("Membership number: " + registration.getPersons().get(a).getIdNumber());
                        System.out.println("-----------------------------------------------");
                    }
                    break;
                case 3:
                    break outer;
            }
        } while (i < 5);


        System.out.println("*******Packages Activation**********");
        System.out.println();
        int choice = 0, n = 0;
        long idNo;
        do {

            System.out.println("Enter Membership number");
            idNo = scanner.nextLong();
            //for (int x = 0; x < registration.getPackages().size(); x++) {
            //try {
            // if (idNo == registration.getPersons().get(x).getIdNumber()) {
            System.out.println();
            System.out.println("Select package");
            for (Map.Entry entry : registration.membershipPackages().entrySet())
                System.out.println(entry.getKey() + " " + entry.getValue());

            System.out.println("----------------------------");
            choice = scanner.nextInt();
            System.out.println("----------------------------");
            System.out.println();


            System.out.println("Package: " + registration.activatePackages(choice, idNo));
            // }
                /*}catch (NullPointerException ex){
                System.out.println("Abel");
            }
            }*/
            System.out.println();
            n++;
        } while (n < registration.getPersons().size());

        try {
            int o = 0;
            System.out.println("Package information");
            do {
                System.out.println("NAME: " + registration.getPersons().get(o).getSurname().toUpperCase());
                System.out.println("Start date: " + Customer.getAccounts().get(o).getStartDate().getHour() + ":" +
                        Customer.getAccounts().get(o).getStartDate().getMinute() + " " +
                        Customer.getAccounts().get(o).getStartDate().getDayOfWeek() + ", " + Customer.getAccounts().get(o).getStartDate().getDayOfMonth()
                        + " " + Customer.getAccounts().get(o).getStartDate().getMonth() + ", " + Customer.getAccounts().get(o).getStartDate().getYear());

                System.out.println("End date: " + +Customer.getAccounts().get(o).getEndDate().getHour() + ":" +
                        Customer.getAccounts().get(o).getEndDate().getMinute() + " " +
                        Customer.getAccounts().get(o).getEndDate().getDayOfWeek() + ", " + Customer.getAccounts().get(o).getEndDate().getDayOfMonth()
                        + " " + Customer.getAccounts().get(o).getEndDate().getMonth() + ", " + Customer.getAccounts().get(o).getEndDate().getYear());
                System.out.println("Package: " + Customer.getAccounts().get(o).getSelectedPackage());
                System.out.println("--------------------------------------------");
                System.out.println();

                o++;
            } while (o < registration.getPersons().size());
        } catch (NullPointerException ex) {
            System.out.println("Null pointer");
        }

        System.out.println("*********Account status********");
        System.out.println("Press 1 to check account status");
        System.out.println("Press 2 to shutdown");
        int option = scanner.nextInt();

        //outer:
        switch (option) {


            case 1:

                System.out.println();
                System.out.println("Enter membership number");
                long number = scanner.nextLong();

                Account account = new Account();
                System.out.println("Status: " + (account.accountStatus(number)));
                System.out.println();
                if (account.accountStatus(number)==false) {
           System.out.println("Does the customer want to extend package(y/n)?");
               String button = scanner.nextLine();
               if(button.equalsIgnoreCase("Y"))
                   System.out.println("choose the desired package ");
                   System.out.println(registration.membershipPackages());
               int select = scanner.nextInt();
               account.extendPackage(select, number);

                }else

                    System.out.println("Keep up the good workout.");
                break;
            case 2:
               // break outer;
        }
    }
}
