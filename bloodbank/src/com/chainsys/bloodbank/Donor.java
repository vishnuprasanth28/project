package com.chainsys.bloodbank;

public class Donor {
	
	public Donor() {
		
	}
	
	
  
public Donor(int donorId, String donorName, String bloodGroup, String contact, boolean alcoholConsumed, int age) {
		
		this.donorId = donorId;
		this.donorName = donorName;
		this.bloodGroup = bloodGroup;
		this.contact = contact;
		this.alcoholConsumed = alcoholConsumed;
		this.age = age;
	}



@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", donorName=" + donorName + ", bloodGroup=" + bloodGroup + ", contact="
				+ contact + ", alcoholConsumed=" + alcoholConsumed + ", age=" + age + "]";
	}



public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
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
	public boolean isAlcoholConsumed() {
		return alcoholConsumed;
	}
	public void setAlcoholConsumed(boolean alcoholConsumed) {
		this.alcoholConsumed = alcoholConsumed;
	}
int donorId;
   String donorName;
   String bloodGroup;
   String contact;
   boolean alcoholConsumed;
   int age;
public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}
}
