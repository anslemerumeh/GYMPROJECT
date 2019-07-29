package src.com.company.people.person;

import java.util.ArrayList;
import java.util.List;

import src.com.company.account.Account;

public abstract class Person {

    private String name;
    private String surname;
    private String address;
    private String email;
    private String dateOfBirth;
    private long idNumber;
    private long cellNumber;
    private  static List<Account> accounts= new ArrayList<>();

    protected Person() {

    }

    public static List<Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(List<Account> accounts) {
        Person.accounts = accounts;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public long getCellNumber() {

        return cellNumber;
    }

    public void setCellNumber(long cellNumber) {

        this.cellNumber = cellNumber;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", address='" + address + '\''
                + ", email='" + email + '\'' + ", dateOfBirth='" + dateOfBirth + '\'' + ", idNumber='" + idNumber + '\''
                + ", cellNumber=" + cellNumber + '}';
    }
}
