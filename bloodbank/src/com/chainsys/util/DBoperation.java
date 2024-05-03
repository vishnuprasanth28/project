package com.chainsys.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBoperation {
	 public static void readWrite(int id, String name,int age , String bloodGrp) throws SQLException, ClassNotFoundException {
	    	
	    	Connection connection = ConnectionUtil.getConnection();
	        
	        String storeDetails="insert into blood_bank values(?,?,?,?)";
	        PreparedStatement prepareStatement = connection.prepareStatement(storeDetails);
	        prepareStatement.setInt(1, id);
	        prepareStatement.setString(2, name);
	        prepareStatement.setInt(3, age);
	        prepareStatement.setString(4, bloodGrp);
	        int rows = 	prepareStatement.executeUpdate();
			 System.out.println("Added : "+rows);
		      
		    
	    
	}
	   
	    public static void updateStock(int bloodUnit,String bloodGrp) throws ClassNotFoundException, SQLException {
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
				
				 String updateStock ="update blood_stock set unit= '"+totalUnit+" ' where blood_grp= "+bloodGrp;
				 prepareStatement.setInt(1, totalUnit); prepareStatement.setString(2, bloodGrp); 
				 prepareStatement = connection.prepareStatement(updateStock);
				 
				 int row= prepareStatement.executeUpdate();
				  System.out.println("Stock updated : "+row);
				 
	    	
	    }
	    public static void updateUnit(int bloodUnit,String bloodGrp) throws ClassNotFoundException, SQLException {
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
				
				 String updateStock ="update blood_stock set unit= '"+totalUnit+" ' where blood_grp= "+bloodGrp;
				 prepareStatement.setInt(1, totalUnit); prepareStatement.setString(2, bloodGrp); 
				 prepareStatement = connection.prepareStatement(updateStock);
				 
				 int row= prepareStatement.executeUpdate();
				  System.out.println("Stock updated : "+row);
				 
	   	
	   }

}
