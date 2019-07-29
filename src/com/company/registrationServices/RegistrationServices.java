package src.com.company.registrationServices;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import src.com.company.account.Account;
import src.com.company.factories.personfactory.PersonFactory;
import src.com.company.people.customer.Customer;
import src.com.company.people.employee.Employee;
import src.com.company.people.person.Person;

public class RegistrationServices {

    private Map<Integer, String> packages = new HashMap<>();
    private LocalDateTime dateStart;

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
                             String dateOfBirth, long idNumber, String username, String password
            , int startDate, int startMonth, int startYear, int hour, int minute) {

        Person person = PersonFactory.createPerson(type);
        if (type.equalsIgnoreCase("CUSTOMER")) {

            dateStart = LocalDateTime.of(startYear, startMonth, startDate, hour, minute);
            Customer.getAccounts().add(new Account(dateStart));

        } else if (type.equalsIgnoreCase("EMPLOYEE")) {
            Employee.getAccounts().add(new Account(new StringBuilder(username), new StringBuilder(password)));
        }

        person.setName(fname);
        person.setSurname(surname);
        person.setDateOfBirth(dateOfBirth);
        person.setAddress(address);
        //person.setCellNumber(cellNumber);
        person.setEmail(email);
        person.setIdNumber(idNumber);
        RegistrationServices.persons.add(person);

    }

    public String activatePackages(Integer choice, long idNumber) {

        Account account = new Account();
        String selectedPackage = "";
        outer:
        try {
            for (int a = 0; a < Person.getAccounts().size(); a++) {
                if (idNumber == this.persons.get(a).getIdNumber()) {
                    for (Entry entry : getPackages()) {
                        if (choice == entry.getKey()) {
                            selectedPackage = String.valueOf(entry.getKey()) + entry.getValue();
                            Customer.getAccounts().get(a).setSelectedPackage(selectedPackage);

                            Customer.getAccounts().get(a).setEndDate(dateStart.plusMonths(choice));
                            // Customer.getAccounts().get(a).getEndDate().plusMonths(choice);
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
