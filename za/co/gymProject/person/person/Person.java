package za.co.gymProject.person.person;

public abstract class Person {

	private String name;
	private String surname;
	private String address;
	private String email;
	private String dateOfBirth;
	private String idNumber;
	private int accountNumber;
	private int cellNumber;
	

	
	
	protected Person() {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.idNumber = idNumber;
		this.accountNumber = accountNumber;
		this.cellNumber = cellNumber;
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
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getCellNumber() {
		return cellNumber;
	}
	public void setCellNumber(int cellNumber) {
		this.cellNumber = cellNumber;
	}
	
	
	
	
	
	
	
	
}
