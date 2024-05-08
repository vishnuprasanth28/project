package com.chainsys.project;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.chainsys.util.DBoperation;

public class MduBranch {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, InputMismatchException {
//		MduBloodBank mduBloodBank = new MduBloodBank();
		DBoperation dbOperation = new DBoperation();
		Admin admin = new Admin();
		Scanner sc = new Scanner(System.in);
		char isAdmin = 'n';
		System.out.println("  Welcome to MDU Blood Bank  \n");
		System.out.println(" Press(y) for login as Admin --- Others please press (n)  : ");
		while (true) {
			try {
			isAdmin = sc.next().toLowerCase().charAt(0);

			switch (isAdmin) {
			case 'y':
				System.out.println("Enter user name");
				String userName = sc.next();

				System.out.println("Enter your password");
				int password = sc.nextInt();
				if (dbOperation.adminLogin(userName, password)) {
					System.out.println("Do you want add blood stock (yes / no)");
					String addStock = sc.next();
					if (addStock.equalsIgnoreCase("yes")) {

						admin.addBloodStock();
					} else {
						System.out.println(" Signed out ");
					}

				} else {
					System.out.println("Thank you");
				}

				break;
			case 'n':
				MduBloodBank.function();
				break;
			}
			}catch(NoSuchElementException e) {
				System.out.println(e);
				break;
			}

		}
	}
}
