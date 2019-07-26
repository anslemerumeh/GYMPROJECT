package za.co.gymProject.person.customers;

import za.co.gymProject.person.person.Person;

public class Customer extends Person {

private int membershipNumber;




private Customer(int membershipNumber) {
	super();
	this.membershipNumber = membershipNumber;
}

public int getMembershipNumber() {
	return membershipNumber;
}

public void setMembershipNumber(int membershipNumber) {
	this.membershipNumber = membershipNumber;
}


//public void 



}
