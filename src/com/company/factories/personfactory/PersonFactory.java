package com.company.factories.personfactory;

import com.company.people.customer.Customer;
import com.company.people.employee.Employee;
import com.company.people.person.Person;

public class PersonFactory {

    public static Person createPerson(String type){

        return type.equalsIgnoreCase("CUSTOMER")? new Customer(): type.equalsIgnoreCase("EMPLOYEE")? new Employee():
                null;


    }
}
