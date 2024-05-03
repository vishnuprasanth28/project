package com.chainsys.bloodbank;

public class Person {

	public Person(String personName, String bloodGroup, String contact, String location) {

		this.personName = personName;
		this.bloodGroup = bloodGroup;
		this.contact = contact;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Person [personName=" + personName + ", bloodGroup=" + bloodGroup + ", contact=" + contact
				+ ", location=" + location + "]";
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	String personName;
	String bloodGroup;
	String contact;
	String location;
	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
