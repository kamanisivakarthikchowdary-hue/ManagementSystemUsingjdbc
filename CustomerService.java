package org.bank.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import org.bank.Exception.CustomerInvalidDataException;
import org.bank.dao.CustomerDAO;
import org.bank.dto.CustomerDetails;
import org.bank.dto.TransactionDetails;

public class CustomerService {
	CustomerDetails customerDetails = new CustomerDetails();
	CustomerDAO customerDAO = new CustomerDAO();
	TransactionService transactionService=new TransactionService();
	Scanner sc = new Scanner(System.in);

	public void customerRegistration() {
		List<CustomerDetails> allCustomerDetails = CustomerDAO.getAllCustomerDetails();
		CustomerDAO customerdao = new CustomerDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Customer Name");
		String name = sc.next();
		System.out.println("enter the Customer Emailid");

		boolean status = true;
		while (status) {
			String emailid = sc.next();

			try {

				long emaildcount = allCustomerDetails.stream()
						.filter((customer -> customer.getCustomer_email_id().equals(emailid))).count();
				if (emailid.contains("@gmail.com")) {
					if (emaildcount != 0) {
						throw new CustomerInvalidDataException("Emailid Already Existed");
					} else {
						customerDetails.setCustomer_email_id(emailid);
						status = false;
					}

				} else {
					throw new CustomerInvalidDataException("Invalid emailid");

				}
			} catch (CustomerInvalidDataException e) {
				System.out.println(e.getMsg());
				System.out.println("Re-enter the emailid");
			}
		}
		System.out.println("enter the Customer  MobileNumber");
		long Mobilenumber = sc.nextLong();
		if (Mobilenumber >= 6000000000L && Mobilenumber <= 99999999999L) {

		} else {
			throw new CustomerInvalidDataException("invalid mobile Number");
		}
		System.out.println("Enter customer Aadhar number");
		long aadharNumber = sc.nextLong();
		String aadharStr = String.valueOf(aadharNumber);
		if (aadharStr.length() != 12) {
			throw new CustomerInvalidDataException("Invalid Aadhar number! It should contain exactly 12 digits.");
		}

		System.out.println("Enter customer PAN number");
		String panNumber = sc.next();
		if (panNumber.length() != 10) {
			throw new CustomerInvalidDataException("Invalid PAN! Length should be 10 characters.");
		}

		int upperCount = 0, digitCount = 0;
		for (int i = 0; i < panNumber.length(); i++) {
			char ch = panNumber.charAt(i);
			if (Character.isUpperCase(ch)) {
				upperCount++;
			} else if (Character.isDigit(ch)) {
				digitCount++;
			} else {
				throw new CustomerInvalidDataException(
						"Invalid PAN! It should contain only uppercase letters and digits.");
			}
		}
		if (!(Character.isUpperCase(panNumber.charAt(0)) && Character.isUpperCase(panNumber.charAt(1))
				&& Character.isUpperCase(panNumber.charAt(2)) && Character.isUpperCase(panNumber.charAt(3))
				&& Character.isUpperCase(panNumber.charAt(4)) && Character.isDigit(panNumber.charAt(5))
				&& Character.isDigit(panNumber.charAt(6)) && Character.isDigit(panNumber.charAt(7))
				&& Character.isDigit(panNumber.charAt(8)) && Character.isUpperCase(panNumber.charAt(9)))) {
			throw new CustomerInvalidDataException("Invalid PAN format! Example: ASDFG2345E");
		}

		System.out.println("enter the Customer address");
		String address = sc.next();
		System.out.println("enter Customer Designation");
		String designation = sc.next();
		System.out.println("Enter customer gender (Male/Female/Others)");
		String gender = sc.next();
		if (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")
				|| gender.equalsIgnoreCase("Others"))) {
			throw new CustomerInvalidDataException("Invalid gender! Must be Male, Female, or Others.");
		}

		System.out.println("enter the type of Account");
		String typeOfAccount = sc.next();
		System.out.println("enter the   Amount");
		double amount = sc.nextDouble();
		System.out.println("enter the if IFSC_Code");
		String IFSC_Code = sc.next();
		System.out.println("enter the branch");
		String branch = sc.next();

		CustomerDetails customerdetail = new CustomerDetails();
		customerdetail.setCustomer_name(name);
		customerdetail.setCustomer_aadhar_number(aadharNumber);
		customerdetail.setCustomer_address(address);
		customerdetail.setAmount(amount);
		customerdetail.setCustomer_mobile_number(Mobilenumber);
		customerdetail.setCustomer_designation(designation);
		customerdetail.setGender(gender);
		customerdetail.setCustomer_pan_number(panNumber);
		customerdetail.setIFSC_Code(IFSC_Code);
		customerdetail.setBranch(branch);
		customerdetail.setType_Of_account(typeOfAccount);
		// CustomerDAO
		customerdao.insertCustomerDetails(customerdetail);

	}

	public void customerlogin() {
		System.out.println("enter Customer Emailid or mobile number");
		String emailidormobile = sc.next();

		System.out.println("enter Customer pin");
		int pin = sc.nextInt();
		CustomerDetails login = customerDAO.getCustomerDetailsByUsingEmailidORMobileNumberAndpin(emailidormobile, pin);
		if (login != null) {
			if (login.getGender().equalsIgnoreCase("male")) {
				System.out.println("Welcame MR:-" + login.getCustomer_name());
				customerOperation(login.getCustomer_account_number());
			}
			if (login.getGender().equalsIgnoreCase("female")) {
				System.out.println("welcome Miss:-" + login.getCustomer_name());
				customerOperation(login.getCustomer_account_number());
			}
		} else {
			System.out.println("invalid data");
		}
	}

	/********/

	public void customerOperation(long accountnumber) {
		System.out.println("Enter \n 1.forCredit \n 2. for Debit \n " + "3.for check Balance \n 4.forStatment"
				+ " \n 5.forCloseAccount\n" + " 6.forChange PIN");
		switch (sc.nextInt()) {
		case 1:
			System.out.println("credit");
			break;
		case 2:
			System.out.println("Debit");
			debit(accountnumber);
			break;
		case 3:
			System.out.println("Check Balance");
			break;
		case 4:
			System.out.println("Statement");
			break;
		case 5:
			System.out.println("close Account");
			break;
		case 6:
			System.out.println("change PIN");
			break;
		default:
			System.out.println("Invalid Requst");
		}
	}

	public void debit(long databaseaccountnumber) {
		System.out.println("Enter Customer Account Number");
		long useraccountNumber = sc.nextLong();
		CustomerDetails details = CustomerDAO.getCustomerDetailsByUsingAccountNumber(useraccountNumber);
		if (details != null && databaseaccountnumber == useraccountNumber) {
			System.out.println("enter Amount to be DEBITED");
			double userAmount = sc.nextDouble();
			double databaseamount = details.getAmount();

			if (userAmount <= databaseamount) {
				double balanceamount = databaseamount - userAmount;
				/******** --updating the balance amount ***/
				
				if (customerDAO.updateAmountByUsingAccountNumber(useraccountNumber, balanceamount)) {
					TransactionDetails transactionDetails=new TransactionDetails();
					transactionDetails.setTransactiontype("DEBIT");
					transactionDetails.setTransactionDate(LocalDate.now());
					transactionDetails.setTransactionTime(LocalTime.now());
					transactionDetails.setTransactionAmount(userAmount);
					
					transactionDetails.setBalance(balanceamount);
					transactionDetails.setAccountNumber(useraccountNumber);

					transactionService.insertTransactionDetails(transactionDetails);
					
					System.out.println(userAmount + " Rupess Detited Sucesssfully........");
				} else {
					System.out.println("Server 500");
				}
			} else {
				System.out.println("In-Sufficient Balance");
			}

		} else {
			System.out.println("invalid Account number");
		}
	}
	public List<CustomerDetails> getAllCustomerDetailsByUsingAccountNumberAndPin(){
		List <CustomerDetails> list=customerDAO.selectCustomerDetailsByUsingAccountNumberandpin();
		if(list.isEmpty()) {
			return list;
		}else {
			/*Throw the Exception*/
			return null;
		}
	}
	public boolean updateAccountNumberAndPinByUsingAadharNumber(long accountnumber,int pin ,long aadharnumber) {
		return customerDAO.updateCustomerAccountNumberAndPinByUsingAadharNumber(accountnumber, pin, aadharnumber);
	}
}
