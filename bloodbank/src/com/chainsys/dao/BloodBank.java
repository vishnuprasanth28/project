package com.chainsys.dao;

public class BloodBank   {
	
	public void donateBlood(String donorName) {
		System.out.println(donorName+" thanks for donating blood");
		
	}
	
	public void donateBlood(int id,String name,String bloodGrp,boolean isDrinked,String contact)
	{
		System.out.println(name+" thanks for donating blood");
		System.out.println();
		System.out.println("Eat fruits and drink water to replinsh blood");
	}
	public static void receiveBlood(int id,String name,String bloodGrp,String contact) {
		System.out.println(name+"we are happy to help you");
		
	}

	public static void receiveBlood(String recipientName) {
		System.out.println(recipientName+" thanks for reaching out");
		
	}
	
	public void bloodBankCamp() {
		System.out.println("  Blood donation camp has been organised on 20/5/2024 at madurai");
		System.out.println();
		System.out.println(" Save life by donating blood ");
	}
	
	public void organiseCamp() {
		System.out.println("Kindly contact our office at madurai for further Information ");
	}
	
	public void awarness() {
		System.out.println("  Government Hospitals intiated awarnress program for blood donation ");
		
	}

	
}
