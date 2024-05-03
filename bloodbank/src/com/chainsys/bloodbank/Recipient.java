package com.chainsys.bloodbank;

public class Recipient {
	int recipientId;
	String recipientName;
	String BloodGroupNeed;
	int age;
	String contact;
	public int getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getBloodGroupNeed() {
		return BloodGroupNeed;
	}
	public void setBloodGroupNeed(String bloodGroupNeed) {
		BloodGroupNeed = bloodGroupNeed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Recipient [recipientId=" + recipientId + ", recipientName=" + recipientName + ", BloodGroupNeed="
				+ BloodGroupNeed + ", age=" + age + ", contact=" + contact + "]";
	}
	public Recipient(int recipientId, String recipientName, String bloodGroupNeed, int age, String contact) {
		
		this.recipientId = recipientId;
		this.recipientName = recipientName;
		BloodGroupNeed = bloodGroupNeed;
		this.age = age;
		this.contact = contact;
	}
	public Recipient() {
		
	}
	
}
