package com.chainsys.project;

public class Validation {
	
	
	public static boolean validateBlood(String bloodGroup) {
		
		return(bloodGroup.matches("^(A|B|AB|O)[+-]$"));
	}
	
	public static boolean validateName(String name) {
		return(name.matches("^[A-Za-z]+$"));
	}
	
	public static boolean validatePhoneNumber(String mobileNumber) {
		return(mobileNumber.matches("[6789]{1}[0-9]{9}"));
	}
	public static boolean validateLocation(String location) {
		return(location.matches("^[a-zA-Z\\s]+$"));
	}
}
