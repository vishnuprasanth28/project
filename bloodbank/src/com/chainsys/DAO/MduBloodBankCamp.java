package com.chainsys.DAO;

import com.chainsys.DAO.DonationAwarness;

public class MduBloodBankCamp extends BloodBankCamp implements DonationAwarness{
	public static void bloodBankCamp() {
		System.out.println(" MDU blood bank has organised blood donation camp on 25/4/2024 at madurai");
		System.out.println();
		System.out.println(" Save life by donating blood ");
	}
	@Override
	public void organiseCamp() {
		System.out.println("Kindly contact our MDU office at madurai for further Information ");
	}
	@Override
	public void awarness() {
		System.out.println("  Government Hospitals intiated awarnress program for blood donation ");
		
	}
}
