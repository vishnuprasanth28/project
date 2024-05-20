package com.chainsys.dao;

import java.sql.SQLException;

import com.chainsys.bloodbank.Donor;



public interface BloodBankFunctions {
	
	
	public void addDonors(Donor donor)
			throws SQLException, ClassNotFoundException;

	public void updateStock(int bloodUnit, String bloodGrp) throws ClassNotFoundException, SQLException;

	public void updateUnit(int bloodUnit, String bloodGrp) throws ClassNotFoundException, SQLException;

	public boolean donorLogin(int id, String name) throws ClassNotFoundException, SQLException;
}
