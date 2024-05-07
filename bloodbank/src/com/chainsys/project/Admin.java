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
		System.out.println("Do you want add blood stock Press (y) or press any key :");
		String addStock = sc.next().toLowerCase();
		while (addStock.equals("y")) {
			System.out.println("Enter blood group :");
			String bloodType = sc.next();
			if (bloodType.matches("^(A|B|AB|O)[+-]$")) {
				System.out.println("Enter blood group in Units ");

				int unit = sc.nextInt();

				if (unit > 0) {
					dbOperation.updateStock(unit, bloodType);
					break;
				} else {
					System.out.println(" Please enter valid blood unit ");
					unit = sc.nextInt();
				}

			} else {
				System.out.println(" Please enter valid blood group ");
				addStock = sc.next().toLowerCase();

			}

			System.out.println("Do you want add more (y) or press any key :");
			addStock = sc.next().toLowerCase();
			// if(addStock)

		}
		System.out.println("Stock Updated");

	}

	public static int generateId() {
		int id = (int) (Math.random() * 10);
		return id;
	}

}
