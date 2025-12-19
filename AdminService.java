package org.bank.service;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.bank.dao.AdminDAO;
import org.bank.dto.CustomerDetails;

public class AdminService {
	Scanner sc=new Scanner(System.in);
	AdminDAO adminDAO=new AdminDAO();
	CustomerDetails customerDetails=new CustomerDetails();
	CustomerService customerService=new CustomerService();
	
	public void adminlogin() {
		System.out.println("enter Admin emailid");
		String emailid=sc.next();
		System.out.println("enter admin password");
		String password=sc.next();
		if(adminDAO.selectAminDetailsByUsingEmailidAndPassword(emailid, password)) {
			AdminOperation();
		}else {
			System.out.println(" invalid Emailid and password");
		}
	}
	private void AdminOperation() {
		System.out.println("Enter \n 1.for accepting or rejectiong the A/C  request"
				+ "\n 2.for Accepting or Rejecting the A/c closing Reqest");
		switch(sc.nextInt()) {
		
		case 1:
			System.out.println("Accepting Or Rejecting A/C Request");
			//********************___from the CustomerService----****************-----*********/
			List<CustomerDetails> list=customerService.getAllCustomerDetailsByUsingAccountNumberAndPin();
			int count=1;
			for(CustomerDetails customerDetails:list) {
				System.out.println("S.no:"+count++);
				System.out.println("customer Name:"+customerDetails.getCustomer_name());
				System.out.println("customer Emaild:"+customerDetails.getCustomer_email_id());
				System.out.println("customer Mobile number"+customerDetails.getCustomer_mobile_number());
				System.out.println("**-----------*****-----*********");
			}
			System.out.println("select s.no to Accept or reject the Request");
			int  adminselection=sc.nextInt()-1;
			CustomerDetails customerDetails=list.get(adminselection);
			System.out.println(customerDetails);
			System.out.println("Enter \n 1. To accept \n To reject");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("Accept");
				break;
			case 2:
				System.out.println("Reject");
				break;
				default:
					System.out.println("invalid request");
			
			}
			
			break;
		case 2:
			System.out.println(" Accepting OR Rejecting the A/c Closing ReQuest");
			break;
			default:
				System.out.println("invalid Request");
				break;
		}
	}
	public void acceptAccountRequest() {
		Random random=new Random();
		long accountnumber=random.nextInt(10000000);
		/*9999999999
		 * 555555555
		 99999999
		 10000000
		 555555
		 155555* */
		if(accountnumber<1000000) {
			accountnumber+=1000000;
			
		}
		int pin=random.nextInt(10000);
		if(pin<1000) {
			pin+=1000;
		}
	
	if(customerService.updateAccountNumberAndPinByUsingAadharNumber(accountnumber, pin,customerDetails.getCustomer_aadhar_number() )) {
		System.out.println("customer Name:"+customerDetails.getCustomer_name());
		System.out.println("Account Number:"+accountnumber);
		System.out.println("pin:"+pin);
	}else {
		System.out.println("server 500 error");
	}
	}
}
