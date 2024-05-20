package com.chainsys.project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.chainsys.bloodbank.Donor;
import com.chainsys.bloodbank.Person;
import com.chainsys.bloodbank.Recipient;
import com.chainsys.dao.BloodBank;
import com.chainsys.dao.InvalidAgeException;
import com.chainsys.util.DBoperation;

public class BloodBankFunction {
	public static void function() throws ClassNotFoundException, SQLException {

		DBoperation dbOperation = new DBoperation();

		TestAge testAge = new TestAge();

		Scanner sc = new Scanner(System.in);

		BloodBank bloodBank = new BloodBank();
		Donor donor = new Donor();
		Recipient recipient = new Recipient();
		List<String> bloodList = new ArrayList<>();
		bloodList.add("A+");
		bloodList.add("B+");
		bloodList.add("O+");

		System.out.println("For donate blood type-yes or type-no for receive blood");// ask user whether they want
																						// donate or receive blood

		String donate = sc.next();
		if (donate.equalsIgnoreCase("yes")) {
			System.out.println("Are you new donor");// Ask user are they donating for first time
			String isNewDonor = sc.next();
			if (isNewDonor.equalsIgnoreCase("yes")) {

				System.out.println("Enter your name");
				String newDonorName = sc.next();
//				while (true) {
//					if (newDonorName.matches("^[A-Za-z]+$")) {
//						donor.setDonorName(newDonorName);
//						break;
//					}
//					System.out.println("Enter valid name");
//					newDonorName = sc.next();
//				}
				while (!Validation.validateName(newDonorName)) {
					System.out.println("Enter valid name");
					newDonorName = sc.next();

				}
				donor.setDonorName(newDonorName);

				donor.setDonorId(Admin.generateId());// generating ID for new donors

				System.out.println("enter your blood group");
				String newDonorBlood = sc.next();

				while (!Validation.validateBlood(newDonorBlood)) {
					System.out.println("Please enter a valid blood group (A+, B-, AB+, O-, etc.).");
					newDonorBlood = sc.next();

				}
				donor.setBloodGroup(newDonorBlood);
				int age;
				while (true) {
					System.out.println("enter your age");
					age = sc.nextInt();

					try {
						testAge.validate(age);
						break;

					} catch (InvalidAgeException e) {
						System.out.println(e);
					}

				}
				donor.setAge(age);

				System.out.println("Enter your mobile number");
				String mobileNumber = sc.next();

//				while (!mobileNumber.matches("[6789]{1}[0-9]{9}")) {
//					System.err.println("Please enter a valid 10-digit mobile number.");
//					mobileNumber = sc.next();
//				}
				while (!Validation.validatePhoneNumber(mobileNumber)) {
					System.err.println("Please enter a valid 10-digit mobile number.");
					mobileNumber = sc.next();

				}
				donor.setContact(mobileNumber);

				System.out.println("Enter your city");
				String location = sc.next();

//				if (!location.matches("^[a-zA-Z\\s]+$")) {
//					System.out.println("Please enter a valid city name (alphabetic characters and spaces only).");
//					location = sc.next();
//				}
//				donor.setLocation(location);
				while (!Validation.validateLocation(location)) {
					System.out.println("Please enter a valid city name (alphabetic characters and spaces only).");
					location = sc.next();

				}
				donor.setLocation(location);

				System.out.println("Do you consume alcohol within 24 hours answer yes or no ");
				String hasConsumed = sc.next();
				if (hasConsumed.equalsIgnoreCase("yes")) {
					System.out.println("you are not allowed donate blood");
				} else if (hasConsumed.equalsIgnoreCase("no")) {
					System.out.println(donor.getDonorName() + " thank your for donating " + donor.getBloodGroup()
							+ " blood" + " your id is : " + "MDU" + donor.getDonorId());
					dbOperation.addDonors(donor);
				} else {
					System.out.println("Please enter valid answer");
					hasConsumed = sc.next();
				}

			} else {

				System.out.println("Enter your id");
				int id = sc.nextInt();
				if (id > 0) {
					donor.setDonorId(id);
				} else {
					System.out.println("please valid id");
					id = sc.nextInt();
				}
				System.out.println("enter your name");
				String name = sc.next();

				while (!Validation.validateName(name)) {
					System.out.println("Enter valid name");
					name = sc.next();

				}
				donor.setDonorName(name);

				System.out.println("enter your age");
				int age = sc.nextInt();
				if (age > 18 && age <= 50) {
					donor.setAge(age);
				} else {
					System.out.println("please enter valid age");
					age = sc.nextInt();
				}
				System.out.println("Enter your mobile number");
				String mobileNumber = sc.next();

				while (!Validation.validatePhoneNumber(mobileNumber)) {
					System.err.println("Please enter a valid 10-digit mobile number.");
					mobileNumber = sc.next();

				}
				donor.setContact(mobileNumber);

				System.out.println("enter your blood group");
				String bloodgrp = sc.next();

				while (!Validation.validateBlood(bloodgrp)) {
					System.out.println("Please enter a valid blood group (A+, B-, AB+, O-, etc.).");
					bloodgrp = sc.next();
					donor.setBloodGroup(bloodgrp);

				}

				System.out.println("Enter your city");
				String location = sc.next();

				if (!location.matches("^[a-zA-Z\\s]+$")) {
					System.out.println("Please enter a valid city name (alphabetic characters and spaces only).");
					location = sc.next();
				}

				if (dbOperation.donorLogin(donor.getDonorId(), donor.getDonorName())) {
					System.out.println("Do you consume alcohol within 24 hours answer yes or no ");
					String hasConsumed = sc.next();
					if (hasConsumed.equalsIgnoreCase("yes")) {
						System.out.println("you are not allowed donate blood");
					} else if (hasConsumed.equalsIgnoreCase("no")) {
						System.out.println("checking previous blood donated date ");
						System.out.println();
						if (dbOperation.checkEligability(id)) {
							bloodBank.donateBlood(donor.getDonorName());
							dbOperation.updateDate(donor.getDonorId());

						} else {
							System.out.println(
									" Please donate blood after completing 90 days from previous blood donation day");
						}
					} else {
						System.out.println("Please enter valid answer");
						hasConsumed = sc.next();
					}

				} else {
					System.out.println("Kindly register...");
				}
			}
		} else {
			// ask name of recipient
			System.out.println("Enter your name");
			String recieverName = sc.next();
			if (Pattern.matches("^[a-zA-Z]{3,25}", recieverName)) {
				recipient.setRecipientName(recieverName);
			} else {
				System.out.println("please enter valid name");
				recieverName = sc.next();
			}
			System.out.println("Enter your blood group you need");
			String bloodgroup = sc.next();

			while (!Validation.validateBlood(bloodgroup)) {
				System.out.println("Please enter a valid blood group (A+, B-, AB+, O-, etc.).");
				bloodgroup = sc.next();

			}
			recipient.setBloodGroupNeed(bloodgroup);
			boolean bloodGroupAvailable = false;

			for (String s : bloodList) {
				if (s.equalsIgnoreCase(recipient.getBloodGroupNeed())) {
					System.out.println("Blood group you need is available.");
					bloodGroupAvailable = true;
					System.out.println("Please mention how many units you need ");
					int bloodUnit = sc.nextInt();
					if (bloodUnit > 0 && bloodUnit < 50) {
						double payableAmount = bloodUnit * 100.0;
						System.out.println(
								"You have to pay " + payableAmount + " for " + bloodUnit + " unit(s) of blood.");
						dbOperation.updateUnit(bloodUnit, bloodgroup);
					} else {
						System.out.println("Please enter a valid unit.");
					}
					break; // No need to continue checking blood groups
				}
			}

			if (!bloodGroupAvailable) {
				System.out.println("Blood group you need is not available.");

				System.out.println("Do you want to contact a donor in person?");
				String contactDonor = sc.next();
				if (contactDonor.equalsIgnoreCase("yes")) {
					dbOperation.contactDonor(recipient.getBloodGroupNeed());
				} else {
					System.out.println("Please enter a valid answer.");
				}
			}
		}
		System.out.println("  ==========================================================  ");
		bloodBank.bloodBankCamp();
		System.out.println("Do you want organise blood camp in your location ");
		try {
			System.out.println("choice \r \n" + "y or n");
			char needCamp = sc.next().toLowerCase().charAt(0);
			if (needCamp == 'y' || needCamp == 'n') {
				switch (needCamp) {
				case 'y':
					bloodBank.organiseCamp();
					break;

				case 'n':
					System.out.println(" Encourage blood donation ");
					bloodBank.awarness();
					break;
				}
			} else {
				System.out.println("Please enter valid data");
				needCamp = sc.next().toLowerCase().charAt(0);
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
		sc.close();
	}

}

class TestAge {

	void validate(int age) throws InvalidAgeException {
		if (age < 18 && age <= 60) {

			throw new InvalidAgeException("Age Below 18 can't donate blood");
		} else {
			System.out.println("Eligible to donate blood");
		}
	}
}
