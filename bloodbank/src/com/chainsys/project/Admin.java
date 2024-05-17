package com.chainsys.project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.chainsys.util.DBoperation;

public class Admin {
	DBoperation dbOperation = new DBoperation();

	public void addBloodStock() throws ClassNotFoundException, SQLException {
	    Scanner sc = new Scanner(System.in);
	    String addStock;

	    do {
	        System.out.println("Press (Y) to add Stock");
	        addStock = sc.next().toLowerCase();

	        if (addStock.equals("y")) {
	            System.out.println("Enter blood group :");
	            String bloodType = sc.next();
	            if (bloodType.matches("^(A|B|AB|O)[+-]$")) {
	                System.out.println("Enter blood group in Units ");
	                int unit = sc.nextInt();
	                if (unit > 0) {
	                    dbOperation.updateStock(unit, bloodType);
	                } else {
	                    System.out.println(" Please enter valid blood unit ");
	                }
	            } else {
	                System.out.println(" Please enter valid blood group ");
	            }
	        } else {
	            System.out.println("Invalid input. Exiting...");
	        }

	    } while (addStock.equals("y"));

	    System.out.println("Stock Updated");
	}


	public static int generateId() {
		int id = (int) (Math.random() * 10);
		return id;
	}

}
