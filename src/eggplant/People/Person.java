 package eggplant.People;

import eggplant.People.Info.Name;
import eggplant.People.Info.Address;

abstract public class Person {

	private Name name;
	private Address address;
	private String dob;
	private String gender;
	private boolean smoker;
	
	public Person() {}
	
	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isSmoker() {
		return smoker;
	}

	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}

	public String toString() {
		String result;
		result = "";
		return result;
	}
	
}