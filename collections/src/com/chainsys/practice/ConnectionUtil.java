package com.chainsys.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionUtil   {
	public static void main(String[]args) throws SQLException, ClassNotFoundException {

		/*
		 * String url = "jdbc:mysql://localhost:3306/"; String userName = "root"; String
		 * passWord = "Mechatronics@1";
		 */
		Connection connection = getConnection();
		
	      
			ConnectionUtil.readWrite();
			ConnectionUtil.updateData();
      System.out.println(ConnectionUtil .getConnection());
     
	}
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
      
      //  Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db_1", "root", "Mechatronics@1");

        return connection;
    }
    public static void readWrite() throws SQLException, ClassNotFoundException {
    	
    	Connection connection = ConnectionUtil.getConnection();
        
        String store="insert into bank values('kumar','1211334090','canarabank','madurai')";
        PreparedStatement prepareStatement = connection.prepareStatement(store);
        int rows = prepareStatement.executeUpdate();
        System.out.println("Data inserted successfully");
        String query = "select account_holder_name from bank";
		 Statement st = connection.createStatement();
		 
	      ResultSet rs = st.executeQuery(query);
	      ResultSetMetaData rsmd = rs.getMetaData();
	      while(rs.next()) {
	    	  for(int i=1;i<=rsmd.getColumnCount();i++) {
	    		  String value =rs.getString(i);
	    		  System.out.print(rsmd.getColumnName(i)+" : "+value);
	    	  }
	    	  System.out.println();
    }
}
    public static void updateData() throws ClassNotFoundException, SQLException {
    	Connection connection = ConnectionUtil.getConnection();
        
        String update="update car_info set car_color ='yellow' where car_id=2";
        PreparedStatement prepareStatement = connection.prepareStatement(update);
        prepareStatement.executeUpdate();
        System.out.println("updeted successfully");
       
        String deleteData ="delete from car_info where car_id=3";
        prepareStatement =connection.prepareStatement(deleteData);
        prepareStatement.executeUpdate();
    }
}