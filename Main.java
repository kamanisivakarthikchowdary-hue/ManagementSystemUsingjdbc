package org.bank.main;

import java.util.Scanner;

import org.bank.service.AdminService;
import org.bank.service.CustomerService;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		CustomerService s1= new CustomerService();
		AdminService adminService1=new AdminService();
		Scanner sc = new Scanner(System.in);


		System.err.println("---***🎇🎇🎉🎉🎊 Welcome to KarthikChowdaryBANK 🎉🎉🎉🎉🎉🎊🎊🎇🎇🎇😍----**"
				+ "");
		Thread.sleep(300);

		System.out.println("enter \n 1.for Customer Registraction \n2. forCustomer Login\n 3. for Admin login");
		int request = sc.nextInt();
		switch (request) {
		case 1:
			System.out.println("Customer Registration");
			s1.customerRegistration();
			break;
		case 2:
			System.out.println("Customer Login");
			s1.customerlogin();
			break;
		case 3:
			System.out.println("Admin login");
			adminService1.adminlogin();
			break;
		default:
			System.out.println("invalid Request");
			break;
		}
	}

}
