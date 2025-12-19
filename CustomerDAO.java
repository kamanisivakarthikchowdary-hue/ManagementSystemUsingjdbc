package org.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bank.dto.CustomerDetails;

public class CustomerDAO {
	private static final String insert_customer_detail = "insert into bank_customer_details( Customer_name, Customer_Mobile_Number, Customer_Aadhar_number, Customer_pan_Number, Customer_Email_id, Customer_address, Customer_Designation, IFSC_Code, Branch, Type_Of_Account, Amount, Gender)"
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String selectall = "select * from bank_customer_details";
	private static final String customerLogin = "select * from bank_customer_details where( Customer_Email_id=? or Customer_Mobile_Number=? )and Customer_pin=?";
	private static final String get_By_Using_Account_Number = "select * from bank_customer_details where Customer_Account_Number=?";
	private static final String update_amount = "update bank_customer_details set Amount=? where Customer_Account_Number=?";
private static final String select_customer_by_ac_pin="select * from bank_customer_details where Customer_Account_Number is null and Customer_pin is null";
private static final String Update_ac_pin="update bank_customer_details set Customer_Account_Number=?,Customer_pin=? where Customer_Aadhar_number=?";
	public void insertCustomerDetails(CustomerDetails customerDetail) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/a15_bank_management_system?user=root& password=root");
			PreparedStatement preparedstatement = connection.prepareStatement(insert_customer_detail);
			preparedstatement.setString(1, customerDetail.getCustomer_name());
			preparedstatement.setLong(2, customerDetail.getCustomer_mobile_number());
			preparedstatement.setLong(3, customerDetail.getCustomer_aadhar_number());
			preparedstatement.setString(4, customerDetail.getCustomer_pan_number());
			preparedstatement.setString(5, customerDetail.getCustomer_email_id());

			preparedstatement.setString(6, customerDetail.getCustomer_address());

			preparedstatement.setString(7, customerDetail.getCustomer_designation());

			preparedstatement.setString(8, customerDetail.getIFSC_Code());

			preparedstatement.setString(9, customerDetail.getBranch());

			preparedstatement.setString(10, customerDetail.getType_Of_account());

			preparedstatement.setDouble(11, customerDetail.getAmount());

			preparedstatement.setString(12, customerDetail.getGender());
			int result = preparedstatement.executeUpdate();
			if (result != 0) {
				System.out.println("Customer Registrantion Sucessfull");
			} else {
				System.err.println("Service  500 error");
			}
			System.out.println("ok:result:" + result);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<CustomerDetails> getAllCustomerDetails() {
		/* select *from bank_Customer_details */
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connections = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/a15_bank_management_system?user=root& password=root");
			PreparedStatement preparedstatement = connections.prepareStatement(selectall);
			ResultSet resultSet = preparedstatement.executeQuery();
			List<CustomerDetails> listOfCustomerDetails = new ArrayList<CustomerDetails>();
			if (resultSet.isBeforeFirst()) {
				while (resultSet.next()) {
					CustomerDetails customerDetails = new CustomerDetails();
					customerDetails.setCustomer_aadhar_number(resultSet.getLong("Customer_Aadhar_number"));
					customerDetails.setCustomer_pan_number(resultSet.getString("Customer_pan_Number"));

					customerDetails.setCustomer_mobile_number(resultSet.getLong("Customer_Mobile_Number"));

					customerDetails.setCustomer_email_id(resultSet.getString("Customer_Email_id"));

					listOfCustomerDetails.add(customerDetails);
				}
				return listOfCustomerDetails;
			}

			else {
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public CustomerDetails getCustomerDetailsByUsingEmailidORMobileNumberAndpin(String emailidormobilenumbr, int pin) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/a15_bank_management_system?user=root& password=root");
			PreparedStatement preparedstatement = connection.prepareStatement(customerLogin);
			preparedstatement.setString(1, emailidormobilenumbr);
			preparedstatement.setString(2, emailidormobilenumbr);

			preparedstatement.setInt(3, pin);
			ResultSet resultSet = preparedstatement.executeQuery();
			if (resultSet.next()) {
				CustomerDetails customerdetail = new CustomerDetails();
				customerdetail.setGender(resultSet.getString("Gender"));

				customerdetail.setCustomer_name(resultSet.getString("Customer_name"));
				customerdetail.setCustomer_account_number(resultSet.getLong("Customer_Account_Number"));
				return customerdetail;

			} else {
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static CustomerDetails getCustomerDetailsByUsingAccountNumber(long accountNumber) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/a15_bank_management_system?user=root& password=root");

			PreparedStatement preparedstatement = connection.prepareStatement(get_By_Using_Account_Number);
			preparedstatement.setLong(1, accountNumber);
			ResultSet resultSet = preparedstatement.executeQuery();
			if (resultSet.next()) {
				CustomerDetails customerDetails = new CustomerDetails();
				customerDetails.setAmount(resultSet.getDouble("Amount"));// Amount
				return customerDetails;
			} else {
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.getStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean updateAmountByUsingAccountNumber(long accountnumber,double balanceamount) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/a15_bank_management_system?user=root& password=root");
			PreparedStatement preparedStatement=connection.prepareStatement(update_amount);
			 preparedStatement.setDouble(1, balanceamount);
			 preparedStatement.setLong(2, accountnumber);
			 int result=preparedStatement.executeUpdate();
			 if(result!=0) {
				 return true;
				 
			 }else {
				 return false;
			 }
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}catch(SQLException s) {
			s.printStackTrace();
			return false;
		}
		
	}
	public List<CustomerDetails> selectCustomerDetailsByUsingAccountNumberandpin(){
		/* select * from bank_Customer_details where Customer_Account_number is null and Customer_pin is null*/
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/a15_bank_management_system?user=root& password=root");
			PreparedStatement preparedStatement=connection.prepareStatement(select_customer_by_ac_pin);
			 ResultSet resultSet=preparedStatement.executeQuery();

			 List<CustomerDetails> listOfCustomerDetails=new ArrayList<CustomerDetails>();
			 if(resultSet.isBeforeFirst()) {
				 while(resultSet.next()) {
					 CustomerDetails customerDetails=new CustomerDetails();
					 customerDetails.setCustomer_name(resultSet.getString("Customer_name")) ;
					 customerDetails.setCustomer_aadhar_number(resultSet.getLong("Customer_Aadhar_number"));
					 customerDetails.setCustomer_pan_number(resultSet.getString("Customer_pan_Number"));
					 
					 customerDetails.setCustomer_mobile_number(resultSet.getLong("Customer_Mobile_Number"));
					 
					 customerDetails.setCustomer_email_id(resultSet.getString("Customer_Email_id"));
					 listOfCustomerDetails.add(customerDetails);
					 
				 }
				 return listOfCustomerDetails;
			 }else {
				 return null;
			 }
		} catch (ClassNotFoundException| SQLException e) {
		
			e.printStackTrace();
			return null;

		}
		

	}
	
	
	public boolean updateCustomerAccountNumberAndPinByUsingAadharNumber(long accountnumber,int pin,long aadharnumber) {
		/*
		 * update bank_ccustomer_details set customer_Account_number=?,
		 * customer_pin=? where Customer_Aadhar_number=?
		 */
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/a15_bank_management_system?user=root& password=root");
			PreparedStatement preparedStatement=connection.prepareStatement(Update_ac_pin);
			
			preparedStatement.setLong(1, accountnumber);
			preparedStatement.setInt(2, pin);
			preparedStatement.setLong(3, aadharnumber);
			int result=preparedStatement.executeUpdate();
			if(result!=0) {
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException|SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
}
