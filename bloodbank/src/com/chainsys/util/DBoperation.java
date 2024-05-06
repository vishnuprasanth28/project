package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.DAO.BloodBankFunctions;

public class DBoperation implements BloodBankFunctions {
	@Override
	 public void readWrite(String name,int age , String bloodGrp) throws SQLException, ClassNotFoundException {
	    	
	    	Connection connection = ConnectionUtil.getConnection();
	        
	        String storeDetails="insert into blood_bank(donor_name, age, blood_group) values(?,?,?)";
	        PreparedStatement prepareStatement = connection.prepareStatement(storeDetails);
	        prepareStatement.setString(1, name);
	        prepareStatement.setInt(2, age);
	        prepareStatement.setString(3, bloodGrp);
        int rows = 	prepareStatement.executeUpdate();
			 System.out.println("Added : "+rows);
		    
	    
	}
	   @Override
	    public void updateStock(int bloodUnit,String bloodGrp) throws ClassNotFoundException, SQLException {
	    	 int Unit ,totalUnit=0;
	    	Connection connection = ConnectionUtil.getConnection();
	    	System.out.println(bloodGrp);
	    	String checkGroup="select unit from blood_stock where blood_grp =?";   
	    	PreparedStatement prepareStatement = connection.prepareStatement(checkGroup);
	    	prepareStatement.setString(1, bloodGrp);
	    	 ResultSet resultSet = prepareStatement.executeQuery();
	    	 if(resultSet.next()) {
	    		  Unit = resultSet.getInt("unit");
	        	  totalUnit = Unit+bloodUnit;
	        	  System.out.println(totalUnit);
	    	 }
				
				 String updateStock ="update blood_stock set unit= "+totalUnit+"  where blood_grp= '"+bloodGrp+"';";
				  
				 
				 prepareStatement = connection.prepareStatement(updateStock);
				 
				 int row= prepareStatement.executeUpdate();
				  System.out.println("Stock updated : "+row);
				 
	    	
	    }
	   @Override
	    public void updateUnit(int bloodUnit,String bloodGrp) throws ClassNotFoundException, SQLException {
	   	 int Unit ,totalUnit=0;
	   	Connection connection = ConnectionUtil.getConnection();
	   	System.out.println(bloodGrp);
	   	String checkGroup="select unit from blood_stock where blood_grp =?";   
	   	PreparedStatement prepareStatement = connection.prepareStatement(checkGroup);
	   	prepareStatement.setString(1, bloodGrp);
	   	 ResultSet resultSet = prepareStatement.executeQuery();
	   	 if(resultSet.next()) {
	   		  Unit = resultSet.getInt("unit");
	       	  totalUnit = Unit-bloodUnit;
	       	  System.out.println(totalUnit);
	   	 }
				
				 String updateStock ="update blood_stock set unit= "+totalUnit+"  where blood_grp= '"+bloodGrp+"';";
				 prepareStatement.setInt(1, totalUnit); prepareStatement.setString(2, bloodGrp); 
				 prepareStatement = connection.prepareStatement(updateStock);
				 
				 int row= prepareStatement.executeUpdate();
				  System.out.println("Stock updated : "+row);
				 
	   	
	   }
	   @Override
	   public boolean donorLogin(int id,String name) throws ClassNotFoundException, SQLException {
		   Connection connection = ConnectionUtil.getConnection();
		   
		   ArrayList<String> user =new ArrayList<>();
		   
		   String checkUser="select donor_name from blood_bank where id =?";   
		   	PreparedStatement prepareStatement = connection.prepareStatement(checkUser);
			prepareStatement.setInt(1, id);
		   	 ResultSet resultSet = prepareStatement.executeQuery();
		     
		        while (resultSet.next()) {
		            String donorName = resultSet.getString("donor_name");
		            user.add(donorName);
		        }
		        if (user.contains(name)) {
		            System.out.println("welcome "+name);
		            return true;
		            
		        } else 
		             System.out.println("please register us new donor");
		        
		        	return false;
		
		   
	   }
	   public boolean adminLogin(String name, int passWord) throws ClassNotFoundException, SQLException {
		   Connection connection = ConnectionUtil.getConnection();
		   String adminName=null;
		   String checkUser="select admin from blood_stock where password =?";   
		   	PreparedStatement prepareStatement = connection.prepareStatement(checkUser);
			prepareStatement.setInt(1, passWord);
		   	 ResultSet resultSet = prepareStatement.executeQuery();
		   	 while(resultSet.next()) {
		   		  adminName =resultSet.getString("admin");
		   		 
		   	 }
		   	 if(adminName.equalsIgnoreCase(name)) {
		   		 System.out.println("welcome " +name);
		   		 return true;
		   	 }else {
		   		 System.out.println("Please tyr again...");
		   	 }
		   
		   
		   
		return false;
		   
	   }

}
