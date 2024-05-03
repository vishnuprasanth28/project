package com.chainsys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ConnectionUtil   {
	
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
      
      //  Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db_1", "root", "Mechatronics@1");

        return connection;
    }
   
}