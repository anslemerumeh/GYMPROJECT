package src.com.company.factories.personfactory;

import src.com.company.people.customer.Customer;
import src.com.company.people.employee.Employee;
import src.com.company.people.person.Person;

public class PersonFactory {

    public static Person createPerson(String type){

   return type.equalsIgnoreCase("CUSTOMER")? new Customer(): type.equalsIgnoreCase("EMPLOYEE")? new Employee():
                null;


    }
}
