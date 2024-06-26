package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.chainsys.bloodbank.Donor;
import com.chainsys.dao.BloodBankFunctions;

public class DBoperation implements BloodBankFunctions {
	@Override
	public void addDonors(Donor donor) throws SQLException, ClassNotFoundException {

		Connection connection = ConnectionUtil.getConnection();

		String storeDetails = "insert into donor_list(donor_name, age, blood_group, location,mobile,donate_date) values(?,?,?,?,?,?)";
		PreparedStatement prepareStatement = connection.prepareStatement(storeDetails);
		prepareStatement.setString(1, donor.getDonorName());
		prepareStatement.setInt(2, donor.getAge());
		prepareStatement.setString(3, donor.getBloodGroup());
		prepareStatement.setString(4, donor.getLocation());
		prepareStatement.setString(5, donor.getContact());
		prepareStatement.setDate(6, new java.sql.Date( new Date().getTime()));
		
		int rows = prepareStatement.executeUpdate();
		System.out.println("Added : " + rows);

	}

	@Override
	public void updateStock(int bloodUnit, String bloodGrp) throws ClassNotFoundException, SQLException {
		int Unit, totalUnit = 0;
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(bloodGrp);
		String checkGroup = "select unit from blood_stock where blood_grp =?";
		PreparedStatement prepareStatement = connection.prepareStatement(checkGroup);
		prepareStatement.setString(1, bloodGrp);
		ResultSet resultSet = prepareStatement.executeQuery();
		if (resultSet.next()) {
			Unit = resultSet.getInt("unit");
			totalUnit = Unit + bloodUnit;
			System.out.println(totalUnit);
		}

		String updateStock = "update blood_stock set unit= " + totalUnit + "  where blood_grp= '" + bloodGrp + "';";

		prepareStatement = connection.prepareStatement(updateStock);

		int row = prepareStatement.executeUpdate();
		System.out.println("Stock updated : " + row);

	}

	@Override
	public void updateUnit(int bloodUnit, String bloodGrp) throws ClassNotFoundException, SQLException {
		int Unit, totalUnit = 0;
		Connection connection = ConnectionUtil.getConnection();
		System.out.println(bloodGrp);
		String checkGroup = "select unit from blood_stock where blood_grp =?";
		PreparedStatement prepareStatement = connection.prepareStatement(checkGroup);
		prepareStatement.setString(1, bloodGrp);
		ResultSet resultSet = prepareStatement.executeQuery();
		if (resultSet.next()) {
			Unit = resultSet.getInt("unit");
			totalUnit = Unit - bloodUnit;
			System.out.println(totalUnit);
		}

		String updateStock = "update blood_stock set unit= " + totalUnit + "  where blood_grp= '" + bloodGrp + "';";
		/*
		 * prepareStatement.setInt(1, totalUnit); prepareStatement.setString(2,
		 * bloodGrp);
		 */
		prepareStatement = connection.prepareStatement(updateStock);

		int row = prepareStatement.executeUpdate();
		System.out.println("Stock updated : " + row);

	}

	@Override
	public boolean donorLogin(int id, String name) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();

		ArrayList<String> user = new ArrayList<>();
		
		String checkUser = "select donor_name from donor_list where id =?";
		PreparedStatement prepareStatement = connection.prepareStatement(checkUser);
		prepareStatement.setInt(1, id);
		ResultSet resultSet = prepareStatement.executeQuery();
		String donorName = null;
		while (resultSet.next()) {
			donorName = resultSet.getString("donor_name");
			user.add(donorName);
		}
		if (donorName.equals(name)) {
			System.out.println("welcome " + name);
			return true;

		} else
			System.out.println("please register us new donor");

		return false;

	}

	public boolean adminLogin(String name, int passWord) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String adminName = null;
		String checkUser = "select admin from blood_stock where admin=? and password =?";
		PreparedStatement prepareStatement = connection.prepareStatement(checkUser);
		prepareStatement.setString(1, name);
		prepareStatement.setInt(2, passWord);
		ResultSet resultSet = prepareStatement.executeQuery();
		
		if (!resultSet.next()) {
			System.out.println("Please register");
			return false;
			
		} else {
			System.out.println("welcome " + name);
			return true;
		}

		

	}
	public void contactDonor(String bloodGrp) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String getDonors = "select donor_name,location,mobile from donor_list where blood_group =?";
		PreparedStatement prepareStatement = connection.prepareStatement(getDonors);
		prepareStatement.setString(1, bloodGrp);
		ResultSet resultSet = prepareStatement.executeQuery();
		ResultSetMetaData rsmd = resultSet.getMetaData();
		while(resultSet.next()) {
			for(int i=1;i<=rsmd.getColumnCount();i++) {
	    		  String value =resultSet.getString(i);
	    		  System.out.print(rsmd.getColumnName(i)+" : "+value+" ");
	    	  }
	    	  System.out.println();
			
		}
	}
/*	public void displayDonors(String bloodGrp,String location) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String checkUser = "select donor_name,mobile from donor_list where blood_group=?and location=?";
		PreparedStatement prepareStatement = connection.prepareStatement(checkUser);
		prepareStatement.setString(1, bloodGrp);
		prepareStatement.setString(2, location);
		ResultSet resultSet = prepareStatement.executeQuery();
		ResultSetMetaData rsmd = resultSet.getMetaData();
		while(resultSet.next()) {
			for(int i=1;i<=rsmd.getColumnCount();i++) {
	    		  String value =resultSet.getString(i);
	    		  System.out.print(rsmd.getColumnName(i)+" : "+value+" ");
	    	  }
	    	  System.out.println();
			
		}*/
	
	public boolean checkEligability (int id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();
		long daysInStock=0;
		String getdate = "select donate_date from donor_list where id=?";
		PreparedStatement prepareStatement = connection.prepareStatement(getdate);
		prepareStatement.setInt(1, id);
		ResultSet resultSet = prepareStatement.executeQuery();
		ResultSetMetaData rsmd = resultSet.getMetaData();
		while(resultSet.next()) {
			Date donatedDate = resultSet.getDate("donate_date");
            
            Date currentDate = new Date();
            long milliDif = currentDate.getTime() - donatedDate.getTime();
            daysInStock = TimeUnit.DAYS.convert(milliDif,TimeUnit.MILLISECONDS);
            System.out.println("you have donated "+daysInStock+" days before");
		}if(daysInStock>90) {
			return true;
		}else {
			return false;
		}
		
		
		
	}
	public void updateDate(int id) throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionUtil.getConnection();
		String getdate = " update donor_list set  donate_date=? where id=?;";
		PreparedStatement prepareStatement = connection.prepareStatement(getdate);
		prepareStatement.setDate(1, new java.sql.Date( new Date().getTime()));
		prepareStatement.setInt(2, id);
		int row = prepareStatement.executeUpdate();
		System.out.println(" Date has been updated "+row+" changes made.");
	}
	}


