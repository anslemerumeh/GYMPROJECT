package com.company.account;

import com.company.people.customer.Customer;
import com.company.people.person.Person;
import com.company.registrationServices.RegistrationServices;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.function.Predicate;

public class Account {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private StringBuilder username;
    private StringBuilder password;
    private String selectedPackage;

    public Account() {

    }

    public Account(StringBuilder username, StringBuilder password) {
        this.username = username;
        this.password = password;
    }

    public Account(LocalDateTime startDate) {
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


    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Boolean accountStatus(long idNo) {
        int a = 0;
        ZonedDateTime date = ZonedDateTime.now();
        //Calendar date = GregorianCalendar.getInstance();
        do {
            if (idNo == RegistrationServices.getPersons().get(a).getIdNumber()) {
                if (date.getMonth() == Customer.getAccounts().get(a).getStartDate().getMonth() &&
                        date.getDayOfMonth() == Customer.getAccounts().get(a).getStartDate().getDayOfMonth() &&
                        date.getYear() == Customer.getAccounts().get(a).getStartDate().getYear()){
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
        ZonedDateTime date = ZonedDateTime.now();
        //Calendar date = GregorianCalendar.getInstance();
        do {
            if (idNumber == RegistrationServices.getPersons().get(a).getIdNumber()) {

                    Customer.getAccounts().get(a).getEndDate().plusMonths(choice);

                    a++;
                }

            } while (a < RegistrationServices.getPersons().size());





    }


}
